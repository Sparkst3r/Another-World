package anotherWorld.common.basicBlocks;

import anotherWorld.common.basicItems.BasicItems;
import thermalexpansion.api.crafting.CraftingManagers;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidStack;

public class BasicBlocksCrafting {
	public static void crafting() {
		addCraftingEngineeringGlass();
		addCraftingTriCS();
	}
	
	
	public static void addCraftingEngineeringGlass() {
		CraftingManagers.smelterManager.addRecipe(40, new ItemStack(Item.redstone, 4), new ItemStack(Block.glass, 4), new ItemStack(BasicBlocks.EngineeringGlass, 4), new ItemStack(BasicItems.SiliconSlag, 1), 5 , false);
	}
	public static void addCraftingTriCS() {
		CraftingManagers.crucibleManager.addRecipe(5000, new ItemStack(BasicItems.MetGradeSilicon, 1) , new LiquidStack(BasicBlocks.TriCSStill, 500), false);
	}
 
}
