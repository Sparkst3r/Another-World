package com.sparkst3r.anotherworld.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Useful ItemStack Methods
 * @author Sparkst3r
 *
 */
public class ItemStackUtils {
	
	/**
	 * Creates a new stack with an NBTCompound
	 * @param meta
	 * @return The new stack
	 */
	public static ItemStack makeStackWithCompound(Item item,int meta) {
		ItemStack newStack = new ItemStack(item, 1, meta);
		newStack.setTagCompound(new NBTTagCompound());	
		return newStack;
	}
	
	public static boolean areStacksOfSameType(ItemStack stack1, ItemStack stack2) {
		if (stack1 != null && stack2 != null && stack1.getItem().getUnlocalizedName() != null && stack2.getItem().getUnlocalizedName() != null) {
			return stack1.getItem().getUnlocalizedName().equals(stack2.getItem().getUnlocalizedName()) ? stack1.getItemDamage() == stack2.getItemDamage() : false;			
		}
		return false;
	}
	
}
