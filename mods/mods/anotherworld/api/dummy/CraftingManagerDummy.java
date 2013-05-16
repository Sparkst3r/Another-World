package mods.anotherworld.api.dummy;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import mods.anotherworld.api.crafting.IManualCrusherManager;
import mods.anotherworld.api.crafting.IManualCrusherRecipe;
import mods.anotherworld.api.crafting.IMechanicsTableManager;
import mods.anotherworld.api.crafting.IWorldCraftingManager;

/**
 * CraftingManagerDummy
 * 
 * Useless dummy class to prevent null pointers if the mod isn't installed or incorrectly mapped.
 * 
 * @author Sparkst3r
 *
 */
public class CraftingManagerDummy implements IMechanicsTableManager, IWorldCraftingManager, IManualCrusherManager {

	/**
	 * (non-Javadoc)
	 * @see mods.anotherworld.api.crafting.IWorldCraftingManager#addRecipe(net.minecraft.item.ItemStack, net.minecraft.item.ItemStack, net.minecraft.item.ItemStack[])
	 */
	@Override
	public boolean addRecipe(ItemStack outputBlock, ItemStack inputBlock, ItemStack[] items) {
		return false;
	}

	/**
	 * (non-Javadoc)
	 * @see mods.anotherworld.api.crafting.IMechanicsTableManager#addRecipe(net.minecraft.item.ItemStack, java.lang.Object[])
	 */
	@Override
	public boolean addRecipe(ItemStack outputStack, Object... recipe) {
		return false;
	}

	/**
	 * (non-Javadoc)
	 * @see mods.anotherworld.api.crafting.IManualCrusherManager#addRecipe(net.minecraft.item.ItemStack, net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean addRecipe(ItemStack inputStack, ItemStack outputStack) {
		return false;
	}

	/**
	 * (non-Javadoc)
	 * @see mods.anotherworld.api.crafting.IManualCrusherManager#getRecipes()
	 */
	@Override
	public List<IManualCrusherRecipe> getRecipes() {
		return new ArrayList<IManualCrusherRecipe>();
	}
}
