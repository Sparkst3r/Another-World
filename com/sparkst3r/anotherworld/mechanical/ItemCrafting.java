package com.sparkst3r.anotherworld.mechanical;

import com.sparkst3r.anotherworld.api.Managers;
import com.sparkst3r.anotherworld.mechanical.items.ItemMechBaseParts;
import com.sparkst3r.anotherworld.world.WorldValues;
import com.sparkst3r.anotherworld.world.blocks.ItemBlockOre;
import com.sparkst3r.anotherworld.world.items.ItemIngot;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import cpw.mods.fml.common.registry.GameRegistry;


/**
 * ItemCrafting
 * 
 * Crafting recipes for Mechanical Expansion items.
 * 
 * @author Sparkst3r
 *
 */
public class ItemCrafting {
	
	public static void addRecipes() {
		
		/** Basic Gear */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, ItemMechBaseParts.GEARBASIC), "SWS", "WRW", "SWS", 'W', Items.stick, 'S', Blocks.stone, 'R', Items.redstone);
		
		/** Copper Gear */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, ItemMechBaseParts.GEARCOPPER), " C ", "CGC", " C ", 'C', new ItemStack(WorldValues.ItemIngotField, 1, ItemIngot.COPPER), 'G', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 0));
		
		/** Tin Gear */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1,ItemMechBaseParts.GEARTIN),
			" T ", "TGT", " T ", 'T', new ItemStack(WorldValues.ItemIngotField, 1, 1), 'G', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 0));
		
		
		/** Tinkering Head Assembly */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, 3),
			"I I", "I I", "GIG", 'I', new ItemStack(Items.iron_ingot, 1, 0), 'G', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 0));
		
		/** Tinkering Rod Assembly */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, 4),
			"GTR", "TRT", "RTG", 'G', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 1), 'T', new ItemStack(WorldValues.ItemIngotField, 1, 1), 'R', new ItemStack((Item)Item.itemRegistry.getObject("blazerod"), 1, 0));
		
		/** Tinkering Grip Assembly */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, 5),
			"CGC", "LWL", "C C", 'G', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 1), 'C', new ItemStack(WorldValues.ItemIngotField, 1, 0), 'L', new ItemStack(WorldValues.ItemIngotField, 1, 3), 'W', new ItemStack(Blocks.wool, 1, 13));
		
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemToolField, 1 , 0),
			"H  ", " R ", "  G", 'H', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 2), 'R', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 3), 'G', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 4));
	
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.BlockOreField, 1, ItemBlockOre.COPPERORE), new ItemStack(WorldValues.ItemIngotField, 2, ItemIngot.COPPERDUST));
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.BlockOreField, 1, ItemBlockOre.TINORE), new ItemStack(WorldValues.ItemIngotField, 2, ItemIngot.TINDUST));
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.BlockOreField, 1, ItemBlockOre.SILVERORE), new ItemStack(WorldValues.ItemIngotField, 2, ItemIngot.COPPERDUST));
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.BlockOreField, 1, ItemBlockOre.LEADORE), new ItemStack(WorldValues.ItemIngotField, 2, ItemIngot.TINDUST));
		Managers.manualCrusher.addRecipe(new ItemStack(Blocks.iron_ore, 1, 0), new ItemStack(WorldValues.ItemIngotField, 2, ItemIngot.IRONDUST));
		Managers.manualCrusher.addRecipe(new ItemStack(Blocks.gold_ore, 1, 0), new ItemStack(WorldValues.ItemIngotField, 2, ItemIngot.GOLDDUST));
		
	}
}
