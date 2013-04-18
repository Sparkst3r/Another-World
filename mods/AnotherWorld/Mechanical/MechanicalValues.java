package mods.AnotherWorld.Mechanical;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.AnotherWorld.Core.AnotherWorld;
import mods.AnotherWorld.Mechanical.Blocks.*;
import mods.AnotherWorld.Mechanical.Crafting.MechTableCraftingManager;
import mods.AnotherWorld.Mechanical.Crafting.WorldCraftingManager;
import mods.AnotherWorld.Mechanical.Items.ItemBaseParts;
import mods.AnotherWorld.Mechanical.Items.ItemTool;
import mods.AnotherWorld.Mechanical.TileEntity.TileMechanicsTable;
import mods.AnotherWorld.Util.RegistryUtils;
import mods.AnotherWorld.World.Items.ItemIngot;
import mods.AnotherWorld.api.crafting.CraftingManagers;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Values associated with the mechanical expansion
 * @author Sparkst3r
 *
 */
public class MechanicalValues {
	
	
	//Blocks
	public static Block BlockMechTablePartsField;
	public static Block BlockBasePartsField;
	
	public static Item ItemToolField;
	public static Item ItemBasePartsField;

	
	public static void initialise() {
		/** Initialise the crafting manager and bind it to the API functions */
		CraftingManagers.mechanicsTable = new MechTableCraftingManager();
		CraftingManagers.world = new WorldCraftingManager();
		
		BlockBasePartsField = new BlockBaseParts(712);
		BlockMechTablePartsField = new BlockMechanicsTableParts(711);

		
		ItemToolField = new ItemTool(5001);
		ItemBasePartsField = new ItemBaseParts(5002);
		
		registerTileEntities();
		addInfoForMeta();
		ItemCrafting.initialise();
		
		
		
		SpecialCrafting.initialise();
		//Registers the customs renderers
		AnotherWorld.proxy.registerRenders();	

	
	}
	
	/**
	 * Adds extra information for meta data items. Eg. Names
	 */
	public static void addInfoForMeta() {
		//Tool
		for (int meta = 0; meta < ItemTool.types.length; meta++) {	
			RegistryUtils.addName(ItemToolField, meta, ItemTool.names[0]);
		}
		
		for (int meta = 0; meta < ItemBaseParts.types.length; meta++) {
			RegistryUtils.addName(ItemBasePartsField, meta, ItemBaseParts.names[meta]);
		}
		
		for (int meta = 0; meta < ItemBlockBaseParts.types.length; meta++) {
			RegistryUtils.addName(BlockBasePartsField, meta, ItemBlockBaseParts.names[meta]);
		}
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileMechanicsTable.class, "tileMechTable");
	}

}
