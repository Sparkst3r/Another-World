package com.sparkst3r.anotherworld.world;

import com.sparkst3r.anotherworld.world.blocks.ItemBlockOre;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
/**
 * Simple class for all the block crafting recipes
 * @author Sparkst3r
 *
 */
public class BlockCrafting {
	/**
	 * Initialise the recipes
	 */
	public static void initialise() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(WorldValues.BlockOreField, 1, ItemBlockOre.COPPERSTORE), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotCopper"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(WorldValues.BlockOreField, 1, ItemBlockOre.TINSTORE), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotTin"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(WorldValues.BlockOreField, 1, ItemBlockOre.SILVERSTORE), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotSilver"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(WorldValues.BlockOreField, 1, ItemBlockOre.LEADSTORE), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotLead"
		}));
	}

}
