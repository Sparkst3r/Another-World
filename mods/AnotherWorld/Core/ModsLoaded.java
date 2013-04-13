package mods.AnotherWorld.Core;

import cpw.mods.fml.common.Loader;

public class ModsLoaded {
	
	public static boolean checkIC2() {
		if (Loader.isModLoaded("IC2")) {
			return true;
		}
		return false;
	}
}
