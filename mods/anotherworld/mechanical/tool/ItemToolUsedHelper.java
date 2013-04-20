package mods.anotherworld.mechanical.tool;



import mods.anotherworld.mechanical.MechanicalValues;
import mods.anotherworld.mechanical.util.MechanicsTableValidation;
import mods.anotherworld.util.WorldUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
			
			//ItemStack newBlock = WorldCraftingManager.getOutput(world, x, y, z);
			//if (newBlock != null) {
			//	WorldUtils.setBlockAt(world, x, y, z, Block.blocksList[newBlock.itemID], newBlock.getItemDamage(), false);
			//}

			
		}
	
		return true;
	}
	
	
	public void dismantleToolUsed(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		
		
		/*
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
	*/
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
