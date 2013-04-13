package mods.AnotherWorld.Mechanical.Container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeFireworks;
import net.minecraft.item.crafting.RecipesArmor;
import net.minecraft.item.crafting.RecipesArmorDyes;
import net.minecraft.item.crafting.RecipesCrafting;
import net.minecraft.item.crafting.RecipesDyes;
import net.minecraft.item.crafting.RecipesFood;
import net.minecraft.item.crafting.RecipesIngots;
import net.minecraft.item.crafting.RecipesMapCloning;
import net.minecraft.item.crafting.RecipesMapExtending;
import net.minecraft.item.crafting.RecipesTools;
import net.minecraft.item.crafting.RecipesWeapons;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class MechTableCraftingManager {
	private static final MechTableCraftingManager instance = new MechTableCraftingManager();

	private List recipes = new ArrayList();

	public static final MechTableCraftingManager getInstance() {
		return instance;
	}

	/** Add default recipes to be craftable in the table */
	private MechTableCraftingManager() {
	}

	public MechanicsShapedRecipe addRecipe(ItemStack par1ItemStack, Object ... recipe) {
		String recipeArg = "";
		int recipePos = 0;
		int var5 = 0;
		int var6 = 0;

		if (recipe[recipePos] instanceof String[]) {
			String[] recipeString = ((String[])recipe[recipePos++]);
			for (int position = 0; position < recipeString.length; position++) {
				String var9 = recipeString[position];
				var6++;
				var5 = var9.length();
				recipeArg += var9;
			}
         }
		else {
			while (recipe[recipePos] instanceof String) {
				String var11 = (String)recipe[recipePos++];
				++var6;
				var5 = var11.length();
				recipeArg = recipeArg + var11;
			}
		}

		HashMap map;

		for (map = new HashMap(); recipePos < recipe.length; recipePos += 2) {
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

         ItemStack[] var15 = new ItemStack[var5 * var6];

         for (int var16 = 0; var16 < var5 * var6; ++var16) {
                 char var10 = recipeArg.charAt(var16);

                 if (map.containsKey(Character.valueOf(var10))) {
                         var15[var16] = ((ItemStack)map.get(Character.valueOf(var10))).copy();
                 }
                 else {
                         var15[var16] = null;
                 }
         }

         MechanicsShapedRecipe shapedRecipe = new MechanicsShapedRecipe(var5, var6, var15, par1ItemStack);
         this.recipes.add(shapedRecipe);
         return shapedRecipe;
}

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

	public ItemStack findMatchingRecipe(InventoryCrafting craftMatrix, World world) {
		int var3 = 0;
		ItemStack var4 = null;
		ItemStack var5 = null;
		int slot;

		for (slot = 0; slot < craftMatrix.getSizeInventory(); slot++) {
			ItemStack stackInSlot = craftMatrix.getStackInSlot(slot);
			if (stackInSlot != null) {
				if (var3 == 0) {
					var4 = stackInSlot;
				}
				if (var3 == 1) {
					var5 = stackInSlot;
				}
				var3++;	
			}
		}

         if (var3 == 2 && var4.itemID == var5.itemID && var4.stackSize == 1 && var5.stackSize == 1 && Item.itemsList[var4.itemID].isRepairable()) {
                 Item item = Item.itemsList[var4.itemID];
                 int var13 = item.getMaxDamage() - var4.getItemDamageForDisplay();
                 int var8 = item.getMaxDamage() - var5.getItemDamageForDisplay();
                 int var9 = var13 + var8 + item.getMaxDamage() * 5 / 100;
                 int var10 = item.getMaxDamage() - var9;

                 if (var10 < 0)
                 {
                         var10 = 0;
                 }

                 return new ItemStack(var4.itemID, 1, var10);
         }
         else {
                 for (slot = 0; slot < this.recipes.size(); ++slot)
                 {
                         IRecipe recipe = (IRecipe)this.recipes.get(slot);

                         if (recipe.matches(craftMatrix, world))
                         {
                                 return recipe.getCraftingResult(craftMatrix);
                         }
                 }

                 return null;
         }
	}
	/** Returns the list of recipes */
	public List getRecipeList() {
		return this.recipes;
	}
}