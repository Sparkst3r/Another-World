package mods.anotherworld.api.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IWorldBlockRecipe {

    boolean matches(ItemStack[] inputStacks, World world);

    ItemStack getCraftingResult(ItemStack[] inputStacks);

    ItemStack getRecipeOutput();
}