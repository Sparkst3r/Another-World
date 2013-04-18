package mods.AnotherWorld.api.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IWorldBlockRecipe {

    boolean matches(ItemStack[] inputStacks, World world);

    ItemStack getCraftingResult(ItemStack[] inputStacks);

    ItemStack getRecipeOutput();
}