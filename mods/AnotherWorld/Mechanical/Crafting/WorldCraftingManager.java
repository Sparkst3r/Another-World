package mods.AnotherWorld.Mechanical.Crafting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.AnotherWorld.Mechanical.Crafting.MechTableCraftingManager.MechanicsShapedRecipe;
import mods.AnotherWorld.Util.EntityUtils;
import mods.AnotherWorld.Util.ItemStackUtils;
import mods.AnotherWorld.Util.WorldUtils;
import mods.AnotherWorld.api.crafting.IWorldBlockRecipe;
import mods.AnotherWorld.api.crafting.IWorldCraftingManager;

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
	

	public static ItemStack getOutput(World world, int x, int y, int z) {
		if (!world.isRemote) {
			ItemStack[] nearbyItems = EntityUtils.getItemsInRadius(world, x, y, z, 2, 2, 2);
			boolean[] hasItems;
			
			
			for (int recipe = 0; recipe < recipes.size(); recipe++) {
				WorldBlockRecipe currentRecipe = getRecipe(recipe);
				hasItems = new boolean[currentRecipe.getItems().length];
				
				int hasItem = 0;
				int recipeItemCount = 0;
				
				if (WorldUtils.isBlockAt(world, x, y, z, Block.blocksList[currentRecipe.recipeBlock.itemID], currentRecipe.recipeBlock.getItemDamage())) {			
					for(int recipeItem = 0; recipeItem < currentRecipe.getItems().length; recipeItem++) {
						for (int item = 0; item < nearbyItems.length; item++) {
							if (ItemStackUtils.areStacksOfSameType(currentRecipe.getItems()[recipeItem], nearbyItems[item]) && nearbyItems[item].stackSize >= currentRecipe.getItems()[recipeItem].stackSize) {
								hasItems[recipeItemCount] = true;
								recipeItemCount++;
								nearbyItems[item].stackSize -= currentRecipe.getItems()[recipeItem].stackSize;
									
								if (allTrue(hasItems)) {
										return currentRecipe.getRecipeOutput();
								}
							}
						}
					}
				}
			}
		}
		return null;
	}
	
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

		public List getItemList() {
			List<ItemStack> items = new ArrayList();
			items = Arrays.asList(recipeItems);
			return items;
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
