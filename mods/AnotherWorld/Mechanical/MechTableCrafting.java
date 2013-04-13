package mods.AnotherWorld.Mechanical;

import mods.AnotherWorld.Mechanical.Container.MechTableCraftingManager;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class MechTableCrafting {
	
	public static void initialise() {
		MechTableCraftingManager.getInstance().addRecipe(new ItemStack(Block.planks, 2, 0), new Object[]{"D  D", "D  D", "D  D","D  D", 'D', Block.dirt});
	}
}
