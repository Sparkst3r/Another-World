package anotherWorld.common.basicBlocks;

import anotherWorld.common.basicItems.ItemGlue;
import anotherWorld.common.machines.BlockEngineeringGlass;
import anotherWorld.common.machines.BlockTriCSFlow;
import anotherWorld.common.machines.BlockTriCSStill;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;

public class BasicBlocks {
	
	public static String ChromiumName = "Chromium Ore";
	public static Block Chromium;
	public static int ChromiumID = 3007;
	
	public static String SaltName = "Chromium Ore";
	public static Block Salt;
	public static int SaltID = 3008;
	
	//Add Items
	public static void addItems() {
		Chromium = new BlockChromiumOre(ChromiumID, ChromiumName, ChromiumID, null);
		Salt = new BlockSaltOre(SaltID, SaltName, SaltID, null);

	}
	
}
