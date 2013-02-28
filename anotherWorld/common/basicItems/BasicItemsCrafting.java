package anotherWorld.common.basicItems;

import ic2.api.Items;
import thermalexpansion.api.crafting.CraftingManagers;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import anotherWorld.common.ModsExist;
import anotherWorld.common.basicBlocks.BasicBlocks;
import cpw.mods.fml.common.registry.GameRegistry;

public class BasicItemsCrafting {
	public static ItemStack engGlass = new ItemStack(BasicBlocks.EngineeringGlass, 1);
	public static ItemStack sil = new ItemStack(BasicItems.SiliconChip, 1);
	
	public static void crafting() {
		addCraftingRedLED();
		addCraftingGreenLED();
		addCraftingBlueLED();
		addMetGradeSiliconRecipe();
	}
	
	
	
	
	public static void addMetGradeSiliconRecipe() {
		ItemStack coalDust = Items.getItem("coalDust");
		//Using sand until 1.5 adds quartz
		CraftingManagers.smelterManager.addRecipe(40, new ItemStack(Block.sand, 1), coalDust, new ItemStack(BasicItems.MetGradeSilicon, 2), false);
		
	}




	public static void addCraftingRedLED() {
			ItemStack dyeRedLED = new ItemStack(Item.dyePowder, 1, 1);
			GameRegistry.addRecipe(new ItemStack(BasicItems.RedLED, 4, 1), new Object[]{
				" G ", " D ", " S ", 
				'G', engGlass, 'D', dyeRedLED, 'S', sil
			});
	}
	
	public static void addCraftingGreenLED() {
		ItemStack dyeGreenLED = new ItemStack(Item.dyePowder, 1, 2);
		GameRegistry.addRecipe(new ItemStack(BasicItems.GreenLED, 4, 1), new Object[]{
			" G ", " D ", " S ", 
			'G', engGlass, 'D', dyeGreenLED, 'S', sil
		});
}
	
	public static void addCraftingBlueLED() {
	ItemStack dyeBlueLED = new ItemStack(Item.dyePowder, 1, 4);
	GameRegistry.addRecipe(new ItemStack(BasicItems.BlueLED, 4, 1), new Object[]{
		" G ", " D ", " S ", 
		'G', engGlass, 'D', dyeBlueLED, 'S', sil
		});
	}
}

