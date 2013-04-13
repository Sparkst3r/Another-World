package mods.AnotherWorld.Mechanical.Container;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class MechanicsShapedRecipe implements IRecipe {
	/** The width of the crafting matrix*/
	private int matrixWidth;
	/** The height of the crafting matrix*/
	private int matrixHeight;
	private ItemStack recipeItems[];
	private ItemStack recipeOutput;
	public final int recipeOutputItemID;
	
	public MechanicsShapedRecipe(int width, int height, ItemStack[] inputstacks, ItemStack outputstack) {
		recipeOutputItemID = outputstack.itemID;
		matrixWidth = width;
		matrixHeight = height;
		recipeItems = inputstacks;
		recipeOutput = outputstack;
	}
	
	/** Returns an itemstack of the output of the recipe */
	public ItemStack getRecipeOutput() {
		return recipeOutput;     
	}
	
	/** Checks the matrix against the list of recipes and returns if a match was found*/
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
	
	/** Does the actual checking of the matrix against the list of recipes */
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


	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting) {
		return new ItemStack(recipeOutput.itemID, recipeOutput.stackSize, recipeOutput.getItemDamage());
	}
	
	public int getRecipeSize() {
		return matrixWidth * matrixHeight;
	}
}