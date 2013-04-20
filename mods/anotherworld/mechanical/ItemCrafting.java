package mods.anotherworld.mechanical;

import mods.anotherworld.mechanical.items.ItemTool;
import mods.anotherworld.world.WorldValues;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
/**
 * Adds crafting recipes to mechanical expansion items.
 * @author Sparkst3r
 *
 */
public class ItemCrafting {
	
	/** Initialise the recipes */
	public static void initialise() {
		
		/** Tinkering Head Assembly*/
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, 2),
				"I I", "I I", "GIG", 'I', new ItemStack(Item.ingotIron, 1, 0), 'G', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 0));
		
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, 3),
				"GTR", "TRT", "RTG", 'G', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 1), 'T', new ItemStack(WorldValues.ItemIngotField, 1, 1), 'R', new ItemStack(Item.blazeRod, 1, 0));
		
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemBasePartsField, 1, 4),
				"CGC", "LWL", "C C", 'G', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 1), 'C', new ItemStack(WorldValues.ItemIngotField, 1, 0), 'L', new ItemStack(WorldValues.ItemIngotField, 1, 3), 'W', new ItemStack(Block.cloth, 1, 13));
		
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemToolField, 1 , ItemTool.ItemToolEnum.ACTIVATE.ordinal()),
				"H  ", " R ", "  G", 'H', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 2), 'R', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 3), 'G', new ItemStack(MechanicalValues.ItemBasePartsField, 1, 4));
	}
}
