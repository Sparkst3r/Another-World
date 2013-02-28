package anotherWorld.common.basicBlocks;

import anotherWorld.common.basicItems.BasicItems;
import thermalexpansion.api.crafting.CraftingManagers;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BasicBlocksCrafting {
	public static void crafting() {
		addCraftingEngineeringGlass();
	}
	
	
	public static void addCraftingEngineeringGlass() {
		CraftingManagers.smelterManager.addRecipe(40, new ItemStack(Item.redstone, 4), new ItemStack(Block.glass, 4), new ItemStack(BasicBlocks.EngineeringGlass, 4), new ItemStack(BasicItems.SiliconSlag, 1), 5 , false);
	}
 
}
