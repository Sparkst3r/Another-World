package mods.anotherWorld.common.basicBlocks;

import mods.anotherWorld.common.basicItems.ItemGlue;
import mods.anotherWorld.common.machines.BlockEngineeringGlass;
import mods.anotherWorld.common.machines.BlockTriCSFlow;
import mods.anotherWorld.common.machines.BlockTriCSStill;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;

public class BasicBlocks {
	
	public static String ChromiumName = "Chromium Ore";
	public static Block Chromium;
	public static int ChromiumID = 3007;
	
	public static String SaltName = "Salt Ore";
	public static Block Salt;
	public static int SaltID = 3008;
	
	public static String TyteonRockName = "Tyteon Stone";
	public static Block TyteonRock;
	public static int TyteonRockID = 3009;
	
	public static String RedDustName = "Red Dust";
	public static Block RedDust;
	public static int RedDustID = 3010;
	
	//Add Items
	public static void addItems() {
		Chromium = new BlockChromiumOre(ChromiumID, ChromiumName);
		Salt = new BlockSaltOre(SaltID, SaltName);
		TyteonRock = new BlockTyteonRock(TyteonRockID, TyteonRockName);
		RedDust = new BlockRedDust(RedDustID, RedDustName);
	}
	
}
