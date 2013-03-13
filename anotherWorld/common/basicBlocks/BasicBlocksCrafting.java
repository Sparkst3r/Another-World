package anotherWorld.common.basicBlocks;

import anotherWorld.common.ModsExist;
import anotherWorld.common.basicItems.BasicItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidStack;
import thermalexpansion.api.crafting.CraftingManagers;



public class BasicBlocksCrafting {
	public static void crafting() {
		addCraftingEngineeringGlass();
		addCraftingTriCS();
	}
	
	
	public static void addCraftingEngineeringGlass() {
		if (ModsExist.teExists) {
			CraftingManagers.smelterManager.addRecipe(40, new ItemStack(Item.redstone, 4), new ItemStack(Block.glass, 4), new ItemStack(BasicBlocks.EngineeringGlass, 4), new ItemStack(BasicItems.SiliconSlag, 1), 2 , false);
		}
		
	}
	public static void addCraftingTriCS() {
		if (ModsExist.teExists) {
			CraftingManagers.crucibleManager.addRecipe(1000, new ItemStack(BasicItems.MetGradeSilicon, 1) , new LiquidStack(BasicBlocks.TriCSStill, 500), false);
			}
		}
}
