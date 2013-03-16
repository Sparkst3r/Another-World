package anotherWorld.common.machines;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidStack;
import thermalexpansion.api.crafting.CraftingManagers;
import anotherWorld.common.ModsExist;
import anotherWorld.common.basicBlocks.BasicBlocks;
import anotherWorld.common.basicItems.BasicItems;

public class MachinesCrafting {
	public static void crafting() {
		addCraftingEngineeringGlass();
		addCraftingTriCS();
	}
	
	
	public static void addCraftingEngineeringGlass() {
		if (ModsExist.teExists) {
			CraftingManagers.smelterManager.addRecipe(40, new ItemStack(Item.redstone, 4), new ItemStack(Block.glass, 4), new ItemStack(Machines.EngineeringGlass, 4), new ItemStack(BasicItems.SiliconSlag, 1), 2 , false);
		}
		
	}
	public static void addCraftingTriCS() {
		if (ModsExist.teExists) {
			CraftingManagers.crucibleManager.addRecipe(1000, new ItemStack(BasicItems.MetGradeSilicon, 1) , new LiquidStack(Machines.TriCSStill, 500), false);
			}
		}
}
