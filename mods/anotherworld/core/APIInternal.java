package mods.anotherworld.core;

import mods.anotherworld.api.Managers;
import mods.anotherworld.mechanical.crafting.MechTableCraftingManager;
import mods.anotherworld.mechanical.crafting.WorldCraftingManager;
import mods.anotherworld.mechanical.tool.ToolActionAWDismantle;
import mods.anotherworld.mechanical.tool.ToolActionAssemble;
import mods.anotherworld.mechanical.tool.ToolActionAssembleMechTable;
import mods.anotherworld.mechanical.tool.ToolActionManager;
import mods.anotherworld.mechanical.tool.ToolModeActivate;
import mods.anotherworld.mechanical.tool.ToolModeDismantle;
import mods.anotherworld.mechanical.tool.ToolModeHelp;
import mods.anotherworld.mechanical.tool.ToolModeManager;
import mods.anotherworld.mechanical.tool.ToolModeRotate;
import mods.anotherworld.mechanical.tool.ToolModeSetting;

public class APIInternal {
	
	/**
	 * Maps mechanical expansion API functions
	 */
	public static boolean mapMech() {
		Managers.mechanicsTableCrafting = new MechTableCraftingManager();
		Managers.worldCrafting = new WorldCraftingManager();
		Managers.toolActionManager = new ToolActionManager();
		Managers.toolModeManager = new ToolModeManager();
		return true;	
	}
	
	public static void addToolModesAndActions() {
		Managers.toolModeManager.addMode(new ToolModeActivate());
		Managers.toolModeManager.addMode(new ToolModeDismantle());
		Managers.toolModeManager.addMode(new ToolModeRotate());
		Managers.toolModeManager.addMode(new ToolModeHelp());
		Managers.toolModeManager.addMode(new ToolModeSetting());
		Managers.toolActionManager.addAction(new ToolActionAWDismantle());
		Managers.toolActionManager.addAction(new ToolActionAssemble());
		Managers.toolActionManager.addAction(new ToolActionAssembleMechTable());
	}
	
}
