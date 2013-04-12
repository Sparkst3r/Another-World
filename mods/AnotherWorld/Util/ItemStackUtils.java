package mods.AnotherWorld.Util;

import mods.AnotherWorld.Mechanical.MechanicalValues;
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
	
}
