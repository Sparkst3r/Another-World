package com.sparkst3r.anotherworld.mechanical;

import com.sparkst3r.anotherworld.api.Managers;
import com.sparkst3r.anotherworld.mechanical.blocks.ItemBlockMechBaseParts;
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
 * MechCrafting
 *
 * Mechanical crafting recipes
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 11 Mar 2014
 */
public class MechCrafting {
	
	/**
	 * Add item recipes
	 */
	public static void addItemRecipes() {
		
		/** Basic Gear */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.GEARBASIC), "SWS", "WRW", "SWS", 'W', Items.stick, 'S', Blocks.stone, 'R', Items.redstone);
		
		/** Copper Gear */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.GEARCOPPER), " C ", "CGC", " C ", 'C', new ItemStack(WorldValues.itemIngot, 1, ItemIngot.COPPER), 'G', new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.GEARBASIC));
		
		/** Tin Gear */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.itemMechBaseParts, 1,ItemMechBaseParts.GEARTIN), " T ", "TGT", " T ", 'T', new ItemStack(WorldValues.itemIngot, 1, ItemIngot.TIN), 'G', new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.GEARBASIC));
		
		
		/** Tinkering Head Assembly */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.TINKERHEAD), "I I", "I I", "GIG", 'I', Items.iron_ingot, 'G', new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.GEARTIN));
		
		/** Tinkering Rod Assembly */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.TINKERROD), "GTR", "TRT", "RTG", 'G', new ItemStack(MechanicalValues.itemMechBaseParts, 1, 1), 'T', new ItemStack(WorldValues.itemIngot, 1, ItemIngot.TIN), 'R', Items.blaze_rod);
		
		/** Tinkering Grip Assembly */
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.TINKERGRIP), "CGC", "LWL", "C C", 'G', new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.GEARCOPPER), 'C', new ItemStack(WorldValues.itemIngot, 1, ItemIngot.COPPER), 'L', new ItemStack(WorldValues.itemIngot, 1, ItemIngot.LEAD), 'W', new ItemStack(Blocks.wool, 1, 13/* Dark green */));
		
		/** Tinkering Tool*/
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.itemTinkeringTool, 1), "H  ", " R ", "  G", 'H', new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.TINKERHEAD), 'R', new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.TINKERROD), 'G', new ItemStack(MechanicalValues.itemMechBaseParts, 1, ItemMechBaseParts.TINKERGRIP));
	
		
	}
	
	/** Add block recipes */
	public static void addBlockRecipes() {
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.blockBaseParts, 6, ItemBlockMechBaseParts.SMOOTHSTONE), "SSS", "SCS", "SSS", 'S', Blocks.stone_slab, 'C', Blocks.clay);
	}
	
	/** Add recipes using the API */
	public static void addAPIRecipes() {
		Managers.worldCrafting.addRecipe(new ItemStack(MechanicalValues.blockBaseParts, 1, ItemBlockMechBaseParts.MECHBLOCK), new ItemStack(MechanicalValues.blockBaseParts, 1, ItemBlockMechBaseParts.SMOOTHSTONE), new ItemStack[]{new ItemStack(MechanicalValues.itemMechBaseParts, 2, ItemMechBaseParts.GEARTIN), new ItemStack(WorldValues.itemIngot, 4, ItemIngot.COPPER)});
		Managers.worldCrafting.addRecipe(new ItemStack(MechanicalValues.blockBaseParts, 1, ItemBlockMechBaseParts.ADVMECHBLOCK), new ItemStack(MechanicalValues.blockBaseParts, 1, ItemBlockMechBaseParts.MECHBLOCK), new ItemStack[]{new ItemStack(MechanicalValues.itemMechBaseParts, 2, ItemMechBaseParts.GEARCOPPER),new ItemStack(MechanicalValues.itemMechBaseParts, 2, ItemMechBaseParts.GEARTIN),new ItemStack(Items.gold_ingot, 4)});
		
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.blockOre, 1, ItemBlockOre.COPPERORE), new ItemStack(WorldValues.itemIngot, 2, ItemIngot.COPPERDUST));
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.blockOre, 1, ItemBlockOre.TINORE), new ItemStack(WorldValues.itemIngot, 2, ItemIngot.TINDUST));
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.blockOre, 1, ItemBlockOre.SILVERORE), new ItemStack(WorldValues.itemIngot, 2, ItemIngot.SILVERDUST));
		Managers.manualCrusher.addRecipe(new ItemStack(WorldValues.blockOre, 1, ItemBlockOre.LEADORE), new ItemStack(WorldValues.itemIngot, 2, ItemIngot.LEADDUST));
		Managers.manualCrusher.addRecipe(new ItemStack(Blocks.iron_ore, 1, 0), new ItemStack(WorldValues.itemIngot, 2, ItemIngot.IRONDUST));
		Managers.manualCrusher.addRecipe(new ItemStack(Blocks.gold_ore, 1, 0), new ItemStack(WorldValues.itemIngot, 2, ItemIngot.GOLDDUST));
	
		Managers.mechanicsTableCrafting.addRecipe(new ItemStack(MechanicalValues.blockManualCrusher), new Object[]{
		 " PP ", "IACI", "ICAI", " PP ",
		 'P', new ItemStack(Blocks.piston),
		 'I', new ItemStack(Items.iron_ingot),
		 'C', new ItemStack(WorldValues.itemIngot, 1, ItemIngot.COPPER),
		 'A', new ItemStack(MechanicalValues.blockBaseParts, 1, ItemBlockMechBaseParts.ADVMECHBLOCK)});
		
	}
	
	
	
	
}
