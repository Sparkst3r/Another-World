package com.sparkst3r.anotherworld.mechanical.crafting;


import java.util.ArrayList;
import java.util.List;

import com.sparkst3r.anotherworld.api.crafting.IWorldCraftingManager;
import com.sparkst3r.anotherworld.util.EntityUtils;
import com.sparkst3r.anotherworld.util.ItemStackUtils;
import com.sparkst3r.anotherworld.util.WorldUtils;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Crafting Manager for the world.
 * 
 * @author Sparkst3r
 *
 */
public class WorldCraftingManager implements IWorldCraftingManager{
	
	/** The list of world recipes */
	private static List<WorldBlockRecipe> recipes = new ArrayList<WorldBlockRecipe>();
	
	/**
	 * Adds a recipe to the world crafting recipes
	 * @param outputBlock The block that will be placed if the recipe is fulfilled
	 * @param inputBlock The block that will be used in the recipe
	 * @param items The items required to be surrounding the block when assembled
	 * @return If the recipe was added.
	 */
	@Override
	public boolean addRecipe(ItemStack outputBlock, ItemStack inputBlock, ItemStack[] items) {
		if(items != null && inputBlock != null) {
			WorldBlockRecipe shapedRecipe = new WorldBlockRecipe(outputBlock, inputBlock, items);
			recipes.add(shapedRecipe);
		}
		return true;
	}
	
	/**
	 * Gets a recipe at a certain index
	 * @param index The index in the list of recipes
	 * @return the block recipe
	 */
	public static WorldBlockRecipe getRecipe(int index) {
		return (WorldBlockRecipe) recipes.get(index);
	}
	
	/**
	 * Returns the list of all recipes
	 * @return The list
	 */
	public static List<WorldBlockRecipe> getAllRecipes() {
		return recipes;
	}
	
	/*TODO Rewrite this */
	/**
	 * Returns an ItemStack result based on the block clicked and the items surrounding the block
	 * @param world The world
	 * @param x The x coordinate clicked
	 * @param y The y coordinate clicked
	 * @param z The z coordinate clicked
	 * @return An ItemStack of the output block
	 */
	public static ItemStack getOutput(World world, int x, int y, int z) {
		if (!world.isRemote) {
			ItemStack[] nearbyItems = EntityUtils.getItemsInRadius(world, x, y, z, 2, 2, 2);
			boolean[] hasItems;
			
			System.out.println(nearbyItems.length);
			
			for (int recipe = 0; recipe < recipes.size(); recipe++) {
				WorldBlockRecipe currentRecipe = getRecipe(recipe);
				hasItems = new boolean[currentRecipe.getItems().length];
				boolean[][] itemInArray = new boolean[nearbyItems.length][currentRecipe.getItems().length];
				int recipeItemCount = 0;
				
				if (WorldUtils.isBlockAt(world, x, y, z, Block.getBlockFromItem(currentRecipe.getInputBlock().getItem()), currentRecipe.recipeBlock.getItemDamage())) {
					for(int recipeItem = 0; recipeItem < currentRecipe.getItems().length; recipeItem++) {
						for (int item = 0; item < nearbyItems.length; item++) {
							if (ItemStackUtils.areStacksOfSameType(currentRecipe.getItems()[recipeItem], nearbyItems[item]) && nearbyItems[item].stackSize >= currentRecipe.getItems()[recipeItem].stackSize) {
								hasItems[recipeItemCount] = true;
								recipeItemCount++;
								itemInArray[item][recipeItem] = true;
							}
							if (allTrue(hasItems)) {
								for (int I = 0; I < nearbyItems.length; I++) {
									for(int RI = 0; RI < currentRecipe.getItems().length; RI++) {
										if(itemInArray[I][RI]) {
											nearbyItems[I].stackSize -= currentRecipe.getItems()[RI].stackSize;
										}
									}
								}
								return currentRecipe.getRecipeOutput();	
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	
	/**
	 * Checks if all values in the boolean array are true
	 * @param array
	 * @return if the array is all true
	 */
	public static boolean allTrue(boolean[] array) {
	    for(boolean b : array){
	    	if(!b) {
	    		return false;
	    	}
	    }
	    return true;
	}


	
	
	public class WorldBlockRecipe implements IWorldBlockRecipe {
		
		private ItemStack recipeBlock;
		private ItemStack recipeItems[];
		private ItemStack recipeOutput;
		
		public WorldBlockRecipe(ItemStack outputBlock, ItemStack inputBlock, ItemStack[] items) {
			recipeBlock = inputBlock;
			recipeItems = items;
			recipeOutput = outputBlock;
		}

		@Override
		public boolean matches(ItemStack[] inputStacks, World world) {
			return true;
		}


		/**
		 * Returns the array of input ItemStacks required for this recipe
		 * @return The ItemStack array
		 */
		@Override
		public ItemStack[] getItems() {
			return recipeItems;
		}
		
		/**
		 * Returns the ItemStack of the inputBlock for this recipe
		 * @return ItemStack of the input block
		 */
		@Override
		public ItemStack getInputBlock() {
			return new ItemStack(recipeBlock.getItem(), 1, recipeBlock.getItemDamage());
		}
		
		/**
		 * Gets the output block for this recipe
		 * @return ItemStack of the output block of this recipe
		 */
		@Override
		public ItemStack getRecipeOutput() {
			return new ItemStack(recipeOutput.getItem(), 1, recipeOutput.getItemDamage());
		}
		
	}
	
	
	/**
	 * World Block Recipe 
	 * @author Sparkst3r
	 *
	 */
	public abstract interface IWorldBlockRecipe {
		
		public abstract boolean matches(ItemStack[] inputStacks, World world);


		/**
		 * Returns the array of input ItemStacks required for this recipe
		 * @return The ItemStack array
		 */
		public abstract ItemStack[] getItems();
			
		/**
		 * Returns the ItemStack of the inputBlock for this recipe
		 * @return
		 */
		public abstract ItemStack getInputBlock();
				
		/**
		 * Gets the output block for this recipe
		 * @return ItemStack of the output block of this recipe
		 */
		public ItemStack getRecipeOutput();
	}
	
	
}
