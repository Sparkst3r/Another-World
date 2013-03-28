package mods.AnotherWorld.Core;

import mods.AnotherWorld.Client.AnotherWorldTab;
import net.minecraft.creativetab.CreativeTabs;

public class GlobalValues {
	//Mod Info
	public static final String ModIDCore = "AnotherWorld";
	public static final String ModNameCore = "AnotherWorld";
	public static final String ModIDWorld = "AnotherWorld|World";
	public static final String ModNameWorld = "AnotherWorld World Expansion";
	public static final String ModIDMechanical = "AnotherWorld|Mech";
	public static final String ModNameMechanical = "AnotherWorld Mechanical Expansion";
	public static final String ModVersion = "0.1.0";
	
	//Dependency variables
	public static final String Core = "required-after:" + ModIDCore + "@" + ModVersion;
	public static final String World = "required-after:" + ModIDWorld + "@" +  ModVersion;
	
	
	//Texture path
	public static final String mainDir = "mods/anotherWorld/textures/";
	public static final String guiDir = mainDir + "guis/";
	public static final String entityDir = mainDir + "entities/";
	public static final String blockDir = mainDir + "blocks/";
	public static final String itemDir = mainDir + "items/";
	
	//Creative Tab
	public static CreativeTabs AnotherTab = new AnotherWorldTab(CreativeTabs.getNextID(), "AnotherWorld");

	public static boolean initialize() {
		return true;
	}
	
}
