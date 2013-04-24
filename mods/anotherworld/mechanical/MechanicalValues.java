package mods.anotherworld.mechanical;

import mods.anotherworld.core.APIInternal;
import mods.anotherworld.core.AnotherWorld;
import mods.anotherworld.mechanical.blocks.BlockBaseParts;
import mods.anotherworld.mechanical.blocks.BlockManualCrusher;
import mods.anotherworld.mechanical.blocks.BlockMechanicsTableParts;
import mods.anotherworld.mechanical.blocks.ItemBlockBaseParts;
import mods.anotherworld.mechanical.items.ItemBaseParts;
import mods.anotherworld.mechanical.items.ItemTool;
import mods.anotherworld.mechanical.tileentity.TileManualCrusher;
import mods.anotherworld.mechanical.tileentity.TileMechanicsTable;
import mods.anotherworld.mechanical.tool.ToolModeManager;
import mods.anotherworld.util.RegistryUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Values associated with the mechanical expansion
 * 
 * @author Sparkst3r
 * 
 */
public class MechanicalValues {
	
	// Blocks
	public static Block BlockMechTablePartsField;
	public static Block BlockBasePartsField;
	public static Block BlockManualCrusherField;
	
	
	public static Item ItemToolField;
	public static Item ItemBasePartsField;
	
	public static void initialise() {
		APIInternal.mapMech();
		APIInternal.addToolModesAndActions();
		
		BlockBasePartsField = new BlockBaseParts(712);
		BlockMechTablePartsField = new BlockMechanicsTableParts(711);
		BlockManualCrusherField = new BlockManualCrusher(713);
		
		
		ItemToolField = new ItemTool(5001);
		ItemBasePartsField = new ItemBaseParts(5002);
		
		
		registerTileEntities();
		
		ItemCrafting.initialise();
		BlockCrafting.initialise();
		
		addInfoForMeta();
		SpecialCrafting.initialise();
		AnotherWorld.proxy.registerRendersForMechanical();
		
	}
	
	/**
	 * Adds extra information for meta data items. Eg. Names
	 */
	public static void addInfoForMeta() {
		for (int meta = 0; meta < ToolModeManager.getModes().size(); meta++) {
			RegistryUtils.addName(ItemToolField, meta, "Tinkering Tool");
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
		GameRegistry.registerTileEntity(TileManualCrusher.class, "tileMechGrinder");
	}
}
