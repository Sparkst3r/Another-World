package com.sparkst3r.anotherworld.mechanical.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cofh.api.block.IDismantleable;

import com.sparkst3r.anotherworld.api.tool.IToolDismantleable;
import com.sparkst3r.anotherworld.core.AnotherWorldTab;
import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.mechanical.MechanicalValues;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileManualCrusher;
import com.sparkst3r.anotherworld.util.EntityUtils;
import com.sparkst3r.anotherworld.util.ItemStackUtils;
import com.sparkst3r.anotherworld.util.WorldUtils;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockManualCrusher extends Block implements IToolDismantleable, IDismantleable {
	
	/** Universal identifier */
	public static final String identifier = "mechManualCrusher";
	
	
	/**
	 * Icon Buffer
	 */
	@SideOnly(Side.CLIENT)
	public static IIcon[] iconBuffer;
	
	/** Textures for sides */
	public String[] sides = new String[] {"manualCrusher_bottom","manualCrusher_top","manualCrusher_side1","manualCrusher_side2","manualCrusher_side3","manualCrusher_side4"};

	/** Is a click state change queued */
	private static boolean stateChangeQueued;
	
	/**
	 * Constructor
	 */
	public BlockManualCrusher() {
		super(Material.rock);
        this.setCreativeTab(AnotherWorldTab.TAB);
        this.setHarvestLevel("pickaxe", 3);
        this.setHardness(5F);
		GameRegistry.registerBlock(this, identifier);
		
	}
	
	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister ir) {
		iconBuffer = new IIcon[this.sides.length];
		for (int icon = 0; icon < this.sides.length; icon++) {
			iconBuffer[icon] = ir.registerIcon(GlobalValues.TEXTURE + this.sides[icon]);
		}
	}
	
	/** 
	 * Updates the texture in the world. Called when the block is marked for render update
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(IBlockAccess clientWorld, int x, int y, int z, int side) {
		switch (side) {
			case 0:
				return iconBuffer[0];
			case 1:
				return iconBuffer[1];
			default:
				return iconBuffer[2 + clientWorld.getBlockMetadata(x, y, z)];
		}
	}
	
	/**
	 * Update the block state from the TileEntity
	 * 
	 * @param state the block state to set
	 * @param world the world object
	 * @param x the X coordinate of the block
	 * @param y the Y coordinate of the block
	 * @param z the Z coordinate of the block
	 */
	public static void updateBlockState(int state, World world, int x, int y, int z) {
    	TileEntity tileentity = world.getTileEntity(x, y, z);
        
    	BlockManualCrusher.stateChangeQueued = true;
    	world.setBlock(x, y, z, MechanicalValues.blockManualCrusher, state, 2);
        
    	if (tileentity != null) {
    		tileentity.validate();
    		world.setTileEntity(x, y, z, tileentity);
    	}
    	BlockManualCrusher.stateChangeQueued = false;
	}
	
	/**
	 * Gets the icon to be rendered in the inventory
	 */
	public IIcon getIcon(int side, int meta) {
		switch (side) {
			case 0:
				return iconBuffer[0];
			case 1:
				return iconBuffer[1];
			default:
				return iconBuffer[2];
		}
	}

	
	/**
	 * Called when the block is right clicked
	 */
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float locX, float locY, float locZ) {
		
		if (WorldUtils.isServerSide(world) && world.getTileEntity(x, y, z) instanceof TileManualCrusher) {
			TileManualCrusher tile = (TileManualCrusher) world.getTileEntity(x, y, z);
			
			/* Drop inventory contents first */
			if (player.isSneaking() && tile.getStackInSlot(TileManualCrusher.OUTPUTSLOT) != null) {
				EntityUtils.dropItemInWorld(world, x, y, z, tile.getStackInSlot(TileManualCrusher.OUTPUTSLOT));
				tile.setInventorySlotContents(TileManualCrusher.OUTPUTSLOT, null);
				return true;
			}
			else if (player.isSneaking() && tile.getStackInSlot(TileManualCrusher.INPUTSLOT) != null) {
				EntityUtils.dropItemInWorld(world, x, y, z, tile.getStackInSlot(TileManualCrusher.INPUTSLOT));
				tile.setInventorySlotContents(TileManualCrusher.INPUTSLOT, null);
				return true;
			}
			
			if (!player.isSneaking()) {
				if (tile.getStackInSlot(TileManualCrusher.INPUTSLOT) == null) {
					if (player.getCurrentEquippedItem() != null) {
						ItemStack playerStack = player.getCurrentEquippedItem();
						ItemStack stack = playerStack.copy();
						stack.stackSize = 1;
						playerStack.stackSize--;
						tile.setInventorySlotContents(TileManualCrusher.INPUTSLOT, stack);
						player.setCurrentItemOrArmor(0, playerStack);
						return true;
					}
				}
				else {
					if (player.getCurrentEquippedItem() != null 
						&& ItemStackUtils.areStacksOfSameType(tile.getStackInSlot(TileManualCrusher.INPUTSLOT), player.getCurrentEquippedItem()) 
						&& tile.getStackInSlot(0).stackSize < 4) {
						tile.getStackInSlot(0).stackSize++;
						player.getCurrentEquippedItem().stackSize--;
						return true;
					}
				}
			}
			
			if (tile.getStackInSlot(TileManualCrusher.INPUTSLOT) != null && tile.getStackInSlot(TileManualCrusher.OUTPUTSLOT) == null) {
				tile.clickState += 1;
				world.markBlockForUpdate(x, y, z);
				return true;
			}
		}
		return false;
	}
	
	/** Called when the block is broken. Drops the contents of the TileEntity when a block is broken */
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if(!stateChangeQueued) {
			TileManualCrusher tile = (TileManualCrusher) world.getTileEntity(x, y, z);
			if (tile != null) {
				for (int slot = 0; slot < tile.getSizeInventory(); slot++) {
					ItemStack stack = tile.getStackInSlot(slot);
					EntityUtils.dropItemInWorld(world, x, y, z, stack);
				}
			}
		}
	}
	
	
	/** Is the meta block allowed to have a tile entity? */
	@Override
	public boolean hasTileEntity(int meta) {
		return true;
	}
    
	/** Will create a tile entity if hasTileEntity(meta) resolves as true for the metadata passed*/
	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new TileManualCrusher();
	}

	/**
	 * Can this block be dismatled by a tool at this location?
	 */
	@Override
	public boolean canDismantle(EntityPlayer player, World world, int x, int y, int z) {
		return true;
	}

	/**
	 * Dismantle the block
	 */
	@Override
	public ItemStack dismantle(EntityPlayer player, World world, int x, int y, int z) {
		return new ItemStack(this, 1);
	}

	/**
	 * Dismantle the block CoFH
	 */
	@Override
	public ItemStack dismantleBlock(EntityPlayer thePlayer, World world, int x, int y, int z, boolean returnBlock) {
		return this.dismantle(thePlayer, world, x, y, z);
	}
	
	/** Returns the unlocalised name of the itemstack */
	@Override
	public String getUnlocalizedName() {
		return "tile." + identifier;
	}
	
}
