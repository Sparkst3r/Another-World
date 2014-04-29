/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.dummy;

import java.util.ArrayList;
import java.util.List;

import com.sparkst3r.anotherworld.api.crafting.IManualCrusherManager;
import com.sparkst3r.anotherworld.api.crafting.IManualCrusherRecipe;
import com.sparkst3r.anotherworld.api.crafting.IMechanicsTableManager;
import com.sparkst3r.anotherworld.api.crafting.IWorldCraftingManager;


import net.minecraft.item.ItemStack;

/**
 * CraftingManagerDummy
 * 
 * Useless dummy class to prevent null pointers if the mod isn't installed or incorrectly mapped.
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 23 Feb 2014
 *
 */
public class CraftingManagerDummy implements IMechanicsTableManager, IWorldCraftingManager, IManualCrusherManager {
	
	/**
	 * @see com.sparkst3r.anotherworld.api.crafting.IWorldCraftingManager#addRecipe(net.minecraft.item.ItemStack, net.minecraft.item.ItemStack, net.minecraft.item.ItemStack[])
	 */
	@Override
	public boolean addRecipe(ItemStack outputBlock, ItemStack inputBlock, ItemStack[] items) {
		return false;	
	}
	
	/**
	 * @see com.sparkst3r.anotherworld.api.crafting.IMechanicsTableManager#addRecipe(net.minecraft.item.ItemStack, java.lang.Object[])
	 */
	@Override
	public boolean addRecipe(ItemStack outputStack, Object... recipe) {
		return false;
	}
	
	/**
	 * @see com.sparkst3r.anotherworld.api.crafting.IManualCrusherManager#addRecipe(net.minecraft.item.ItemStack, net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean addRecipe(ItemStack inputStack, ItemStack outputStack) {
		return false;
	}
	
	/**
	 * @see com.sparkst3r.anotherworld.api.crafting.IManualCrusherManager#getRecipes()
	 */
	@Override
	public List<IManualCrusherRecipe> getRecipes() {
		return new ArrayList<IManualCrusherRecipe>();
	}
}
