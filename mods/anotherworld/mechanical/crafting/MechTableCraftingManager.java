package mods.anotherworld.mechanical.crafting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mods.anotherworld.api.crafting.IMechanicsTableManager;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class MechTableCraftingManager implements IMechanicsTableManager{
	
	private static List<MechanicsShapedRecipe> recipes = new ArrayList<MechanicsShapedRecipe>();
	
	
	/**
	 * Adds a recipe to the list. 
	 * Not recommended adding the recipe through this method use the corresponding method in the API
	 */
	public boolean addRecipe(ItemStack outputStack, Object... recipe) {
		String recipeArg = "";
		int recipePos = 0;
		int width = 0;
		int height = 0;

		if (recipe[recipePos] instanceof String[]) {
			String[] recipeString = ((String[])recipe[recipePos++]);
			for (int position = 0; position < recipeString.length; position++) {
				String var9 = recipeString[position];
				height++;
				width = var9.length();
				recipeArg += var9;
			}
         }
		else {
			while (recipe[recipePos] instanceof String) {
				String stringPos = (String)recipe[recipePos++];
				++height;
				width = stringPos.length();
				recipeArg = recipeArg + stringPos;
			}
		}

		HashMap<Character, ItemStack> map;

		for (map = new HashMap<Character, ItemStack>(); recipePos < recipe.length; recipePos += 2) {
			Character recipeChar = (Character)recipe[recipePos];
			ItemStack stack = null;

			if (recipe[recipePos + 1] instanceof Item) {
				stack = new ItemStack((Item)recipe[recipePos + 1]);
			}
			else if (recipe[recipePos + 1] instanceof Block) {
				stack = new ItemStack((Block)recipe[recipePos + 1], 1, -1);
			}
			else if (recipe[recipePos + 1] instanceof ItemStack) {
				stack = (ItemStack)recipe[recipePos + 1];
			}
			map.put(recipeChar, stack);
		}

         ItemStack[] inputStacks = new ItemStack[width * height];

         for (int charCount = 0; charCount < width * height; ++charCount) {
                 char stackChar = recipeArg.charAt(charCount);

                 if (map.containsKey(Character.valueOf(stackChar))) {
                         inputStacks[charCount] = ((ItemStack)map.get(Character.valueOf(stackChar))).copy();
                 }
                 else {
                         inputStacks[charCount] = null;
                 }
         }

         MechanicsShapedRecipe shapedRecipe = new MechanicsShapedRecipe(width, height, inputStacks, outputStack);
         MechTableCraftingManager.recipes.add(shapedRecipe);
         return true;
}
	/**
	 * Incomplete
	 * TODO Finish it
	 */
	/*
public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj) {
         ArrayList var3 = new ArrayList();
         Object[] var4 = par2ArrayOfObj;
         int var5 = par2ArrayOfObj.length;

         for (int var6 = 0; var6 < var5; ++var6)
         {
                 Object var7 = var4[var6];

                 if (var7 instanceof ItemStack)
                 {
                         var3.add(((ItemStack)var7).copy());
                 }
                 else if (var7 instanceof Item)
                 {
                         var3.add(new ItemStack((Item)var7));
                 }
                 else
                 {
                         if (!(var7 instanceof Block))
                         {
                                 throw new RuntimeException("Invalid shapeless recipe!");
                         }

                         var3.add(new ItemStack((Block)var7));
                 }
         }

         this.recipes.add(new ShapelessRecipes(par1ItemStack, var3));
}
	*/

	/**
	 * Lookup in the recipe list to find a matching recipe.
	 * @param craftMatrix The crafting matrix
	 * @param world The current world
	 * @return The result if it found a recipe
	 */
	public static ItemStack getOutput(InventoryCrafting craftMatrix, World world) {
		int var3 = 0;
		ItemStack stack1 = null;
		ItemStack stack2 = null;
		int slot;

		for (slot = 0; slot < craftMatrix.getSizeInventory(); slot++) {
			ItemStack stackInSlot = craftMatrix.getStackInSlot(slot);
			if (stackInSlot != null) {
				if (var3 == 0) {
					stack1 = stackInSlot;
				}
				if (var3 == 1) {
					stack2 = stackInSlot;
				}
				var3++;	
			}
		}

		/**
		 * Is the item a type that is repair-able
		 */
		if (var3 == 2 && stack1.itemID == stack1.itemID && stack1.stackSize == 1 && stack2.stackSize == 1 && Item.itemsList[stack1.itemID].isRepairable()) {
			Item item = Item.itemsList[stack2.itemID];
			int stack1Damage = item.getMaxDamage() - stack1.getItemDamageForDisplay();
			int stack2Damage = item.getMaxDamage() - stack2.getItemDamageForDisplay();
			
			int repairedDamage = stack1Damage + stack2Damage + item.getMaxDamage() * 5 / 100;
			
			int meta = item.getMaxDamage() - repairedDamage;

			if (meta < 0) {
				meta = 0;
			}
			
			return new ItemStack(stack1.itemID, 1, meta);
		}
		
		/**
		 * Else this is a standard recipe, look for it in the recipe map
		 */
		else {
			for (slot = 0; slot < recipes.size(); ++slot) {
				IRecipe recipe = (IRecipe)recipes.get(slot);
				if (recipe.matches(craftMatrix, world)) {
					return recipe.getCraftingResult(craftMatrix);
				}
			}
			return null;
		}
	}
	
	
	/** Returns the list of recipes */
	public List<MechanicsShapedRecipe> getRecipeList() {
		return MechTableCraftingManager.recipes;
	}
	
	
	public class MechanicsShapedRecipe implements IRecipe {
		/** The width of the crafting matrix*/
		private int matrixWidth;
		/** The height of the crafting matrix*/
		private int matrixHeight;
		private ItemStack recipeItems[];
		private ItemStack recipeOutput;
		public final int recipeOutputItemID;
		
		
		public MechanicsShapedRecipe(int width, int height, ItemStack[] inputStacks, ItemStack outputStack) {
			recipeOutputItemID = outputStack.itemID;
			matrixWidth = width;
			matrixHeight = height;
			recipeItems = inputStacks;
			recipeOutput = outputStack;
		}
		
		/** Returns an itemstack of the output of the recipe */
		public ItemStack getRecipeOutput() {
			return recipeOutput;     
		}
		
		/** Checks if the matrix's recipe is a valid shape*/
		public boolean matches(InventoryCrafting craftMatrix, World world) {
			for (int slotX = 0; slotX <= 4 - matrixWidth; slotX++) {
				for (int slotY = 0; slotY <= 4 - matrixHeight; slotY++) {
					if (checkMatch(craftMatrix, slotX, slotY, true)) {
						return true;
					}
					if (checkMatch(craftMatrix, slotX, slotY, false)) {
						return true;
					}
				}
			}
			return false;
		}
		
		/** Checks if the matrix's recipe is a valid shape*/
		private boolean checkMatch(InventoryCrafting craftMatrix, int slotX, int slotY, boolean flag) {
			for (int slotAtX = 0; slotAtX < 4; slotAtX++) {
				for (int slotAtY = 0; slotAtY < 4; slotAtY++) {
					int i1 = slotAtX - slotX;
					int j1 = slotAtY - slotY;
					ItemStack itemstack = null;
					if (i1 >= 0 && j1 >= 0 && i1 < matrixWidth && j1 < matrixHeight) {
						if (flag) {
							itemstack = recipeItems[(matrixWidth - i1 - 1) + j1 * matrixWidth];
						}
						else {
							itemstack = recipeItems[i1 + j1 * matrixWidth];
						}
					}
					ItemStack itemstack1 = craftMatrix.getStackInRowAndColumn(slotAtX, slotAtY);
					if (itemstack1 == null && itemstack == null) {
						continue;
					}
					if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null) {
						return false;
					}
					if (itemstack.itemID != itemstack1.itemID) {
						return false;
					}
					if (itemstack.getItemDamage() != -1 && itemstack.getItemDamage() != itemstack1.getItemDamage()) {
						return false;
					}
				}
			}
			return true;
		}

		/** Returns the crafting result based on the crafting matrix */ 
		public ItemStack getCraftingResult(InventoryCrafting inventorycrafting) {
			return new ItemStack(recipeOutput.itemID, recipeOutput.stackSize, recipeOutput.getItemDamage());
		}
		
		/** Gets the size of the crafting matrix */
		public int getRecipeSize() {
			return matrixWidth * matrixHeight;
		}
	}


}