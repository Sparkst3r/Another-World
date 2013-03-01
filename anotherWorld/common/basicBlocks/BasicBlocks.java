package anotherWorld.common.basicBlocks;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;

public class BasicBlocks {
	public static int TriCSRenderID = 150;

	public static int BlockEngineeringGlassID = 3000;
	public static int BlockTriCSFlowID = 3001;
	public static int BlockTriCSStillID = BlockTriCSFlowID + 1;
	public static LiquidStack triCSLiquid;
	
	public static Block EngineeringGlass;
	public static Block TriCSStill;
	public static Block TriCSFlow;
	
	public static void addItems() {
		EngineeringGlass = new BlockEngineeringGlass(BlockEngineeringGlassID, 0, Material.glass);
		TriCSStill = new BlockTriCSStill(BlockTriCSStillID);
		TriCSFlow = new BlockTriCSFlow(BlockTriCSFlowID);
		triCSLiquid = LiquidDictionary.getOrCreateLiquid("Trichlorosilane", new LiquidStack(TriCSStill, 1));

	}
	
}
