package mods.anotherworld.api.crafting;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract interface IWorldBlockRecipe {

    public abstract boolean matches(ItemStack[] inputStacks, World world);

    ItemStack getRecipeOutput();
}