package mods.anotherworld.world;

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
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(WorldValues.BlockStorageField, 1, 0), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotCopper"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(WorldValues.BlockStorageField, 1, 1), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotTin"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(WorldValues.BlockStorageField, 1, 2), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotSilver"
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(WorldValues.BlockStorageField, 1, 3), 
				new Object[] {
			"III","III","III", Character.valueOf('I'), "ingotLead"
		}));
	}

}
