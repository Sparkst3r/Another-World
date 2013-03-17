package mods.anotherWorld.api.core;

import mods.anotherWorld.common.basicItems.BasicItems;
import net.minecraft.item.ItemStack;

/**
 * Provides an interface to BasicItems or Tier 1 items
 */
public class BasicItemRegistry {
	private static Class BasicItems;
	/**
	 *Don't use this class to get Blocks. Instead use BasicBlockRegistry
	 * 
	 * Returns an ItemStack of the item requested example : BasicItemRegistry.get(String "RedLED")
	 * See ItemList.txt for valid names
	 * Make sure to copy() the ItemStack if you want to modify it.
	 *
	 * @param name Item name.
	 * @return An ItemStack of the requested item or null if an error has occured.
	 */
	public static ItemStack get(String name) {
		try {
			if (BasicItems == null) 
				
				BasicItems = Class.forName("anotherWorld.common.basicItems.BasicItems");
			Object stack = BasicItems.getField(name).get(null);
			
			if (stack instanceof ItemStack) {
				return (ItemStack) stack;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("[AnotherWorld] API Call failed at : " + name);
			return null;
		}
	}
	

}
