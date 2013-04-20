package mods.anotherworld.mechanical.crafting;


import java.util.ArrayList;
import java.util.List;

import mods.anotherworld.api.crafting.IWorldBlockRecipe;
import mods.anotherworld.api.crafting.IWorldCraftingManager;
import mods.anotherworld.util.EntityUtils;
import mods.anotherworld.util.ItemStackUtils;
import mods.anotherworld.util.WorldUtils;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WorldCraftingManager implements IWorldCraftingManager{
	private static List recipes = new ArrayList();
	
	
	@Override
	public boolean addRecipe(ItemStack outputBlock, ItemStack inputBlock, ItemStack[] items) {
		if(items != null) {
			WorldBlockRecipe shapedRecipe = new WorldBlockRecipe(outputBlock, inputBlock, items);
			recipes.add(shapedRecipe);
		}
		return true;
	}
	
	public static WorldBlockRecipe getRecipe(int index) {
		return (WorldBlockRecipe) recipes.get(index);
	}
	
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
			
			for (int recipe = 0; recipe < recipes.size(); recipe++) {
				WorldBlockRecipe currentRecipe = getRecipe(recipe);
				hasItems = new boolean[currentRecipe.getItems().length];
				boolean[][] itemInArray = new boolean[nearbyItems.length][currentRecipe.getItems().length];
				int recipeItemCount = 0;
				
				if (WorldUtils.isBlockAt(world, x, y, z, Block.blocksList[currentRecipe.getBlock().itemID], currentRecipe.recipeBlock.getItemDamage())) {			
					for(int recipeItem = 0; recipeItem < currentRecipe.getItems().length; recipeItem++) {
						for (int item = 0; item < nearbyItems.length; item++) {
							if (ItemStackUtils.areStacksOfSameType(currentRecipe.getItems()[recipeItem], nearbyItems[item]) && nearbyItems[item].stackSize >= currentRecipe.getItems()[recipeItem].stackSize) {
								hasItems[recipeItemCount] = true;
								recipeItemCount++;
								itemInArray[item][recipeItem] = true;
							}
							
							
							if (allTrue(hasItems)) {
								for (int I = 0; I < nearbyItems.length; I++) {
									System.out.println(nearbyItems.length);
									for(int RI = 0; RI < currentRecipe.getItems().length; RI++) {
										System.out.println(itemInArray[I][RI]);
										
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
	 * @return
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

		
		public ItemStack[] getItems() {
			return recipeItems;
		}
		
		public ItemStack getBlock() {
			return recipeBlock;
		}
		
		@Override
		public boolean matches(ItemStack[] inputStacks, World world) {
			return true;
		}

		@Override
		public ItemStack getCraftingResult(ItemStack[] inputStacks) {
			return new ItemStack(recipeOutput.itemID, 1, recipeOutput.getItemDamage());
		}

		@Override
		public ItemStack getRecipeOutput() {
			return new ItemStack(recipeOutput.itemID, 1, recipeOutput.getItemDamage());
		}
		
	}
	
	
	
}
