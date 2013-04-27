package mods.anotherworld.api;

import mods.anotherworld.api.dummy.CraftingManagerDummy;
import mods.anotherworld.api.dummy.ToolManagerDummy;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;

public class APIAnotherWorld {
	
	public static boolean reMapIfNotLoaded() {
		if (!Loader.isModLoaded("anotherworld")) {
		}
		if (!Loader.isModLoaded("anotherworld|world")) {
		}
		if (!Loader.isModLoaded("anotherworld|mech")) {
			Managers.mechanicsTableCrafting = new CraftingManagerDummy();
			Managers.worldCrafting = new CraftingManagerDummy();
			Managers.manualCrusher = new CraftingManagerDummy();
			
			Managers.toolActionManager = new ToolManagerDummy();
			Managers.toolModeManager = new ToolManagerDummy();
			
			FMLLog.warning("AnotherWorld|Mech is not loaded, API remapped to dummy classes");
		}
		if (!Loader.isModLoaded("anotherworld|mach")) {
			
		}
		
		return false;
	}
	

	
	
}
