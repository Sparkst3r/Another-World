/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.crafting;

import net.minecraft.item.ItemStack;

/**
 * IMechanicsTableManager
 * 
 * Allows access to the mechanics table's manager to add recipes to it.
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 23 Feb 2014
 *
 */
public abstract interface IMechanicsTableManager {
	
	/**
	 * The crafting recipe works like the standard crafting table. Only the width is 4 not 3 so "IIII" not "III"
	 * 
	 * @param outputStack The result of the recipe
	 * @param recipe The recipe
	 * @return If the recipe was successfully added
	 */
	public abstract boolean addRecipe(ItemStack outputStack, Object... recipe);
	
}
