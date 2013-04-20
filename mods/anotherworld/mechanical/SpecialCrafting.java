package mods.anotherworld.mechanical;

import mods.anotherworld.api.crafting.CraftingManagers;
import mods.anotherworld.world.WorldValues;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class SpecialCrafting {
	
	public static void initialise() {
		CraftingManagers.mechanicsTable.addRecipe(new ItemStack(Block.planks, 2, 0), new Object[]{"D  D", "D  D", "D  D","D  D", 'D', Block.dirt});
		
		CraftingManagers.world.addRecipe(new ItemStack(MechanicalValues.BlockBasePartsField, 1, 1), new ItemStack(MechanicalValues.BlockBasePartsField, 1, 0), new ItemStack[]{new ItemStack(MechanicalValues.ItemBasePartsField, 2, 0), new ItemStack(WorldValues.ItemIngotField, 4, 0)});
	}
}
