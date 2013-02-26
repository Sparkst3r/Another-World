package anotherWorld.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thermalexpansion.api.core.ItemRegistry;
import thermalexpansion.api.crafting.CraftingManagers;
import thermalexpansion.api.crafting.ISmelterManager;
import thermalexpansion.api.crafting.ISmelterRecipe;
import cpw.mods.fml.common.registry.VillagerRegistry;
import anotherWorld.common.basicBlocks.BasicBlocks;
import anotherWorld.common.basicItems.BasicItems;
import anotherWorld.common.basicItems.BasicItemsCrafting;
import anotherWorld.common.basicItems.ItemRedLED;
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
		    
			CraftingManagers.smelterManager.addRecipe(40, new ItemStack(Item.redstone, 4), new ItemStack(Block.glass, 4), new ItemStack(BasicBlocks.EngineeringGlass, 4), new ItemStack(BasicItems.SiliconSlag, 1), 5 , false);
		    //Debug Output
			ItemRegistry.printItemNames();
	}

}