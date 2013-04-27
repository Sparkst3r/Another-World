package mods.anotherworld.world;

import mods.anotherworld.core.AnotherWorld;
import mods.anotherworld.util.RegistryUtils;
import mods.anotherworld.world.blocks.BlockQuartreSlab;
import mods.anotherworld.world.blocks.BlockOre;
import mods.anotherworld.world.blocks.BlockStorage;
import mods.anotherworld.world.blocks.ItemBlockOre;
import mods.anotherworld.world.blocks.ItemBlockStorage;
import mods.anotherworld.world.items.ItemIngot;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

/**
 * Values and other for the world expansion.
 * 
 * @author Sparkst3r
 *
 */
public class WorldValues {
	
	//Ore Based blocks
	public static Block BlockOreField;
	public static Block BlockStorageField;
	public static Item ItemIngotField;
	public static Block BlockQuartreSlabField;
	
	
	public static boolean initialise() {
		ItemIngotField = new ItemIngot(5000);
		BlockOreField = new BlockOre(700);
		BlockStorageField = new BlockStorage(701);
		BlockQuartreSlabField = new BlockQuartreSlab(702);
		
		addInfoForMeta();
		

		
		
		
		ItemCrafting.initialise();
		BlockCrafting.initialise();
		
		
		
		AnotherWorld.proxy.registerRendersForWorld();	
		
		return true;
	}
	
	/**
	 * Adds extra info about meta data blocks/items
	 */
	public static void addInfoForMeta() {
		//Ingot
		for (int meta = 0; meta < ItemIngot.types.length; meta++) {
			RegistryUtils.addName(ItemIngotField, meta, ItemIngot.names[meta]);
			RegistryUtils.registerOre(ItemIngotField, meta, ItemIngot.types[meta]);
		}
		
		//Ore Block
		for (int meta = 0; meta < 4; meta++) {
			RegistryUtils.addName(BlockOreField, meta, ItemBlockOre.names[meta]);
			RegistryUtils.registerOre(BlockOreField, meta, ItemBlockOre.types[meta]);
		}
		
		//Storage Block
		for (int meta = 0; meta < 4; meta++) {
			RegistryUtils.addName(BlockStorageField, meta, ItemBlockStorage.names[meta]);
			RegistryUtils.registerOre(BlockOreField, meta, ItemBlockStorage.types[meta]);
		}
	}
}
