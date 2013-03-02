package anotherWorld.common;

import thermalexpansion.api.core.ItemRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import anotherWorld.common.basicBlocks.BasicBlocks;
import anotherWorld.common.basicBlocks.BasicBlocksCrafting;
import anotherWorld.common.basicItems.BasicItems;
import anotherWorld.common.basicItems.BasicItemsCrafting;
import anotherWorld.common.village.TradeHandlerVillagerAdvanced;



public class onLoad{
	
	public static void onLoading() {
		BasicItems.addItems();
		BasicBlocks.addItems();
		VillagerInit();
	}

	private static void VillagerInit() {
	      VillagerRegistry reg = VillagerRegistry.instance();
	      TradeHandlerVillagerAdvanced handler = new TradeHandlerVillagerAdvanced();
	      reg.registerVillageTradeHandler(50, handler);
	      VillagerRegistry.instance().registerVillagerType(50, AnotherWorld.texDir + "advanced.png");
		
	}

	public static void onPostLoad() { 
		    BasicItemsCrafting.crafting();
		    BasicBlocksCrafting.crafting();
		    //Debug Output
			//ItemRegistry.printItemNames();
	}

}
