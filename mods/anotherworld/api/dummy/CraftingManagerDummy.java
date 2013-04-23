package mods.anotherworld.api.dummy;

import net.minecraft.item.ItemStack;
import mods.anotherworld.api.crafting.IMechanicsTableManager;
import mods.anotherworld.api.crafting.IWorldCraftingManager;

public class CraftingManagerDummy implements IMechanicsTableManager, IWorldCraftingManager {

	@Override
	public boolean addRecipe(ItemStack outputBlock, ItemStack inputBlock, ItemStack[] items) {
		return false;
	}

	@Override
	public boolean addRecipe(ItemStack outputStack, Object... recipe) {
		return false;
	}
	
}
