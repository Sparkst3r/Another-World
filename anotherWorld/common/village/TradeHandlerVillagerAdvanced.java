package anotherWorld.common.village;

import ic2.api.Items;

import java.util.Random;

import anotherWorld.common.basicItems.BasicItems;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class TradeHandlerVillagerAdvanced implements IVillageTradeHandler {

	   public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList Buy, Random random) {

		   Buy.add(
	    		  new MerchantRecipe(
	    				  new ItemStack(Item.eyeOfEnder, 6),
	    				  new ItemStack(BasicItems.BlueprintPart, 1, 0)
	    				  ));

	   }


	}