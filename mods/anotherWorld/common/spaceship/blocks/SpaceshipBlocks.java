package mods.anotherWorld.common.spaceship.blocks;

import net.minecraft.block.Block;

public class SpaceshipBlocks {
	
	public static String CarbonBlockName = "Carbon plated iron";
	public static Block CarbonBlock;
	public static int CarbonBlockID = 3017;
	
	public static String JetName = "Jet";
	public static Block JetBlock;
	public static int JetID = 3018;
	
	public static void addItems() {
		CarbonBlock = new BlockCarbonPlating(CarbonBlockID, CarbonBlockName, "carbonPlated");
		JetBlock = new BlockJet(JetID, JetName, "jet");
	}
}
