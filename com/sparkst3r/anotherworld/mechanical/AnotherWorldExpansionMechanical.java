package com.sparkst3r.anotherworld.mechanical;


import com.sparkst3r.anotherworld.mechanical.CommonProxy;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileLogicSimple;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileManualCrusher;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileMechanicsTable;
import com.sparkst3r.anotherworld.core.GlobalValues;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * AnotherWorld
 *
 * AnotherWorld Mechanical Expansion
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 4 Mar 2014
 */
@Mod(
		modid = GlobalValues.MODIDMECHANICAL, 
		name = GlobalValues.MODNAMEMECHANICAL, 
		version = GlobalValues.MODVERSION,
		dependencies = GlobalValues.DEPENDWORLD
		)
public class AnotherWorldExpansionMechanical {
	
	/** Mod instance */
	@Instance(GlobalValues.MODIDMECHANICAL)
	public static AnotherWorldExpansionMechanical instance;

	/** Sided proxy */
	@SidedProxy(
			clientSide="com.sparkst3r.anotherworld.mechanical.ClientProxy",
			serverSide="com.sparkst3r.anotherworld.mechanical.CommonProxy")
	public static CommonProxy proxy;
	
	/**
	 * Called from FML during the pre initialisation phase
	 * @param event Pre-Init event
	 */
    @EventHandler
    public void preInitialise(FMLPreInitializationEvent event) {
    	MechanicalValues.initialise();
    	NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, MechanicalValues.MECHGUI);
		
    }
    
	/**
	 * Called from FML during the initialisation phase
	 * @param event Init event
	 */
    @EventHandler 
	public void initialise(FMLInitializationEvent event) {
    	
	}
	
	/**
	 * Called from FML during the post initialisation phase
	 * @param event Post-Init event
	 */
    @EventHandler
	public void postInitialise(FMLPostInitializationEvent event) {
	}
	
}