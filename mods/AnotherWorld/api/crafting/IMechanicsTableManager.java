package mods.AnotherWorld.api.crafting;

import net.minecraft.item.ItemStack;

public abstract interface IMechanicsTableManager {
	
	/**
	 * The crafting recipe works like the standard crafting table. Only the width is 4 not 3 so "IIII" not "III"
	 * 
	 * @param output The result of the recipe
	 * @param recipe The recipe
	 * @return If the recipe was successfully added
	 */
	public abstract boolean addRecipe(ItemStack outputStack, Object... recipe);
	
}
