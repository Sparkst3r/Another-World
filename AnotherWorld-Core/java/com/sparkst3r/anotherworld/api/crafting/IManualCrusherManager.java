/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.crafting;

import java.util.List;

import net.minecraft.item.ItemStack;

/**
 * IManualCrusherManager
 *
 * Expose access to the Manual Crusher manager.
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 16 Feb 2014
 */
public interface IManualCrusherManager {
	
	/**
	 * Adds a recipe to the manual crusher. Recipes added here also get carried through to higher tiers too.
	 * 
	 * @param inputStack The recipe input
	 * @param outputStack The result of the recipe
	 * @return If the recipe was successfully added
	 */
	public abstract boolean addRecipe(ItemStack inputStack, ItemStack outputStack);
	
	/**
	 * Gets the list of recipes currently registered
	 * @return the list of recipes
	 */
	public abstract List<IManualCrusherRecipe> getRecipes();
	
}
