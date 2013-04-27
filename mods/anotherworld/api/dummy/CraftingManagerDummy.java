package mods.anotherworld.api.dummy;

import net.minecraft.item.ItemStack;
import mods.anotherworld.api.crafting.IManualCrusherManager;
import mods.anotherworld.api.crafting.IMechanicsTableManager;
import mods.anotherworld.api.crafting.IWorldCraftingManager;

public class CraftingManagerDummy implements IMechanicsTableManager, IWorldCraftingManager, IManualCrusherManager {

	/*
	 * (non-Javadoc)
	 * @see mods.anotherworld.api.crafting.IWorldCraftingManager#addRecipe(net.minecraft.item.ItemStack, net.minecraft.item.ItemStack, net.minecraft.item.ItemStack[])
	 */
	@Override
	public boolean addRecipe(ItemStack outputBlock, ItemStack inputBlock, ItemStack[] items) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see mods.anotherworld.api.crafting.IMechanicsTableManager#addRecipe(net.minecraft.item.ItemStack, java.lang.Object[])
	 */
	@Override
	public boolean addRecipe(ItemStack outputStack, Object... recipe) {
		return false;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see mods.anotherworld.api.crafting.IManualCrusherManager#addRecipe(net.minecraft.item.ItemStack, net.minecraft.item.ItemStack)
	 */
	@Override
	public boolean addRecipe(ItemStack outputStack, ItemStack inputStack) {
		return false;
	}
	
}
