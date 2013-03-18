package mods.anotherWorld.common.basicItems;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.anotherWorld.common.machines.Machines;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
/*
import cpw.mods.fml.common.registry.GameRegistry;
import thermalexpansion.api.crafting.CraftingManagers;
import ic2.api.Items;
import anotherWorld.common.ModsExist;
import anotherWorld.common.basicBlocks.BasicBlocks;
import anotherWorld.common.machines.Machines;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
*/


public class BasicItemsCrafting {
	public static ItemStack engGlass = new ItemStack(Machines.EngineeringGlass, 1);
	public static ItemStack sil = new ItemStack(BasicItems.SiliconChip, 1);
	public static void crafting() {
		//addCraftingRedLED();
		//addCraftingGreenLED();
		//addCraftingBlueLED();
		//addMetGradeSiliconRecipe();
		//addBlueprintRecipe();
		//addGlueRecipe();
		addQuartzCrucibleRecipe();
		//addSiliconBouleRecipe();
		//addSiliconChipRecipe();
	}
	
	/*
	public static void addSiliconChipRecipe() {
		//Using sand until 1.5 adds quartz
		if (ModsExist.teExists && ModsExist.ic2Exists) {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(BasicItems.SiliconChip, 3), true, new Object[]{
                "CWC", " F ", "CWC",
                'C', "ingotCopper", 'W', BasicItems.SiliconSlice, 'F', Items.getItem("carbonFiber")    }));
		}
	}
	*/
		/*
	public static void addSiliconBouleRecipe() {
		if (ModsExist.teExists) {
			CraftingManagers.transposerManager.addFillRecipe(
					200, new ItemStack(BasicItems.QuartzCrucible, 1), new ItemStack(BasicItems.SiliconBoule, 1), new LiquidStack(Machines.TriCSStill, 4000), false, false);
		}
	
	}
	*/
	/*
	public static void addGlueRecipe(){
		if (ModsExist.ic2Exists) {
			GameRegistry.addRecipe(new ItemStack(BasicItems.Glue, 1), new Object[]{
				"SRS", "RGR", "SRS", 
				'S', Item.slimeBall, 'R', Items.getItem("resin"), 'G', Item.glassBottle 
			});
		}
	}
	*/
	
	
	public static void addQuartzCrucibleRecipe() {
		//Using sand until 1.5 adds quartz
		GameRegistry.addRecipe(new ItemStack(BasicItems.QuartzCrucible, 1), new Object[]{
			"Q Q", "Q Q", " Q ", 
			'Q', Item.field_94583_ca
		});
		
	}


	
	/*
	public static void addBlueprintRecipe(){
		GameRegistry.addRecipe(new ItemStack(BasicItems.Blueprint, 1), new Object[]{
			"BGB", "G G", "BGB", 
			'B', BasicItems.BlueprintPart, 'G', BasicItems.Glue
		});	
	}
	*/
	
	/*
	public static void addMetGradeSiliconRecipe() {
		if (ModsExist.teExists) {
			//Using sand until 1.5 adds quartz
			CraftingManagers.smelterManager.addRecipe(40, new ItemStack(Item.field_94583_ca, 1), Items.getItem("coalDust"), new ItemStack(BasicItems.MetGradeSilicon, 2), false);
		}
	}
	*/
	
	/*
	public static void addCraftingRedLED() {
		ItemStack dyeRedLED = new ItemStack(Item.dyePowder, 1, 1);
		if (ModsExist.teExists) {
		GameRegistry.addRecipe(new ItemStack(BasicItems.RedLED, 4, 1), new Object[]{
			" G ", " D ", " S ", 
			'G', engGlass, 'D', dyeRedLED, 'S', sil
		});
		}
	}
	*/
	/*
	public static void addCraftingGreenLED() {
		ItemStack dyeGreenLED = new ItemStack(Item.dyePowder, 1, 2);
		if (ModsExist.teExists) {
		GameRegistry.addRecipe(new ItemStack(BasicItems.GreenLED, 4, 1), new Object[]{
			" G ", " D ", " S ", 
			'G', engGlass, 'D', dyeGreenLED, 'S', sil
			});
		}
	}
	*/
	
	/*
	public static void addCraftingBlueLED() {
		ItemStack dyeBlueLED = new ItemStack(Item.dyePowder, 1, 4);
		if (ModsExist.teExists) {
			GameRegistry.addRecipe(new ItemStack(BasicItems.BlueLED, 4, 1), new Object[]{
				" G ", " D ", " S ", 
				'G', engGlass, 'D', dyeBlueLED, 'S', sil
			});
		}

	}
	 	*/
}

