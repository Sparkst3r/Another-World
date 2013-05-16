package mods.anotherworld.api.crafting;

import java.util.List;

import net.minecraft.item.ItemStack;

/**
 * IManualCrusherManager
 * 
 * Allows access to the manual crusher manager to add recipes to it.
 * 
 * @author Sparkst3r
 *
 */
public interface IManualCrusherManager {
	
	/**
	 * Adds a recipe to the manual crusher. Recipes added here also get carried through to higher tiers too.
	 * 
	 * @param recipe The recipe input
	 * @param output The result of the recipe
	 * @return If the recipe was successfully added
	 */
	public abstract boolean addRecipe(ItemStack inputStack, ItemStack outputStack);
	
	/**
	 * Gets the list of recipes currently registered
	 * @return the list of recipes
	 */
	public abstract List<IManualCrusherRecipe> getRecipes();
	
}
