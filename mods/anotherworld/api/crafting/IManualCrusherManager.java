package mods.anotherworld.api.crafting;

import net.minecraft.item.ItemStack;

public interface IManualCrusherManager {
	
	/**
	 * Adds a recipe to the manual crusher. Recipes added here also get carried through to higher tiers too.
	 * 
	 * @param recipe The recipe input
	 * @param output The result of the recipe
	 * @return If the recipe was successfully added
	 */
	public abstract boolean addRecipe(ItemStack inputStack, ItemStack outputStack);

}
