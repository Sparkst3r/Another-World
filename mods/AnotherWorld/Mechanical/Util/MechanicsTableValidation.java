package mods.AnotherWorld.Mechanical.Util;

import cpw.mods.fml.common.FMLLog;
import mods.AnotherWorld.Mechanical.MechanicalValues;
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
	 * @param xPosition X position of the block placed
	 * @param yPosition Y position of the block placed
	 * @param zPosition Z position of the block placed
	 * @return Returns the last block placed(Indicating the orientation of the table). Will return 5 if not a valid table
	 */
	public static int validateTable(World world, int xPosition, int yPosition, int zPosition) {

		/*
		 * Valid for configuration 1
		 */
		if (world.getBlockId(xPosition - 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlock.blockID && 
			world.getBlockId(xPosition, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlock.blockID &&
			world.getBlockId(xPosition - 1, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlock.blockID) {
			return 0;
			}

		/*
		 * Valid for configuration 2
		 */
		if (world.getBlockId(xPosition, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlock.blockID && 
			world.getBlockId(xPosition + 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlock.blockID &&
			world.getBlockId(xPosition + 1, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlock.blockID) {	
			return 1;
			}


		/*
		 * Valid for configuration 3
		 */
		if (world.getBlockId(xPosition - 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlock.blockID && 
			world.getBlockId(xPosition, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlock.blockID &&
			world.getBlockId(xPosition - 1, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlock.blockID) {
			return 2;
			}	
		
		/*
		 * Valid for configuration 4
		 */
		if (world.getBlockId(xPosition + 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlock.blockID && 
			world.getBlockId(xPosition, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlock.blockID &&
			world.getBlockId(xPosition + 1, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlock.blockID) {
			return 3;
			}	
		
		return 5;
		
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
	public static void changeBlocks(World world, int xPosition, int yPosition, int zPosition, int startBlock) {
		switch(startBlock) {
			case 0: 
				world.setBlock(xPosition, yPosition, zPosition, MechanicalValues.BlockMechTableParts.blockID, 3, 2);	
				world.setBlock(xPosition - 1, yPosition, zPosition, MechanicalValues.BlockMechTableParts.blockID, 2, 2);	
				world.setBlock(xPosition, yPosition, zPosition - 1, MechanicalValues.BlockMechTableParts.blockID, 1, 2);
				world.setBlock(xPosition - 1, yPosition, zPosition - 1, MechanicalValues.BlockMechTableParts.blockID, 0, 2);
				break;
			
			case 1:
				world.setBlock(xPosition, yPosition, zPosition, MechanicalValues.BlockMechTableParts.blockID, 2, 2);
				world.setBlock(xPosition + 1, yPosition, zPosition - 1, MechanicalValues.BlockMechTableParts.blockID, 1, 2);
				world.setBlock(xPosition + 1, yPosition, zPosition, MechanicalValues.BlockMechTableParts.blockID, 3, 2);
				world.setBlock(xPosition, yPosition, zPosition - 1, MechanicalValues.BlockMechTableParts.blockID, 0, 2);
				break;
				
			case 2:   
				world.setBlock(xPosition, yPosition, zPosition, MechanicalValues.BlockMechTableParts.blockID, 1, 2);
				world.setBlock(xPosition - 1, yPosition, zPosition, MechanicalValues.BlockMechTableParts.blockID, 0, 2);
				world.setBlock(xPosition, yPosition, zPosition + 1, MechanicalValues.BlockMechTableParts.blockID, 3, 2);
				world.setBlock(xPosition - 1, yPosition, zPosition + 1, MechanicalValues.BlockMechTableParts.blockID, 2, 2);
				break;
			
			case 3:   
				world.setBlock(xPosition, yPosition, zPosition, MechanicalValues.BlockMechTableParts.blockID, 0, 2);
				world.setBlock(xPosition + 1, yPosition, zPosition, MechanicalValues.BlockMechTableParts.blockID, 1, 2);
				world.setBlock(xPosition, yPosition, zPosition + 1, MechanicalValues.BlockMechTableParts.blockID, 2, 2);
				world.setBlock(xPosition + 1, yPosition, zPosition + 1, MechanicalValues.BlockMechTableParts.blockID, 3, 2);
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
	public static void changeBlocksToSingle(World world, int xPosition, int yPosition, int zPosition, int startBlock) {
		switch(startBlock) {
			case 0: 
				world.setBlock(xPosition, yPosition, zPosition, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);	
				world.setBlock(xPosition - 1, yPosition, zPosition, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);	
				world.setBlock(xPosition, yPosition, zPosition - 1, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				world.setBlock(xPosition - 1, yPosition, zPosition - 1, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				break;
			
			case 1:
				world.setBlock(xPosition, yPosition, zPosition, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				world.setBlock(xPosition + 1, yPosition, zPosition - 1, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				world.setBlock(xPosition + 1, yPosition, zPosition, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				world.setBlock(xPosition, yPosition, zPosition - 1, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				break;
				
			case 2:   
				world.setBlock(xPosition, yPosition, zPosition, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				world.setBlock(xPosition - 1, yPosition, zPosition, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				world.setBlock(xPosition, yPosition, zPosition + 1, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				world.setBlock(xPosition - 1, yPosition, zPosition + 1, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				break;
			
			case 3:   
				world.setBlock(xPosition, yPosition, zPosition, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				world.setBlock(xPosition + 1, yPosition, zPosition, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				world.setBlock(xPosition, yPosition, zPosition + 1, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
				world.setBlock(xPosition + 1, yPosition, zPosition + 1, MechanicalValues.BlockMechanicBlock.blockID, 0, 2);
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
	 */
	public static boolean validateTableForBlock(World world, int xPosition, int yPosition, int zPosition, int startBlock) {
		switch(startBlock) {
			case 0:
				/*
				 * Valid for configuration 1
				 */
				if (world.getBlockId(xPosition - 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlock.blockID && 
					world.getBlockId(xPosition, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlock.blockID &&
					world.getBlockId(xPosition - 1, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlock.blockID) {
					return true;
					}
			case 1:
				/*
				 * Valid for configuration 2
				 */
				if (world.getBlockId(xPosition, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlock.blockID && 
					world.getBlockId(xPosition + 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlock.blockID &&
					world.getBlockId(xPosition + 1, yPosition, zPosition - 1) == MechanicalValues.BlockMechanicBlock.blockID) {	
					return true;
					}
			case 2:
				/*
				 * Valid for configuration 3
				 */
				if (world.getBlockId(xPosition - 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlock.blockID && 
					world.getBlockId(xPosition, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlock.blockID &&
					world.getBlockId(xPosition - 1, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlock.blockID) {
					return true;
					}
			case 3:
				/*
				 * Valid for configuration 4
				 */
				if (world.getBlockId(xPosition + 1, yPosition, zPosition) == MechanicalValues.BlockMechanicBlock.blockID && 
					world.getBlockId(xPosition, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlock.blockID &&
					world.getBlockId(xPosition + 1, yPosition, zPosition + 1) == MechanicalValues.BlockMechanicBlock.blockID) {
					return true;
					}
		}
		return false;
	}


	public static boolean validateTableForBlockCompleted(World world, int xPosition, int yPosition, int zPosition, int startBlock) {
		switch(startBlock) {
			case 0:
				/*
				 * Valid for configuration 1
				 */
				if (world.getBlockId(xPosition - 1, yPosition, zPosition) == MechanicalValues.BlockMechTableParts.blockID && 
					world.getBlockId(xPosition, yPosition, zPosition - 1) == MechanicalValues.BlockMechTableParts.blockID &&
					world.getBlockId(xPosition - 1, yPosition, zPosition - 1) == MechanicalValues.BlockMechTableParts.blockID) {
					return true;
					}
			case 1:
				/*
				 * Valid for configuration 2
				 */
				if (world.getBlockId(xPosition, yPosition, zPosition - 1) == MechanicalValues.BlockMechTableParts.blockID && 
					world.getBlockId(xPosition + 1, yPosition, zPosition) == MechanicalValues.BlockMechTableParts.blockID &&
					world.getBlockId(xPosition + 1, yPosition, zPosition - 1) == MechanicalValues.BlockMechTableParts.blockID) {	
					return true;
					}
			case 2:
				/*
				 * Valid for configuration 3
				 */
				if (world.getBlockId(xPosition - 1, yPosition, zPosition) == MechanicalValues.BlockMechTableParts.blockID && 
					world.getBlockId(xPosition, yPosition, zPosition + 1) == MechanicalValues.BlockMechTableParts.blockID &&
					world.getBlockId(xPosition - 1, yPosition, zPosition + 1) == MechanicalValues.BlockMechTableParts.blockID) {
					return true;
					}
			case 3:
				/*
				 * Valid for configuration 4
				 */
				if (world.getBlockId(xPosition + 1, yPosition, zPosition) == MechanicalValues.BlockMechTableParts.blockID && 
					world.getBlockId(xPosition, yPosition, zPosition + 1) == MechanicalValues.BlockMechTableParts.blockID &&
					world.getBlockId(xPosition + 1, yPosition, zPosition + 1) == MechanicalValues.BlockMechTableParts.blockID) {
					return true;
					}
		}
		return false;
	}


}
