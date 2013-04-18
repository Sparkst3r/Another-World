package mods.AnotherWorld.api.crafting;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public abstract interface IWorldCraftingManager {
	
	public abstract boolean addRecipe(ItemStack outputBlock, ItemStack inputBlock, ItemStack[] items);
	
	//public abstract boolean addRecipe(ItemStack outputStack, Block inputBlock, Object... items);
	
}
