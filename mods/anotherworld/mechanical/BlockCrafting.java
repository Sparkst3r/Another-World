package mods.anotherworld.mechanical;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * BlockCrafting
 * 
 * Crafting recipes for Mechanical Expansion blocks.
 * 
 * @author Sparkst3r
 *
 */
public class BlockCrafting {
	
	/**
	 * Init the recipes
	 */
	public static void initialise() {
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.BlockBasePartsField, 4, 0),
				"SSS", "SCS", "SSS", 'S', new ItemStack(Block.stoneSingleSlab, 1, 0), 'C', Block.blockClay);
	
	}	
}
