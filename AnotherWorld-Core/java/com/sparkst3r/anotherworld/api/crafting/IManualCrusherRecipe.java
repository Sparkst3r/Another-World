/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.crafting;

import net.minecraft.item.ItemStack;

/**
 * IManualCrusherRecipe
 * 
 * A Manual Crusher Recipe
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 16 Feb 2014
 */
public interface IManualCrusherRecipe {
	
	/**
	 * Returns the stack which must be inserted into the crusher for this recipe to be satisfied.
	 * 
	 * @return The ItemStack of the input 
	 */
	public ItemStack getInputStack();
	
	/**
	 * Verifies if the input stack satisfies this recipe.
	 * 
	 * @param inputStack The input stack to be checked
	 * @return if the match is successful
	 */
	public boolean matches(ItemStack inputStack);

	/**
	 * 
	 * @return This recipes output 
	 */
	public ItemStack getRecipeOutput();
}
