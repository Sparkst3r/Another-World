package mods.anotherworld.mechanical.crafting;

import java.util.ArrayList;
import java.util.List;

import mods.anotherworld.api.crafting.IManualCrusherManager;
import mods.anotherworld.util.ItemStackUtils;
import net.minecraft.item.ItemStack;

public class ManualCrusherManager implements IManualCrusherManager {
	public static List<ManualCrusherRecipe> recipes  = new ArrayList<ManualCrusherRecipe>();
	
	@Override
	public boolean addRecipe(ItemStack outputStack, ItemStack inputStack) {
		recipes.add(new ManualCrusherRecipe(outputStack, inputStack));
		return true;
	}
	
	public static ManualCrusherRecipe getOutput(ItemStack inputStack) {
		for (ManualCrusherRecipe recipe : recipes) {
			if (recipe.matches(inputStack)) {
				return recipe;
			}
		}
		return null;
	}
	
	
	
	public class ManualCrusherRecipe {// implements IManualCrusherRecipe {
			
			private ItemStack recipeStack;
			private ItemStack recipeOutputStack;
			
			public ManualCrusherRecipe(ItemStack outputStack, ItemStack inputStack) {
				recipeStack = inputStack;
				recipeOutputStack = outputStack;
			}

			public ItemStack getInputStack() {
				return recipeStack;
			}

			public boolean matches(ItemStack inputStack) {
				if (ItemStackUtils.areStacksOfSameType(inputStack, recipeStack) && inputStack.stackSize >= recipeStack.stackSize) {
					return true;
				}
				return false;
			}
	
			public ItemStack getRecipeOutput() {
				return new ItemStack(recipeOutputStack.itemID, recipeOutputStack.stackSize, recipeOutputStack.getItemDamage());
			}
			
		}
}
