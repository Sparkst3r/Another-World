/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.crafting;

import net.minecraft.item.ItemStack;

/**
 * IWorldCraftingManager
 * 
 * Allows access to the in world crafting manager to add recipes to it.
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 23 Feb 2014
 *
 */
public abstract interface IWorldCraftingManager {
	
	/**
	 * Adds a recipe to the world crafting recipes
	 * @param outputBlock The block that will be placed if the recipe is fulfilled
	 * @param inputBlock The block that will be used in the recipe
	 * @param items The items required to be surrounding the block when assembled
	 * @return If the recipe was added.
	 */
	public abstract boolean addRecipe(ItemStack inputBlock, ItemStack outputBlock, ItemStack[] items);
}
