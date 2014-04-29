package com.sparkst3r.anotherworld.mechanical;

import net.minecraftforge.common.MinecraftForge;

import com.sparkst3r.anotherworld.mechanical.blocks.BlockMechBaseParts;
import com.sparkst3r.anotherworld.mechanical.blocks.BlockDisappearDoor;
import com.sparkst3r.anotherworld.mechanical.blocks.BlockManualCrusher;
import com.sparkst3r.anotherworld.mechanical.blocks.BlockMechanicsTable;
import com.sparkst3r.anotherworld.mechanical.event.RenderHelpOverlay;
import com.sparkst3r.anotherworld.mechanical.items.ItemMechBaseParts;
import com.sparkst3r.anotherworld.mechanical.items.ItemMilkshake;
import com.sparkst3r.anotherworld.mechanical.items.ItemTinkeringTool;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileDisappearDoor;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileLogicSimple;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileManualCrusher;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileMechanicsTable;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * MechanicalValues
 *
 * Mechanical Expansion values
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 14 Mar 2014
 */
public class MechanicalValues {
	
	/** Mechanical base block parts */
	public static final BlockMechBaseParts blockBaseParts = new BlockMechBaseParts();
	/** Mechanics table block */
	public static final BlockMechanicsTable blockMechTable = new BlockMechanicsTable();
	
	/** Mechanical crusher block */
	public static final BlockManualCrusher blockManualCrusher = new BlockManualCrusher();
	
	/** Disappearing door block */
	public static final BlockDisappearDoor blockDisappearDoor = new BlockDisappearDoor();
	
	//public static Block blockLogicSimpleField;
	
	/** Mechanical base item parts */
	public static final ItemMechBaseParts itemMechBaseParts = new ItemMechBaseParts();
	
	/** Tinkering tool item */
	public static final ItemTinkeringTool itemTinkeringTool = new ItemTinkeringTool();
	
	/** Milkshake item */
	public static final ItemMilkshake itemMilkshake = new ItemMilkshake();
	
	
	public static final GuiHandlerMechanical MECHGUI = new GuiHandlerMechanical();
	
	/**
	 * Initialise the features of the mechanics expansion
	 */
	public static void initialise() {
		APIInternalMech.mapMech();
		APIInternalMech.addToolModesAndActions();
		APIInternalMech.addVanillaInfoBlockPages();
		MinecraftForge.EVENT_BUS.register(new RenderHelpOverlay());

		//BlockLogicSimpleField = new BlockLogicSimple();

		
		registerTileEntities();
		
		//ItemCrafting.addRecipes();
		//BlockCrafting.initialise();
		MechCrafting.addItemRecipes();
		MechCrafting.addBlockRecipes();
		MechCrafting.addAPIRecipes();
		
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
	
	/**
	 * Register TileEntities for mechanical blocks
	 */
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileMechanicsTable.class, "tileMechTable");
		GameRegistry.registerTileEntity(TileManualCrusher.class, "tileMechGrinder");
		GameRegistry.registerTileEntity(TileLogicSimple.class, "tileLogicSimple");
		GameRegistry.registerTileEntity(TileDisappearDoor.class, "tileDisappearDoor");
	}
}
