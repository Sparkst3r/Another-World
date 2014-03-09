package com.sparkst3r.anotherworld.mechanical.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.sparkst3r.anotherworld.api.tool.IToolDismantleable;
import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.mechanical.MechanicalValues;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileManualCrusher;
import com.sparkst3r.anotherworld.network.packet.PacketManualCrusher;
import com.sparkst3r.anotherworld.util.EntityUtils;
import com.sparkst3r.anotherworld.util.ItemStackUtils;
import com.sparkst3r.anotherworld.util.MathUtils;
import com.sparkst3r.anotherworld.util.WorldUtils;
import com.sparkst3r.anotherworld.util.basic.BasicBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockManualCrusher extends BasicBlock implements IToolDismantleable {

	//public int clickState = 0;
	
	/**
	 * Icon Buffer
	 */
	@SideOnly(Side.CLIENT)
	public static IIcon[] iconBuffer;
	
	
	public String[] sides = new String[] {"manualCrusher_bottom","manualCrusher_top","manualCrusher_side1","manualCrusher_side2","manualCrusher_side3","manualCrusher_side4"};
	
	public BlockManualCrusher() {
		super(Material.rock, "blockHandCrusher");
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
				int clickState = 0;
				return iconBuffer[2 + clientWorld.getBlockMetadata(x, y, z)];
		}
	}
	
    public static void updateBlockState(int state, World world, int x, int y, int z) {
        TileEntity tileentity = world.getTileEntity(x, y, z);
        
        world.setBlock(x, y, z, MechanicalValues.BlockManualCrusherField, state, 2);
        
        if (tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(x, y, z, tileentity);
        }
    }
	
	//public void updateClickFromPacket(EntityPlayer player, int x, int y, int z, int clickState) {
	////	this.clickState = clickState;
	//	player.worldObj.markBlockForUpdate(x, y, z);
	//}
	
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

	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float locX, float locY, float locZ) {
		if (WorldUtils.isServerSide(world)) {
			if (world.getTileEntity(x, y, z) instanceof TileManualCrusher) {
				TileManualCrusher tile = (TileManualCrusher) world.getTileEntity(x, y, z);
				
				/* Drop output when sneaking */
				if (player.isSneaking() && tile.getStackInSlot(1) != null) {
					EntityUtils.dropItemInWorld(world, x, y, z, tile.getStackInSlot(1));
					tile.setInventorySlotContents(1, null);
				}
				/* Drop input when sneaking */
				else if (player.isSneaking() && tile.getStackInSlot(0) != null) {
					EntityUtils.dropItemInWorld(world, x, y, z, tile.getStackInSlot(0));
					tile.setInventorySlotContents(0, null);
				}
				
				/* Add input stack */
				if(!player.isSneaking() 
						&& tile.getStackInSlot(0) != null 
						&& player.getCurrentEquippedItem() != null
						&& ItemStackUtils.areStacksOfSameType(tile.getStackInSlot(0), player.getCurrentEquippedItem())
						&& tile.getStackInSlot(0).stackSize < 4) {
							ItemStack tempStack = player.getCurrentEquippedItem().copy();
							tile.getStackInSlot(0).stackSize += tempStack.stackSize;
							player.getCurrentEquippedItem().stackSize -= 1;
							if (player.getCurrentEquippedItem().stackSize == 0) {
								player.setItemInUse(null, 0);
							}
					return true;
				}
				else if (tile.getStackInSlot(0) == null && player.getCurrentEquippedItem() != null) {
					ItemStack tempStack = player.getCurrentEquippedItem().copy();
					tempStack.stackSize = 1;
					tile.setInventorySlotContents(0, tempStack);
					player.getCurrentEquippedItem().stackSize -= 1;
					if (player.getCurrentEquippedItem().stackSize == 0) {
						player.setItemInUse(null, 0);
					}

					return true;
				}
				
				/* Add click to crusher */
				if (tile.getStackInSlot(0) != null) {
					tile.clickState += 1;
					world.markBlockForUpdate(x, y, z);
					return true;
				}
			}
		}	
		return true;
	}
	
	/** Called when the block is broken. Drops the contents of the TileEntity when a block is broken */
	/*public void breakBlock(World world, int x, int y, int z, int block, int meta) {
		if(meta == 0) {
			TileManualCrusher tile = (TileManualCrusher) world.getTileEntity(x, y, z);
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
	*/
	
	
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

	@Override
	public boolean canDismantle(EntityPlayer player, World world, int x, int y, int z) {
		return true;
	}

	@Override
	public ItemStack dismantle(EntityPlayer player, World world, int x, int y, int z) {
		return new ItemStack(this, 1, 0);
	}

	//TODO Fix for CoFH dismantle
	//@Override
	//public ItemStack dismantleBlock(EntityPlayer thePlayer, World world, int x, int y, int z, boolean returnBlock) {
	//	return this.dismantle(thePlayer, world, x, y, z);
	//}
	
	
}
