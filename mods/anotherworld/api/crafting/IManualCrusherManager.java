package mods.anotherworld.api.crafting;

import net.minecraft.item.ItemStack;

public interface IManualCrusherManager {
	
	/**
	 * Adds a recipe to the manual crusher. Recipes added here also get carried through to higher tiers too.
	 * 
	 * @param output The result of the recipe
	 * @param recipe The recipe input
	 * @return If the recipe was successfully added
	 */
	public abstract boolean addRecipe(ItemStack outputStack, ItemStack inputStack);

}
