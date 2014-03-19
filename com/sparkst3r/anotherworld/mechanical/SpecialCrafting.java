package com.sparkst3r.anotherworld.mechanical;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.sparkst3r.anotherworld.api.Managers;
import com.sparkst3r.anotherworld.mechanical.MechanicalValues;
import com.sparkst3r.anotherworld.mechanical.items.ItemMechBaseParts;
import com.sparkst3r.anotherworld.world.WorldValues;
import com.sparkst3r.anotherworld.world.blocks.ItemBlockOre;
import com.sparkst3r.anotherworld.world.items.ItemIngot;

/** 
 * SpecialCrafting
 * 
 * 
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 4 Mar 2014
 */
public class SpecialCrafting {
	
	public static void initialise() {
		
		/** Mechanics Block */
		//Managers.worldCrafting.addRecipe(new ItemStack(MechanicalValues.BlockBasePartsField, 1, 1), new ItemStack(MechanicalValues.BlockBasePartsField, 1, 0), new ItemStack[]{
		//	new ItemStack(MechanicalValues.ItemBasePartsField, 2, ItemMechBaseParts.GEARTIN), 
		//	new ItemStack(WorldValues.ItemIngotField, 4, ItemIngot.COPPER)});
		
		/** Advanced mechanics block */
		//Managers.worldCrafting.addRecipe(new ItemStack(MechanicalValues.BlockBasePartsField, 1, 2), new ItemStack(MechanicalValues.BlockBasePartsField, 1, 1), new ItemStack[]{
		//	new ItemStack(MechanicalValues.ItemBasePartsField, 2, 1),
		//	new ItemStack(MechanicalValues.ItemBasePartsField, 2, 2),
		//	new ItemStack((Item)Item.itemRegistry.getObject("ingotGold"), 4)});
		
		/** Manual Crusher */
		//Managers.mechanicsTableCrafting.addRecipe(new ItemStack(MechanicalValues.BlockManualCrusherField), new Object[]{
		//	" PP ", "IACI", "ICAI", " PP ", 
		///	'P', new ItemStack(Block.getBlockFromName("pistonBase"), 1, 0), 
		//	'I', new ItemStack((Item)Item.itemRegistry.getObject("ingotIron"), 1, 0), 
		//	'C', new ItemStack(WorldValues.ItemIngotField, 1, 0), 
		//	'A', new ItemStack(MechanicalValues.BlockBasePartsField, 1, 2)});
		
		//Managers.manualCrusher.addRecipe(new ItemStack(Items.quartz, 1, 0), new ItemStack(MechanicalValues.ItemBasePartsField, 1, 6));
		//Managers.manualCrusher.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, 6), new ItemStack(MechanicalValues.ItemBasePartsField, 1, 7));
		//Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.ItemIngotField, 2, 8), new ItemStack(Block.getBlockFromName("oreIron"), 1, 0));
		//Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.ItemIngotField, 2, 9), new ItemStack(Block.getBlockFromName("oreGold"), 1, 0));
		//Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.ItemIngotField, 2, 4), new ItemStack(WorldValues.BlockOreField, 1, 0));
		
		
	}
}
