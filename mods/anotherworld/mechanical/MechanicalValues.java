package mods.anotherworld.mechanical;

import mods.anotherworld.api.Managers;
import mods.anotherworld.core.AnotherWorld;
import mods.anotherworld.mechanical.blocks.BlockBaseParts;
import mods.anotherworld.mechanical.blocks.BlockMechanicsTableParts;
import mods.anotherworld.mechanical.blocks.ItemBlockBaseParts;
import mods.anotherworld.mechanical.crafting.MechTableCraftingManager;
import mods.anotherworld.mechanical.crafting.WorldCraftingManager;
import mods.anotherworld.mechanical.items.ItemBaseParts;
import mods.anotherworld.mechanical.items.ItemTool;
import mods.anotherworld.mechanical.tileentity.TileMechanicsTable;
import mods.anotherworld.mechanical.tool.ToolActionDismantle;
import mods.anotherworld.mechanical.tool.ToolActionManager;
import mods.anotherworld.util.RegistryUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

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
		Managers.mechanicsTableCrafting = new MechTableCraftingManager();
		Managers.worldCrafting = new WorldCraftingManager();
		Managers.toolActionManager = new ToolActionManager();
		
		BlockBasePartsField = new BlockBaseParts(712);
		BlockMechTablePartsField = new BlockMechanicsTableParts(711);
		
		
		ItemToolField = new ItemTool(5001);
		ItemBasePartsField = new ItemBaseParts(5002);
		
		registerTileEntities();
		addInfoForMeta();
		ItemCrafting.initialise();
		BlockCrafting.initialise();
		
		Managers.toolActionManager.addAction(new ToolActionDismantle());
		
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
