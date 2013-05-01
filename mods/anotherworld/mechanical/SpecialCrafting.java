package mods.anotherworld.mechanical;

import mods.anotherworld.api.Managers;
import mods.anotherworld.world.WorldValues;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SpecialCrafting {
	
	public static void initialise() {
		
		/** Mechanics Block */
		Managers.worldCrafting.addRecipe(new ItemStack(MechanicalValues.BlockBasePartsField, 1, 1), new ItemStack(MechanicalValues.BlockBasePartsField, 1, 0), new ItemStack[]{
			new ItemStack(MechanicalValues.ItemBasePartsField, 2, 2), 
			new ItemStack(WorldValues.ItemIngotField, 4, 0)});
		
		/** Advanced mechanics block */
		Managers.worldCrafting.addRecipe(new ItemStack(MechanicalValues.BlockBasePartsField, 1, 2), new ItemStack(MechanicalValues.BlockBasePartsField, 1, 1), new ItemStack[]{
			new ItemStack(MechanicalValues.ItemBasePartsField, 2, 1),
			new ItemStack(MechanicalValues.ItemBasePartsField, 2, 2),
			new ItemStack(Item.ingotGold, 4)});
		
		/** Manual Crusher */
		Managers.mechanicsTableCrafting.addRecipe(new ItemStack(MechanicalValues.BlockManualCrusherField), new Object[]{
			" PP ", "IACI", "ICAI", " PP ", 
			'P', new ItemStack(Block.pistonBase, 1, 0), 
			'I', new ItemStack(Item.ingotIron, 1, 0), 
			'C', new ItemStack(WorldValues.ItemIngotField, 1, 0), 
			'A', new ItemStack(MechanicalValues.BlockBasePartsField, 1, 2)});
		
		Managers.manualCrusher.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, 5), new ItemStack(Item.netherQuartz, 1, 0));
		Managers.manualCrusher.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, 6), new ItemStack(MechanicalValues.ItemBasePartsField, 1, 5));
		Managers.manualCrusher.addRecipe(new ItemStack(Block.oreIron, 1, 0), new ItemStack(WorldValues.ItemIngotField, 2, 8));
		Managers.manualCrusher.addRecipe(new ItemStack(Block.oreGold, 1, 0), new ItemStack(WorldValues.ItemIngotField, 2, 9));
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.BlockOreField, 1, 0), new ItemStack(WorldValues.ItemIngotField, 2, 4));
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.BlockOreField, 1, 1), new ItemStack(WorldValues.ItemIngotField, 2, 5));
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.BlockOreField, 1, 2), new ItemStack(WorldValues.ItemIngotField, 2, 6));
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.BlockOreField, 1, 3), new ItemStack(WorldValues.ItemIngotField, 2, 7));
	}
}
