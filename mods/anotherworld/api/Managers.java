package mods.anotherworld.api;

import mods.anotherworld.api.crafting.IManualCrusherManager;
import mods.anotherworld.api.crafting.IMechanicsTableManager;
import mods.anotherworld.api.crafting.IWorldCraftingManager;
import mods.anotherworld.api.tool.IToolActionManager;
import mods.anotherworld.api.tool.IToolModeManager;

public class Managers {
	
	/**
	 * Mechanics Table Crafting manager
	 */
	public static IMechanicsTableManager mechanicsTableCrafting;
	
	/**
	 * In-World Crafting manager
	 */
	public static IWorldCraftingManager worldCrafting;
	
	/**
	 * In-World Crafting manager
	 */
	public static IManualCrusherManager manualCrusher;
	
	/**
	 * Tinkering tool action manager
	 */
	public static IToolActionManager toolActionManager;
	
	/**
	 * Tinkering tool mode manager
	 */
	public static IToolModeManager toolModeManager;
	
}
