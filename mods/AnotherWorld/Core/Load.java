package mods.AnotherWorld.Core;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * All features to be handled in the 3 load stages (Pre-Init, Init, Post-Init)
 * 
 * @author Sparkst3r
 *
 */
public class Load {
	public static void onPreLoad(FMLPreInitializationEvent event) {
		//Any fields in that class that require instantiating won't be. This loads the class and instantiates everything. 
		GlobalValues.initialize();
		
	}
	public static void onLoad(FMLInitializationEvent event) {

		
	}
	public static void onPostLoad(FMLPostInitializationEvent event) {
		
	}
	
}
