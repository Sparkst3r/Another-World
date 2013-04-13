package mods.AnotherWorld.Mechanical.Util;

import java.util.List;

import cpw.mods.fml.common.FMLLog;

import mods.AnotherWorld.Mechanical.MechanicalValues;
import mods.AnotherWorld.Util.EntityUtils;
import mods.AnotherWorld.Util.WorldUtils;
import mods.AnotherWorld.World.WorldValues;
import mods.AnotherWorld.api.tool.IDismantleable;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

/** 
 * Handles tool actions
 * @author Sparkst3r
 *
 */
public class ItemToolUsedHelper {
	public static ItemToolUsedHelper instance = new ItemToolUsedHelper();
	
	/** Called when the activation tool is used on a block */
	public boolean activationToolUsed(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		if(player.isSneaking() && !world.isRemote) {
			
			/** Attempts to validate a table */
			if(WorldUtils.isBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 1)) {
				MechanicsTableValidation.placeTable(world, x, y, z, MechanicsTableValidation.validateBlocks(world, x, y, z));
			}
			
			/** Attempts to create a mechanics block */
			if(WorldUtils.isBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 0)) {
				boolean gotGear = false;
				boolean gotCopper = false;
				boolean copperRequiresKill = false;
				boolean gearRequiresKill = false;
				boolean copperRequiresDec = false;
				boolean gearRequiresDec = false;

				EntityItem copperItem = null;
				EntityItem gearItem = null;
				
				List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox((double) (x - 2), (double) (y), (double) (z - 2), (double) (x + 2), (double) (y + 2), (double) (z + 2)));
				
				for (EntityItem item : items) {
					if (!gotGear) {
						if (EntityUtils.isEntityItem(item, MechanicalValues.ItemBasePartsField, 0)) {
							if(item.getEntityItem().stackSize == 1) {
								gotGear = true;
								gearItem = item;
								gearRequiresKill = true;
							}
							else if (item.getEntityItem().stackSize > 1){
								gotGear = true;
								gearItem = item;
								gearRequiresDec = true;
							}

						}
					}
					
					if (!gotCopper) {
						if (EntityUtils.isEntityItem(item, WorldValues.ItemIngotField, 0)) {
							int stackSize = item.getEntityItem().stackSize;
							if (stackSize > 4){
								gotCopper = true;
								copperItem = item;
								copperRequiresDec = true;
								FMLLog.warning("Got copper");
							}
							else if(stackSize == 4) {
								gotCopper = true;
								copperItem = item;
								copperRequiresKill = true;
								FMLLog.warning("Got copper");
							}


						}
					}
					
					if (gotCopper && gotGear) {
						if(gearRequiresKill) gearItem.setDead();
						if(copperRequiresKill) copperItem.setDead();
						if(gearRequiresDec) gearItem.getEntityItem().stackSize -= 1;
						if(copperRequiresDec) copperItem.getEntityItem().stackSize -= 4;
						
						WorldUtils.setBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 1, false);
					}
				}

			}
		}
		return true;
	}
	
	
	public void dismantleToolUsed(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		int blockId = world.getBlockId(x, y, z);
		
		if (blockId > 0 && Block.blocksList[blockId] instanceof IDismantleable) {
			if (((IDismantleable)Block.blocksList[blockId]).canDismantle(player, world, x, y, z)) {
				ItemStack blockStack = ((IDismantleable)Block.blocksList[blockId]).dismantle(player, world, x, y, z);
				if(!world.isRemote) {
					world.setBlock(x, y, z, 0, 0, 2);
					EntityUtils.dropItemInWorld(world, x, y, z, blockStack);
				}
			}	
		}
	}
	
	
	public boolean moveToolUsed(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		/*if (world.blockHasTileEntity(x, y, z)) {
			TileEntity testE = world.getBlockTileEntity(x, y, z);
			
		}*/

		
		
		if (!stack.stackTagCompound.hasKey("hasBlock")) {
			stack.stackTagCompound.setBoolean("hasBlock", false);
		}
		
		if (stack.stackTagCompound.getBoolean("hasBlock") == false && !world.blockHasTileEntity(x, y, z)){
			stack.stackTagCompound.setBoolean("hasBlock", true);
			stack.stackTagCompound.setInteger("block", world.getBlockId(x, y, z));
			stack.stackTagCompound.setInteger("metadata", world.getBlockMetadata(x, y, z));
			

			world.setBlockToAir(x, y, z);
			for (int i = 0; i < 27; i++) {
        		double xStart = (x + 0.1) + Math.random() / 0.9;
        		double zStart = (z + 0.1) + Math.random() / 0.9;
				world.spawnParticle("portal", xStart, y, zStart, 0.0F, 0.0F, 0.0F);
				world.playSoundEffect((double) x, (double) y, (double) z, "mob.endermen.portal", 0.05F, 1.0F);
			}
			
			
		}
		else if(stack.stackTagCompound.getBoolean("hasBlock")) {
			switch(side) {
				case 0:
					world.setBlock(x, y - 1, z, stack.stackTagCompound.getInteger("block"), stack.stackTagCompound.getInteger("metadata"), 2);
					stack.stackTagCompound.setBoolean("hasBlock", false);
					break;
				case 1:
					world.setBlock(x, y + 1, z, stack.stackTagCompound.getInteger("block"), stack.stackTagCompound.getInteger("metadata"), 2);
					stack.stackTagCompound.setBoolean("hasBlock", false);
					break;
				case 2:
					world.setBlock(x, y, z - 1, stack.stackTagCompound.getInteger("block"), stack.stackTagCompound.getInteger("metadata"), 2);
					stack.stackTagCompound.setBoolean("hasBlock", false);
					break;
				case 3:
					world.setBlock(x, y, z + 1, stack.stackTagCompound.getInteger("block"), stack.stackTagCompound.getInteger("metadata"), 2);
					stack.stackTagCompound.setBoolean("hasBlock", false);
					break;
				case 4:
					world.setBlock(x - 1, y, z, stack.stackTagCompound.getInteger("block"), stack.stackTagCompound.getInteger("metadata"), 2);
					stack.stackTagCompound.setBoolean("hasBlock", false);
					break;
				case 5:
					world.setBlock(x + 1, y, z, stack.stackTagCompound.getInteger("block"), stack.stackTagCompound.getInteger("metadata"), 2);
					stack.stackTagCompound.setBoolean("hasBlock", false);
					break;
			}
		}
		

		
		return true;
	}


}
