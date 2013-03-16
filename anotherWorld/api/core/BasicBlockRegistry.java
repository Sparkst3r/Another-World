package anotherWorld.api.core;

import anotherWorld.common.basicBlocks.BasicBlocks;
import net.minecraft.item.ItemStack;

/**
 * Provides an interface to BasicBlocks or Tier 1 blocks eg. Ores and decorative blocks.
 */
public class BasicBlockRegistry {
	private static Class BasicBlocks;
	/**
	 * Don't use this class to get Items. Instead use BasicItemRegistry
	 * 
	 * Returns an ItemStack of the item requested example : BasicItemRegistry.get(String "RedLED")
	 * See ItemList.txt for valid names
	 * Make sure to copy() the ItemStack if you want to modify it.
	 *
	 * @param name Block name.
	 * @return An ItemStack of the requested item or null if an error has occured.
	 */
	public static ItemStack get(String name) {
		try {
			if (BasicBlocks == null) 
				
				BasicBlocks = Class.forName("anotherWorld.common.basicItems.BasicItems");
			Object stack = BasicBlocks.getField(name).get(null);
			
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
