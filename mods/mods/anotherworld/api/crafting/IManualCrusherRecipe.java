package mods.anotherworld.api.crafting;

import net.minecraft.item.ItemStack;

public interface IManualCrusherRecipe {
		public ItemStack getInputStack();

		public boolean matches(ItemStack inputStack);

		public ItemStack getRecipeOutput();
}
