package anotherWorld.common;

import cpw.mods.fml.common.registry.VillagerRegistry;
import anotherWorld.common.basicItems.BasicItems;
import anotherWorld.common.village.TradeHandlerVillagerAdvanced;

public class onLoad {

	public static void onLoading() {
		BasicItems.addItems();
		VillagerInit();
	}

	private static void VillagerInit() {
	      VillagerRegistry reg = VillagerRegistry.instance();
	      TradeHandlerVillagerAdvanced handler = new TradeHandlerVillagerAdvanced();
	      reg.registerVillageTradeHandler(50, handler);
	      VillagerRegistry.instance().registerVillagerType(50, AnotherWorld.texDir + "advanced.png");
		
	}

}
