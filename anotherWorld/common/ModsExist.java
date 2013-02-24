package anotherWorld.common;

import cpw.mods.fml.common.FMLLog;

public class ModsExist {
	public static boolean ic2Exists = true;
	public static boolean tc3Exists = true;
	
	
	
	public static void check() {
		try {
			Class.forName("ic2.core.IC2");
			}
		catch (ClassNotFoundException e){
			ic2Exists = false;
		}
		try {
			Class.forName("thaumcraft.common.Thaumcraft");
			}
		catch (ClassNotFoundException e){
			tc3Exists = false;
		}
		
		if (ic2Exists) {
			FMLLog.warning("IC2 Found, Adding IC2 features");
		}
		else {
			FMLLog.warning("IC2 Not found, Not adding IC2 features");
		}
		if (tc3Exists) {
			FMLLog.warning("TC3 Found, Adding TC3 features");
		}
		else {
			FMLLog.warning("TC3 Not found, Not adding TC3 features");
		}
	
	
	
	}


}

