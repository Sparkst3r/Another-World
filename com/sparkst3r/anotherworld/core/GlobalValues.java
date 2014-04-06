package com.sparkst3r.anotherworld.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

import com.sparkst3r.anotherworld.mechanical.GuiHandlerMechanical;
import com.sparkst3r.anotherworld.network.PacketPipeline;
import com.sparkst3r.anotherworld.util.basic.MaterialImmovable;

/**
 * GlobalValues
 *
 * Global mod constants
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 4 Mar 2014
 */
public class GlobalValues {
	
	/** AnotherWorld version */
	public static final String MODVERSION = "ALPHA";

	/** AnotherWorld-Core identifier */
	public static final String MODIDCORE = "anotherworld";
	
	/** AnotherWorld-Core name */
	public static final String MODNAMECORE = "AnotherWorld";
	
	/** AnotherWorld-World identifier */
	public static final String MODIDWORLD = "anotherworld|World";
	
	/** AnotherWorld-World name */
	public static final String MODNAMEWORLD = "AnotherWorld World Expansion";
	
	/** AnotherWorld-Mechanical identifier */
	public static final String MODIDMECHANICAL = "anotherworld|Mech";
	
	/** AnotherWorld-Mechanical name */
	public static final String MODNAMEMECHANICAL = "AnotherWorld Mechanical Expansion";
	
	/** AnotherWorld-Machines identifier */
	public static final String MODIDMACHINES = "anotherworld|Mach";
	
	/** AnotherWorld-Machines name */
	public static final String MODNAMEMACHINES = "AnotherWorld Machines Expansion";
	
	
	
	/** Depends on AnotherWorld-Core */
	public static final String DEPENDCORE = "required-after:" + GlobalValues.MODIDCORE + ";";
	
	/** Depends on AnotherWorld-World */
	public static final String DEPENDWORLD = "required-after:" + GlobalValues.MODIDWORLD + ";";
	
	/** Depends on AnotherWorld-World */
	public static final String DEPENDMECHANICAL = "required-after:" + GlobalValues.MODIDMECHANICAL + ";";
	
	/** Global logger */
	public static final Logger LOGGER = LogManager.getLogger("AnotherWorld");
	
	/** Texture location */
	public static final String TEXTURE = MODIDCORE + ":";
	
	/** AnotherWorld Packet handler */
	public static final PacketPipeline packetPipeline = new PacketPipeline();
	
	/** Material set to immovable */
	public static final Material IMMOVABLE = new MaterialImmovable(MapColor.woodColor);
	
	/**
	 * Pre initialise
	 */
	public static void preinitialise() {
		
	}
	
	/**
	 *  Initialise 
	 */
	public static void initialise() {
		GlobalValues.packetPipeline.initalise();
	}
	
	/**
	 * Post initialise
	 */
	public static void postInitialise() {
		GlobalValues.packetPipeline.postInitialise();
	}
	
	
	
}
