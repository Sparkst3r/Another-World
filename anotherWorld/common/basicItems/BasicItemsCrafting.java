package anotherWorld.common.basicItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import anotherWorld.common.ModsExist;
import anotherWorld.common.basicBlocks.BasicBlocks;
import cpw.mods.fml.common.registry.GameRegistry;

public class BasicItemsCrafting {
	public static void crafting() {
		addCraftingRedLED();
	}
	
	
	
	
	public static void addCraftingRedLED() {
		if (ModsExist.teExists) {

			ItemStack glassRedLED = new ItemStack(BasicBlocks.EngineeringGlass, 1);
			ItemStack dyeRedLED = new ItemStack(Item.dyePowder, 1, 1);
			ItemStack silRedLED = new ItemStack(BasicItems.SiliconChip, 1);
			
			GameRegistry.addRecipe(new ItemStack(BasicItems.RedLED, 4), new Object[]{
				" G ", " D ", " S ", 
				'G', glassRedLED, 'D', dyeRedLED, 'S', silRedLED
			});
			
			
		}
	}
}
