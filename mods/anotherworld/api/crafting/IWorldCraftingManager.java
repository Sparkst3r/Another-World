package mods.anotherworld.api.crafting;

import net.minecraft.item.ItemStack;

public abstract interface IWorldCraftingManager {
	
	public abstract boolean addRecipe(ItemStack outputBlock, ItemStack inputBlock, ItemStack[] items);
}
