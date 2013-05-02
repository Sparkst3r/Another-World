package mods.anotherworld.mechanical.blocks;

import mods.anotherworld.api.tool.IToolDismantleable;
import mods.anotherworld.core.GlobalValues;
import mods.anotherworld.mechanical.crafting.ManualCrusherManager;
import mods.anotherworld.mechanical.crafting.ManualCrusherManager.ManualCrusherRecipe;
import mods.anotherworld.mechanical.tileentity.TileManualCrusher;
import mods.anotherworld.util.EntityUtils;
import mods.anotherworld.util.MathUtils;
import mods.anotherworld.util.WorldUtils;
import mods.anotherworld.util.basic.BasicBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cofh.api.block.IDismantleable;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockManualCrusher extends BasicBlock implements IToolDismantleable, IDismantleable {

	
	/**
	 * Icon Buffer
	 */
	@SideOnly(Side.CLIENT)
	public static Icon[] iconBuffer;
	
	public String[] sides = new String[] {"manualCrusher_bottom","manualCrusher_top","manualCrusher_side1","manualCrusher_side2","manualCrusher_side3","manualCrusher_side4"};
	
	/**
	 * Constructor
	 * @param id
	 */
	public BlockManualCrusher(int id) {
		super(id, Material.rock, "Hand Cranked Crusher", "blockHandCrusher");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[sides.length];
		String id = GlobalValues.ModIDCore + ":"; 
		
		for (int icon = 0; icon < sides.length; icon++) {
			iconBuffer[icon] = ir.registerIcon(id + sides[icon]);
		}	
	}
	
	public IBlockAccess iBlockAccess;
	
	/** 
	 * Updates the texture in the world. Called when the block is marked for render update
	 */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getBlockTexture(IBlockAccess iBlockAccess, int x, int y, int z, int side) {
			this.iBlockAccess = iBlockAccess;
			
			TileManualCrusher tile = (TileManualCrusher) this.iBlockAccess.getBlockTileEntity(x, y, z);
			
			
			switch (side) {
				case 0:
					return iconBuffer[0];
				case 1:
					return iconBuffer[1];
				default:
					return iconBuffer[2 + MathUtils.clampInt(tile.getClicks() / 4, 0, 3)];
			}

	}
	
	/**
	 * Gets the icon to be rendered in the inventory
	 */
	public Icon getIcon(int side, int meta) {
		switch (side) {
			case 0:
				return iconBuffer[0];
			case 1:
				return iconBuffer[1];
			default:
				return iconBuffer[2];

		}
	}

	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par5) {
		TileManualCrusher tileClient = (TileManualCrusher) this.iBlockAccess.getBlockTileEntity(x, y, z);
		TileManualCrusher tileServer = (TileManualCrusher) world.getBlockTileEntity(x, y, z);
		tileServer.tileClient = tileClient;
		tileServer.tileServer = tileServer;
		
		if (WorldUtils.isServerSide(world) && tileClient != null) {
			
			/* If there is a stack in the input slot*/
			if (tileServer.getStackInSlot(0) != null ) {
				ManualCrusherRecipe recipe = ManualCrusherManager.getOutput(tileServer.getStackInSlot(0));
				
				/* If there is a recipe for that input. Increment clicks */
				if (recipe != null) {
					tileClient.setClicks(tileClient.getClicks() + 1);
				}
			}
			else {
				tileClient.setClicks(0);
			}
			
			
			/* Drops the output slot's ItemStack when clicked */
			if (player.isSneaking() && tileServer.getStackInSlot(1) != null) {
				EntityUtils.dropItemInWorld(tileServer.worldObj, tileServer.xCoord, tileServer.yCoord, tileServer.zCoord, tileServer.getStackInSlot(1));
				tileServer.setInventorySlotContents(1, null);
			}
				
			/* Else it will drop what's in the input slot */
			else if (player.isSneaking() && tileServer.getStackInSlot(0) != null) {
				EntityUtils.dropItemInWorld(tileServer.worldObj, tileServer.xCoord, tileServer.yCoord, tileServer.zCoord, tileServer.getStackInSlot(0));
				tileServer.setInventorySlotContents(0, null);
			}
		}
		else if(WorldUtils.isClientSide(world)){
			world.markBlockForRenderUpdate(x, y, z);
		}
		
		return true;
		
	}
	
	/** Called when the block is broken. Drops the contents of the TileEntity when a block is broken */
	public void breakBlock(World world, int x, int y, int z, int block, int meta) {
		if(meta == 0) {
			TileManualCrusher tile = (TileManualCrusher) world.getBlockTileEntity(x, y, z);
			if (tile != null) {
				for (int slot = 0; slot < tile.getSizeInventory(); slot++) {
					ItemStack stack = tile.getStackInSlot(slot);
					EntityUtils.dropItemInWorld(world, x, y, z, stack);
	            }
	        }
			try {
				tile.invalidate();
			}
			catch (NullPointerException e) {
				FMLLog.warning("A block at (" + tile.xCoord + "," + tile.yCoord + "," + tile.zCoord + ") is unable to invalidate a TileEntity");
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
	public TileEntity createTileEntity(World world, int meta){
		return new TileManualCrusher();
	}

	@Override
	public boolean canDismantle(EntityPlayer player, World world, int x, int y, int z) {
		return true;
	}

	@Override
	public ItemStack dismantle(EntityPlayer player, World world, int x, int y, int z) {
		return new ItemStack(this, 1, 0);
	}

	@Override
	public ItemStack dismantleBlock(EntityPlayer thePlayer, World world, int x, int y, int z, boolean returnBlock) {
		return this.dismantle(thePlayer, world, x, y, z);
	}
	
	
}
