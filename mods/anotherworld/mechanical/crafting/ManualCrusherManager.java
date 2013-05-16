package mods.anotherworld.mechanical.crafting;

import java.util.ArrayList;
import java.util.List;

import mods.anotherworld.api.crafting.IManualCrusherManager;
import mods.anotherworld.api.crafting.IManualCrusherRecipe;
import mods.anotherworld.util.ItemStackUtils;
import net.minecraft.item.ItemStack;

public class ManualCrusherManager implements IManualCrusherManager {
	public static List<IManualCrusherRecipe> recipes  = new ArrayList<IManualCrusherRecipe>();
	
	@Override
	public boolean addRecipe(ItemStack inputStack, ItemStack outputStack) {
		recipes.add(new ManualCrusherRecipe(inputStack, outputStack));
		return true;
	}
	
	public static IManualCrusherRecipe getOutput(ItemStack inputStack) {
		for (IManualCrusherRecipe recipe : recipes) {
			if (recipe.matches(inputStack)) {
				return recipe;
			}
		}
		return null;
	}
	
	
	
	public class ManualCrusherRecipe implements IManualCrusherRecipe {
			
			private ItemStack recipeStack;
			private ItemStack recipeOutputStack;
			
			public ManualCrusherRecipe(ItemStack inputStack, ItemStack outputStack) {
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



	@Override
	public List<IManualCrusherRecipe> getRecipes() {
		return recipes;
	}
}
