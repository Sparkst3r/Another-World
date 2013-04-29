package mods.anotherworld.core;

import mods.anotherworld.api.Managers;
import mods.anotherworld.core.blockinfo.BlockInfoManager;
import mods.anotherworld.core.blockinfo.StandardBlockInfoGrass;
import mods.anotherworld.core.blockinfo.StandardBlockInfoStone;
import mods.anotherworld.mechanical.crafting.ManualCrusherManager;
import mods.anotherworld.mechanical.crafting.MechTableCraftingManager;
import mods.anotherworld.mechanical.crafting.WorldCraftingManager;
import mods.anotherworld.mechanical.tool.ToolActionAWDismantle;
import mods.anotherworld.mechanical.tool.ToolActionAssemble;
import mods.anotherworld.mechanical.tool.ToolActionAssembleMechTable;
import mods.anotherworld.mechanical.tool.ToolActionDismantleMechTable;
import mods.anotherworld.mechanical.tool.ToolActionManager;
import mods.anotherworld.mechanical.tool.ToolActionShowInfoForBlock;
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
		Managers.manualCrusher = new ManualCrusherManager();
		
		Managers.toolActionManager = new ToolActionManager();
		Managers.toolModeManager = new ToolModeManager();
		
		Managers.pageManager = new BlockInfoManager();
		
		return true;	
	}
	
	public static void addToolModesAndActions() {
		Managers.toolModeManager.addMode(new ToolModeActivate());
		Managers.toolModeManager.addMode(new ToolModeDismantle());
		Managers.toolModeManager.addMode(new ToolModeRotate());
		Managers.toolModeManager.addMode(new ToolModeHelp());
		Managers.toolModeManager.addMode(new ToolModeSetting());
		Managers.toolActionManager.addAction(new ToolActionAWDismantle());
		Managers.toolActionManager.addAction(new ToolActionDismantleMechTable());
		Managers.toolActionManager.addAction(new ToolActionAssemble());
		Managers.toolActionManager.addAction(new ToolActionAssembleMechTable());
		Managers.toolActionManager.addAction(new ToolActionShowInfoForBlock());
	}
	
	public static void addVanillaInfoBlockPages() {
		Managers.pageManager.addStandardBlockInfo(new StandardBlockInfoStone());
		Managers.pageManager.addStandardBlockInfo(new StandardBlockInfoGrass());
	}
	
	
}
