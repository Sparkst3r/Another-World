package com.sparkst3r.anotherworld.mechanical;

import com.sparkst3r.anotherworld.api.Managers;
import com.sparkst3r.anotherworld.api.dummy.CraftingManagerDummy;
import com.sparkst3r.anotherworld.api.dummy.ToolManagerDummy;
import com.sparkst3r.anotherworld.mechanical.blockinfo.BlockInfoManager;
import com.sparkst3r.anotherworld.mechanical.blockinfo.StandardBlockInfoGrass;
import com.sparkst3r.anotherworld.mechanical.blockinfo.StandardBlockInfoStone;
import com.sparkst3r.anotherworld.mechanical.crafting.ManualCrusherManager;
import com.sparkst3r.anotherworld.mechanical.crafting.WorldCraftingManager;
import com.sparkst3r.anotherworld.mechanical.tool.ToolActionAWDismantle;
import com.sparkst3r.anotherworld.mechanical.tool.ToolActionAssemble;
import com.sparkst3r.anotherworld.mechanical.tool.ToolActionAssembleMechTable;
import com.sparkst3r.anotherworld.mechanical.tool.ToolActionDismantleMechTable;
import com.sparkst3r.anotherworld.mechanical.tool.ToolActionManager;
import com.sparkst3r.anotherworld.mechanical.tool.ToolActionShowInfoForBlock;
import com.sparkst3r.anotherworld.mechanical.tool.ToolModeActivate;
import com.sparkst3r.anotherworld.mechanical.tool.ToolModeDismantle;
import com.sparkst3r.anotherworld.mechanical.tool.ToolModeHelp;
import com.sparkst3r.anotherworld.mechanical.tool.ToolModeManager;
import com.sparkst3r.anotherworld.mechanical.tool.ToolModeRotate;
import com.sparkst3r.anotherworld.mechanical.tool.ToolModeSetting;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;


/**
 * APIInternal
 * 
 * Internal API functions
 * 
 * @author Sparkst3r
 *
 */
public class APIInternalMech {
	
	/**
	 * Maps mechanical expansion API functions
	 */
	public static void mapMech() {
		//TODO Fix crafting table
		//Managers.mechanicsTableCrafting = new MechTableCraftingManager();
		Managers.worldCrafting = new WorldCraftingManager();
		Managers.manualCrusher = new ManualCrusherManager();
		
		Managers.toolActionManager = new ToolActionManager();
		Managers.toolModeManager = new ToolModeManager();
		
		Managers.pageManager = new BlockInfoManager();
	}
	
	/**
	 * Add mechanical tool modes and actions
	 */
	public static void addToolModesAndActions() {
		Managers.toolModeManager.addMode(new ToolModeActivate());
		Managers.toolModeManager.addMode(new ToolModeDismantle());
		Managers.toolModeManager.addMode(new ToolModeRotate());
		Managers.toolModeManager.addMode(new ToolModeHelp());
		Managers.toolModeManager.addMode(new ToolModeSetting());
		Managers.toolActionManager.addAction(new ToolActionAWDismantle());
		//Managers.toolActionManager.addAction(new ToolActionCoFHDismantle());
		Managers.toolActionManager.addAction(new ToolActionDismantleMechTable());
		Managers.toolActionManager.addAction(new ToolActionAssemble());
		Managers.toolActionManager.addAction(new ToolActionAssembleMechTable());
		Managers.toolActionManager.addAction(new ToolActionShowInfoForBlock());
	}
	
	/**
	 * Add vanilla block info
	 */
	public static void addVanillaInfoBlockPages() {
		Managers.pageManager.addStandardBlockInfo(new StandardBlockInfoStone());
		Managers.pageManager.addStandardBlockInfo(new StandardBlockInfoGrass());
	}
	
	
}
