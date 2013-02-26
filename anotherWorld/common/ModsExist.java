package anotherWorld.common;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;

public class ModsExist {
	public static boolean ic2Exists = true;
	public static boolean tc3Exists = true;
	public static boolean teExists = false;
	
	
	public static void check() {
		
		if (Loader.isModLoaded("IC2")) {
			ic2Exists = true;
			FMLLog.warning("IC2 Found, Adding IC2 features");
		} 
		else {
			FMLLog.warning("IC2 Not found, Not adding IC2 features");
		}
		
		
		if (Loader.isModLoaded("ThermalExpansion")) {
			teExists = true;
			FMLLog.warning("TE Found, Adding TE features");
		} 
		else {
			FMLLog.warning("TE Not found, Not adding TE features");
		}
		
		if (Loader.isModLoaded("Thaumcraft")) {
			teExists = true;
			FMLLog.warning("TC3 Found, Adding TC3 features");
		} 
		else {
			FMLLog.warning("TC3 Not found, Not adding TC3 features");
		}
		
	}


}

