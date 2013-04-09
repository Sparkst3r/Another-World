package mods.AnotherWorld.Mechanical.Util;

import java.util.List;

import cpw.mods.fml.common.FMLLog;

import mods.AnotherWorld.Mechanical.MechanicalValues;
import mods.AnotherWorld.Util.EntityUtils;
import mods.AnotherWorld.Util.WorldUtils;
import mods.AnotherWorld.World.WorldValues;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

/** 
 * Handles tool actions
 * @author Sparkst3r
 *
 */
public class ItemToolUsedHelper {	
	
	/** Called when the activation tool is used on a block */
	public static boolean activationToolUsed(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
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
								FMLLog.warning("Got the Gear");
							}
							else if (item.getEntityItem().stackSize > 1){
								gotGear = true;
								gearItem = item;
								gearRequiresDec = true;
								FMLLog.warning("Got the Gear");
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
	
	public static boolean helperToolUsed(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		return false;
		
	}
}
