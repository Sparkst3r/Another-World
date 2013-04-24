package mods.anotherworld.mechanical.util;

import mods.anotherworld.mechanical.MechanicalValues;
import mods.anotherworld.util.WorldUtils;
import net.minecraft.world.World;
/**
 * Validation methods for the Mechanics Table
 * @author Sparkst3r
 */
public class MechanicsTableValidation {
	
	/**
	 * Attempts to validate a Mechanics Table based on the last block placed
	 * 
	 * @param world World the block is placed in
	 * @param x X position of the block placed
	 * @param y Y position of the block placed
	 * @param z Z position of the block placed
	 * @return Returns the configuration. Returns -1 if not valid.
	 */
	
	public static int validateBlocks(World world, int x, int y, int z) {


		/* Valid for configuration 0 */
		if (	WorldUtils.isBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x + 1, y, z, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x, y, z + 1, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x + 1, y, z + 1, MechanicalValues.BlockBasePartsField, 1)) {
			return 0;
			}
		/* Valid for configuration 1 */
		if (	WorldUtils.isBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x, y, z + 1, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x - 1, y, z, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x - 1, y, z + 1, MechanicalValues.BlockBasePartsField, 1)) {
			return 1;
			}
		
		/* Valid for configuration 2 */
		if (	WorldUtils.isBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x + 1, y, z, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x, y, z - 1, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x + 1, y, z - 1, MechanicalValues.BlockBasePartsField, 1)) {
			return 2;
			}
		

		/* Valid for configuration 3 */
		if (	WorldUtils.isBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x - 1, y, z, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x, y, z - 1, MechanicalValues.BlockBasePartsField, 1) &&
				WorldUtils.isBlockAt(world, x - 1, y, z - 1, MechanicalValues.BlockBasePartsField, 1)) {
			return 3;
			}
		
		return -1;
		
	}
	
	/**
	 * Converts the single block table to the 4 correct blocks based on a startBlock
	 * 
	 * @param world
	 * @param xPosition
	 * @param yPosition
	 * @param zPosition
	 * @param startBlock
	 */
	public static void placeTable(World world, int x, int y, int z, int startBlock) {
		switch(startBlock) {
			case 0:
				WorldUtils.setBlockAt(world, x, y, z, MechanicalValues.BlockMechTablePartsField, 0, false);
				WorldUtils.setBlockAt(world, x + 1, y, z, MechanicalValues.BlockMechTablePartsField, 1, false);
				WorldUtils.setBlockAt(world, x, y, z + 1, MechanicalValues.BlockMechTablePartsField, 2, false);
				WorldUtils.setBlockAt(world, x + 1, y, z + 1, MechanicalValues.BlockMechTablePartsField, 3, false);
				break;
			
			case 1:
				WorldUtils.setBlockAt(world, x, y, z, MechanicalValues.BlockMechTablePartsField, 1, false);
				WorldUtils.setBlockAt(world, x, y, z + 1, MechanicalValues.BlockMechTablePartsField, 3, false);
				WorldUtils.setBlockAt(world, x - 1, y, z, MechanicalValues.BlockMechTablePartsField, 0, false);
				WorldUtils.setBlockAt(world, x - 1, y, z + 1, MechanicalValues.BlockMechTablePartsField, 2, false);
				break;
				
			case 2:
				WorldUtils.setBlockAt(world, x, y, z, MechanicalValues.BlockMechTablePartsField, 2, false);
				WorldUtils.setBlockAt(world, x + 1, y, z, MechanicalValues.BlockMechTablePartsField, 3, false);
				WorldUtils.setBlockAt(world, x, y, z - 1, MechanicalValues.BlockMechTablePartsField, 0, false);
				WorldUtils.setBlockAt(world, x + 1, y, z - 1, MechanicalValues.BlockMechTablePartsField, 1, false);
				break;
				
			case 3:
				WorldUtils.setBlockAt(world, x, y, z, MechanicalValues.BlockMechTablePartsField, 3, false);
				WorldUtils.setBlockAt(world, x - 1, y, z, MechanicalValues.BlockMechTablePartsField, 2, false);
				WorldUtils.setBlockAt(world, x, y, z - 1, MechanicalValues.BlockMechTablePartsField, 1, false);
				WorldUtils.setBlockAt(world, x - 1, y, z - 1, MechanicalValues.BlockMechTablePartsField, 0, false);
				break;
				
		}
	}
	
	
	/**
	 * Converts the multi-block table to air based on a startBlock
	 * 
	 * @param world
	 * @param xPosition
	 * @param yPosition
	 * @param zPosition
	 * @param startBlock
	 */
	public static void breakTableCompletely(World world, int x, int y, int z, int startBlock) {
		switch(startBlock) {
			case 0:
				world.setBlockToAir(x, y, z);
				world.setBlockToAir(x + 1, y, z);
				world.setBlockToAir(x, y, z + 1);
				world.setBlockToAir(x + 1, y, z + 1);
				break;
			case 1:
				world.setBlockToAir(x, y, z);
				world.setBlockToAir(x, y, z + 1);
				world.setBlockToAir(x - 1, y, z);
				world.setBlockToAir(x - 1, y, z + 1);
				break;
				
			case 2:
				world.setBlockToAir(x, y, z);
				world.setBlockToAir(x + 1, y, z);
				world.setBlockToAir(x, y, z - 1);
				world.setBlockToAir(x + 1, y, z - 1);
				break;
				
			case 3:
				world.setBlockToAir(x, y, z);
				world.setBlockToAir(x - 1, y, z);
				world.setBlockToAir(x, y, z - 1);
				world.setBlockToAir(x - 1, y, z - 1);
				break;
		}
	}
	
	/**
	 * Converts the multi-block table to 4 mechanic blocks based on a startBlock
	 * 
	 * @param world
	 * @param xPosition
	 * @param yPosition
	 * @param zPosition
	 * @param startBlock
	 */
	public static void breakTable(World world, int x, int y, int z, int startBlock) {
		switch(startBlock) {
			case 0:
				WorldUtils.setBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x + 1, y, z, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x, y, z + 1, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x + 1, y, z + 1, MechanicalValues.BlockBasePartsField, 1, false);
				break;
			case 1:
				WorldUtils.setBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x, y, z + 1, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x - 1, y, z, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x - 1, y, z + 1, MechanicalValues.BlockBasePartsField, 1, false);
				break;
				
			case 2:
				WorldUtils.setBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x + 1, y, z, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x, y, z - 1, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x + 1, y, z - 1, MechanicalValues.BlockBasePartsField, 1, false);
				break;
				
			case 3:
				WorldUtils.setBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x - 1, y, z, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x, y, z - 1, MechanicalValues.BlockBasePartsField, 1, false);
				WorldUtils.setBlockAt(world, x - 1, y, z - 1, MechanicalValues.BlockBasePartsField, 1, false);
				break;
		}
	}
	

	/**
	 * Known start block version of validateTable
	 * 
	 * @param world World the block is placed in
	 * @param xPosition X position of the block placed
	 * @param yPosition Y position of the block placed
	 * @param zPosition Z position of the block placed
	 * @param startBlock
	 * @return boolean is the table valid for this startBlock
	 
	public static boolean validateTableForBlock(World world, int xPosition, int yPosition, int zPosition, int startBlock) {
		switch(startBlock) {
			case 0:
				/*
				 * Valid for configuration 1
				 
				if (world.getBlockId(xPosition - 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlockField.blockID && 
					world.getBlockId(xPosition, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlockField.blockID &&
					world.getBlockId(xPosition - 1, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlockField.blockID) {
					return true;
					}
			case 1:
				/*
				 * Valid for configuration 2
				 
				if (world.getBlockId(xPosition, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlockField.blockID && 
					world.getBlockId(xPosition + 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlockField.blockID &&
					world.getBlockId(xPosition + 1, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlockField.blockID) {	
					return true;
					}
			case 2:
				/*
				 * Valid for configuration 3
				 
				if (world.getBlockId(xPosition - 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlockField.blockID && 
					world.getBlockId(xPosition, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlockField.blockID &&
					world.getBlockId(xPosition - 1, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlockField.blockID) {
					return true;
					}
			case 3:
				/*
				 * Valid for configuration 4
				 
				if (world.getBlockId(xPosition + 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlockField.blockID && 
					world.getBlockId(xPosition, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlockField.blockID &&
					world.getBlockId(xPosition + 1, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlockField.blockID) {
					return true;
					}
		}
		return false;
	}

*/
	public static boolean validateBlocksForCompleted(World world, int x, int y, int z, int startblock) {


		/* Valid for configuration 0 */
		if (startblock == 0 &&
				WorldUtils.isBlockAt(world, x, y, z, MechanicalValues.BlockMechTablePartsField, 0) &&
				WorldUtils.isBlockAt(world, x + 1, y, z, MechanicalValues.BlockMechTablePartsField, 1) &&
				WorldUtils.isBlockAt(world, x, y, z + 1, MechanicalValues.BlockMechTablePartsField, 2) &&
				WorldUtils.isBlockAt(world, x + 1, y, z + 1, MechanicalValues.BlockMechTablePartsField, 3)) {
			return true;
			}
		/* Valid for configuration 1 */
		if (startblock == 1 &&
				WorldUtils.isBlockAt(world, x, y, z, MechanicalValues.BlockMechTablePartsField, 1) &&
				WorldUtils.isBlockAt(world, x, y, z + 1, MechanicalValues.BlockMechTablePartsField, 3) &&
				WorldUtils.isBlockAt(world, x - 1, y, z, MechanicalValues.BlockMechTablePartsField, 0) &&
				WorldUtils.isBlockAt(world, x - 1, y, z + 1, MechanicalValues.BlockMechTablePartsField, 2)) {
			return true;
			}
		
		/* Valid for configuration 2 */
		if (startblock == 2 &&
				WorldUtils.isBlockAt(world, x, y, z, MechanicalValues.BlockMechTablePartsField, 2) &&
				WorldUtils.isBlockAt(world, x + 1, y, z, MechanicalValues.BlockMechTablePartsField, 3) &&
				WorldUtils.isBlockAt(world, x, y, z - 1, MechanicalValues.BlockMechTablePartsField, 0) &&
				WorldUtils.isBlockAt(world, x + 1, y, z - 1, MechanicalValues.BlockMechTablePartsField, 1)) {
			return true;
			}
		

		/* Valid for configuration 3 */
		if (startblock == 3 &&
				WorldUtils.isBlockAt(world, x, y, z, MechanicalValues.BlockMechTablePartsField, 3) &&
				WorldUtils.isBlockAt(world, x - 1, y, z, MechanicalValues.BlockMechTablePartsField, 2) &&
				WorldUtils.isBlockAt(world, x, y, z - 1, MechanicalValues.BlockMechTablePartsField, 1) &&
				WorldUtils.isBlockAt(world, x - 1, y, z - 1, MechanicalValues.BlockMechTablePartsField, 0)) {
			return true;
			}
		
		return false;
		
	}
}

