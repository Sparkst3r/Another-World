package mods.anotherworld.core;

import mods.anotherworld.mechanical.AnotherWorldExpansionMechanical;
import mods.anotherworld.mechanical.GuiHandlerMechanical;
import mods.anotherworld.util.basic.MaterialImmovable;
import mods.anotherworld.world.AnotherWorldExpansionWorld;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * GlobalValues
 *
 * A collection of heavily used constants in one place for ease.
 *
 * @author Sparkst3r
 *
 */
public class GlobalValues {
	//Mod Info

	public static final String MODIDCORE = "anotherworld";
	public static final String MODNAMECORE = "AnotherWorld";
	public static final String MODIDWORLD = "anotherworld|World";
	public static final String MODNAMEWORLD = "AnotherWorld World Expansion";
	public static final String MODIDMECHANICAL = "anotherworld|Mech";
	public static final String MODNAMEMECHANICAL = "AnotherWorld Mechanical Expansion";
	public static final String MODIDMACHINES = "anotherworld|Mach";
	public static final String MODNAMEMACHINES = "AnotherWorld Machines Expansion";
	public static final String MODVERSION = "ALPHA";
	public static final String[] MODULES = new String[] {MODIDCORE, MODIDWORLD, MODIDMECHANICAL, MODIDMACHINES};
	public static final AnotherWorld COREINSTANCE = AnotherWorld.instance;
	public static final AnotherWorldExpansionWorld WORLDINSTANCE = AnotherWorldExpansionWorld.instance;
	public static final AnotherWorldExpansionMechanical MECHANICALINSTANCE = AnotherWorldExpansionMechanical.instance;
	
	//Dependency variables
	public static final String DEPENDCORE = "required-after:" + MODIDCORE + "@" + MODVERSION;
	public static final String DEPENDWORLD = "required-after:" + MODIDWORLD + "@" +  MODVERSION;
	public static final String DEPENDMECHANICAL = "required-after:" + MODIDMECHANICAL + "@" +  MODVERSION;
	
	//Texture path
	public static final String TEXTURE = MODIDCORE + ":";
	public static final String DIR = "/mods/anotherworld/textures/";
	public static final String GUIDIR = DIR + "guis/";
	public static final String ENTITYDIR = DIR + "entities/";
	public static final String BLOCKDIR = DIR + "blocks/";
	public static final String ITEMDIR = DIR + "items/";
	

	/** Material set to immovable */
	public static final Material IMMOVABLE = new MaterialImmovable(MapColor.woodColor);
	
	/** GuiHandlers */
	public static GuiHandlerMechanical MECHGUI = new GuiHandlerMechanical();
	
	public static boolean initialize() {
		return true;
	}
}
