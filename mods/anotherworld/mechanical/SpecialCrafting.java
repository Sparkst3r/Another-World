package mods.anotherworld.mechanical;

import mods.anotherworld.api.Managers;
import mods.anotherworld.world.WorldValues;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SpecialCrafting {
	
	public static void initialise() {
		Managers.mechanicsTableCrafting.addRecipe(new ItemStack(Block.planks, 2, 0), new Object[]{"D  D", "D  D", "D  D","D  D", 'D', Block.dirt});
		
		Managers.worldCrafting.addRecipe(new ItemStack(MechanicalValues.BlockBasePartsField, 1, 1), new ItemStack(MechanicalValues.BlockBasePartsField, 1, 0), new ItemStack[]{new ItemStack(MechanicalValues.ItemBasePartsField, 2, 0), new ItemStack(WorldValues.ItemIngotField, 4, 0)});
	
		Managers.manualCrusher.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, 5), new ItemStack(Item.netherQuartz, 1, 0));
	}
}
