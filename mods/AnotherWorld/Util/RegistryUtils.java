package mods.AnotherWorld.Util;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
/**
 * Some simple and shortcut methods for registering things.
 * @author Sparkst3r
 *
 */
public class RegistryUtils {
	
	/** Language registry*/
	
	/**
	 * Adds a name for item without meta
	 * @param item The item
	 * @param name Name to be applied
	 */
	public static void addName(Item item, String name) {
		ItemStack stack = new ItemStack(item, 1);
		LanguageRegistry.addName(stack, name);
	}
	/**
	 * Adds a name for item with meta
	 * @param item The item
	 * @param meta The item's meta
	 * @param name Name to be applied
	 */
	public static void addName(Item item, int meta, String name) {
		ItemStack stack = new ItemStack(item, 1, meta);
		LanguageRegistry.addName(stack, name);
	}
	/**
	 * Adds a name for item without meta
	 * @param item The item
	 * @param name Name to be applied
	 */
	public static void addName(Block block, String name) {
		ItemStack stack = new ItemStack(block, 1);
		LanguageRegistry.addName(stack, name);
	}
	/**
	 * Adds a name for item with meta
	 * @param item The item
	 * @param meta The item's meta
	 * @param name Name to be applied
	 */
	public static void addName(Block block, int meta, String name) {
		ItemStack stack = new ItemStack(block, 1, meta);
		LanguageRegistry.addName(stack, name);
	}
	
	/**Ore Dictionary */
	
	/**
	 * Registers an item with the ore dictionary, without meta
	 * @param item The item
	 * @param name The code name to register it with
	 */
	public static void registerOre(Item item, String name) {
		OreDictionary.registerOre(name, new ItemStack(item, 1));
	}
	/**
	 * Registers an item with the ore dictionary, with meta
	 * @param item
	 * @param meta
	 * @param name
	 */
	public static void registerOre(Item item, int meta, String name) {
		OreDictionary.registerOre(name, new ItemStack(item, 1, meta));
	}
	/**
	 * Registers a block with the ore dictionary, without meta
	 * @param block
	 * @param name
	 */
	public static void registerOre(Block block, String name) {
		OreDictionary.registerOre(name, new ItemStack(block, 1));
	}
	/**
	 * Registers an block with the ore dictionary, with meta
	 * @param item
	 * @param meta
	 * @param name
	 */
	public static void registerOre(Block block, int meta, String name) {
		OreDictionary.registerOre(name, new ItemStack(block, 1, meta));
	}
}
