package anotherWorld.common.machines;

import anotherWorld.common.basicBlocks.BlockEngineeringGlass;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Machines {
	public static Block test;
	public static String testName = "Engineering Glass";
	public static int testID = 3005;
	
	public static void addItems() {
	test = new BlockSeparator(testID);
	}
	
}
