package mods.AnotherWorld.Mechanical;

import mods.AnotherWorld.Mechanical.Crafting.MechTableCraftingManager;
import mods.AnotherWorld.World.WorldValues;
import mods.AnotherWorld.api.crafting.CraftingManagers;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SpecialCrafting {
	
	public static void initialise() {
		CraftingManagers.mechanicsTable.addRecipe(new ItemStack(Block.planks, 2, 0), new Object[]{"D  D", "D  D", "D  D","D  D", 'D', Block.dirt});
		
		CraftingManagers.world.addRecipe(new ItemStack(MechanicalValues.BlockBasePartsField, 1, 1), new ItemStack(MechanicalValues.BlockBasePartsField, 1, 0), new ItemStack[]{new ItemStack(MechanicalValues.ItemBasePartsField, 2, 0), new ItemStack(WorldValues.ItemIngotField, 4, 0)});
	}
}
