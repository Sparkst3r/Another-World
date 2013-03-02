package anotherWorld.common.basicBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;

public class BasicBlocks {
	//Misc
	public static int TriCSRenderID = 150;
	public static LiquidStack triCSLiquid;
	
	
	//Default IDs
	public static Block EngineeringGlass;
	public static String BlockEngineeringGlassName = "Engineering Glass";
	public static int BlockEngineeringGlassID = 3000;
	
	public static String BlockTriCSName = "Trichlorosilane";
	
	public static Block TriCSFlow;
	public static String BlockTriCSFlowName = "Trichlorosilane Flowing";
	public static int BlockTriCSFlowID = 3001;
	
	public static Block TriCSStill;
	public static String BlockTriCSStillName = "Trichlorosilane Still";
	public static int BlockTriCSStillID = BlockTriCSFlowID + 1;

	
	//Add Items
	public static void addItems() {
		EngineeringGlass = new BlockEngineeringGlass(BlockEngineeringGlassID, 0, Material.glass);
		TriCSStill = new BlockTriCSStill(BlockTriCSStillID);
		TriCSFlow = new BlockTriCSFlow(BlockTriCSFlowID);
		triCSLiquid = LiquidDictionary.getOrCreateLiquid("Trichlorosilane", new LiquidStack(TriCSStill, 1));

	}
	
}
