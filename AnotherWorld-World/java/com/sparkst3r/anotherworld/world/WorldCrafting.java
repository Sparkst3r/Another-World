package com.sparkst3r.anotherworld.world;

import com.sparkst3r.anotherworld.world.blocks.ItemBlockOre;
import com.sparkst3r.anotherworld.world.items.ItemIngot;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

/**
 * WorldCrafting
 * 
 * Add crafting recipes
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 1 Apr 2014
 */
public class WorldCrafting {
	
	/**
	 * Add smelting recipes
	 */
	public static void addSmelting() {
		GameRegistry.addSmelting(new ItemStack(WorldValues.blockOre, 1, ItemBlockOre.COPPERORE), new ItemStack(WorldValues.itemIngot, 1, ItemIngot.COPPER), 0.1F);
		GameRegistry.addSmelting(new ItemStack(WorldValues.blockOre, 1, ItemBlockOre.TINORE), new ItemStack(WorldValues.itemIngot, 1, ItemIngot.TIN), 0.1F);
		GameRegistry.addSmelting(new ItemStack(WorldValues.blockOre, 1, ItemBlockOre.SILVERORE), new ItemStack(WorldValues.itemIngot, 1, ItemIngot.SILVER), 0.1F);
		GameRegistry.addSmelting(new ItemStack(WorldValues.blockOre, 1, ItemBlockOre.LEADORE), new ItemStack(WorldValues.itemIngot, 1, ItemIngot.LEAD), 0.1F);
	}
}
