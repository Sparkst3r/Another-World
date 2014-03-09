package com.sparkst3r.anotherworld.mechanical;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import com.sparkst3r.anotherworld.core.AnotherWorld;
import com.sparkst3r.anotherworld.mechanical.blocks.BlockBaseParts;
import com.sparkst3r.anotherworld.mechanical.blocks.BlockLogicSimple;
import com.sparkst3r.anotherworld.mechanical.blocks.BlockManualCrusher;
import com.sparkst3r.anotherworld.mechanical.blocks.BlockMechanicsTableParts;
import com.sparkst3r.anotherworld.mechanical.event.RenderHelpOverlay;
import com.sparkst3r.anotherworld.mechanical.items.ItemMechBaseParts;
import com.sparkst3r.anotherworld.mechanical.items.ItemTinkeringTool;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileLogicSimple;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileManualCrusher;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileMechanicsTable;

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
	public static Block BlockLogicSimpleField;
	
	public static Item ItemToolField;
	public static Item ItemBasePartsField;
	
	public static void initialise() {
		
		APIInternalMech.mapMech();
		APIInternalMech.addToolModesAndActions();
		APIInternalMech.addVanillaInfoBlockPages();
		//TickRegistry.registerTickHandler(new RenderTick(), Side.CLIENT);
		MinecraftForge.EVENT_BUS.register(new RenderHelpOverlay());
		
		BlockBasePartsField = new BlockBaseParts();
		BlockMechTablePartsField = new BlockMechanicsTableParts();
		BlockManualCrusherField = new BlockManualCrusher();
		BlockLogicSimpleField = new BlockLogicSimple();
		
		ItemToolField = new ItemTinkeringTool();
		ItemBasePartsField = new ItemMechBaseParts();
		
		
		registerTileEntities();
		
		//ItemCrafting.addRecipes();
		//BlockCrafting.initialise();
		
		addInfoForMeta();
		//SpecialCrafting.initialise();
		AnotherWorldExpansionMechanical.proxy.registerRendersForMechanical();
		
	}
	
	/**
	 * Adds extra information for meta data items. Eg. Names
	 */
	public static void addInfoForMeta() {
		//for (int meta = 0; meta < ToolModeManager.getModes().size(); meta++) {
		//	RegistryUtils.addName(ItemToolField, meta, "Tinkering Tool");
		//}
		
		//for (int meta = 0; meta < ItemBaseParts.types.length; meta++) {
		//	RegistryUtils.addName(ItemBasePartsField, meta, ItemBaseParts.names[meta]);
		//}
		
		//for (int meta = 0; meta < ItemBlockBaseParts.types.length; meta++) {
		//	RegistryUtils.addName(BlockBasePartsField, meta, ItemBlockBaseParts.names[meta]);
		//}
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileMechanicsTable.class, "tileMechTable");
		GameRegistry.registerTileEntity(TileManualCrusher.class, "tileMechGrinder");
		GameRegistry.registerTileEntity(TileLogicSimple.class, "tileLogicSimple");
	}
}
