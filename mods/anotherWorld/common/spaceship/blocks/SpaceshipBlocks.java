package mods.anotherWorld.common.spaceship.blocks;

import net.minecraft.block.Block;

public class SpaceshipBlocks {
	
	public static String CarbonBlockName = "Carbon plating";
	public static Block CarbonBlock;
	public static int CarbonBlockID = 3017;
	
	public static void addItems() {
		CarbonBlock = new BlockCarbonPlating(CarbonBlockID, CarbonBlockName, "platedCarbon");
	}
}
