package mods.AnotherWorld.api.crafting;

import net.minecraft.item.ItemStack;

public abstract interface IMechanicsTableManager {
	
	 public abstract boolean addRecipe(ItemStack input, Object... recipe);

}
