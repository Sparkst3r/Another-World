package mods.anotherworld.api;

import mods.anotherworld.api.dummy.CraftingManagerDummy;
import mods.anotherworld.api.dummy.ToolManagerDummy;
import mods.anotherworld.core.GlobalValues;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;

/**
 * APIAnotherWorld
 *
 * Base API reference class.
 *
 * @author Sparkst3r
 *
 */
public class APIAnotherWorld {

	/**
	 * You are required to call this method if you wish to use the API
	 * Will re-map specific API references to dummy classes to prevent NPEs 
	 * 
	 * @return an array of booleans representing which AnotherWorld modules are available
	 */
	public static boolean[] reMapIfNotLoaded() {
		boolean[] modules = new boolean[GlobalValues.MODULES.length];
		
		for (int module = 0; module < GlobalValues.MODULES.length; module++) {
			modules[module] = true;
		}
		
		if (!Loader.isModLoaded("anotherworld")) {
			modules[0] = false;
			FMLLog.warning(GlobalValues.MODNAMECORE + " is not loaded, API disabled");
		}
		if (!Loader.isModLoaded("anotherworld|world")) {
			modules[1] = false;
			FMLLog.warning(GlobalValues.MODNAMEWORLD + " is not loaded, API remapped to dummy classes");
		}
		if (!Loader.isModLoaded("anotherworld|mech")) {
			modules[2] = false;
			
			Managers.mechanicsTableCrafting = new CraftingManagerDummy();
			Managers.worldCrafting = new CraftingManagerDummy();
			Managers.manualCrusher = new CraftingManagerDummy();
			Managers.toolActionManager = new ToolManagerDummy();
			Managers.toolModeManager = new ToolManagerDummy();
			FMLLog.warning(GlobalValues.MODNAMEMECHANICAL + " is not loaded, API remapped to dummy classes");
		}
		if (!Loader.isModLoaded("anotherworld|mach")) {
			modules[3] = false;
			FMLLog.warning(GlobalValues.MODNAMEMACHINES + " is not loaded, API remapped to dummy classes");
		}
		
		return modules;
	}
}
