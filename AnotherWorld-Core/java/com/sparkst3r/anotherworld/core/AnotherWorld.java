/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt for full details
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.core;

import com.google.common.collect.ImmutableList;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCMessage;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * AnotherWorld
 *
 * Base dependency for all modules
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 4 Mar 2014
 */
@Mod(
		modid = GlobalValues.MODIDCORE, 
		name = GlobalValues.MODNAMECORE, 
		version = GlobalValues.MODVERSION
		)
public class AnotherWorld {
	
	/** Mod instance */
	@Instance(GlobalValues.MODIDCORE)
	public static AnotherWorld instance;
	

	
	/** Sided proxy */
	@SidedProxy(
			clientSide="com.sparkst3r.anotherworld.core.ClientProxy",
			serverSide="com.sparkst3r.anotherworld.core.CommonProxy")
	public static CommonProxy proxy;
	
	
	/**
	 * Called from FML during the pre initialisation phase
	 * @param event Pre-Init event
	 */
    @EventHandler
    public void preInitialise(FMLPreInitializationEvent event) {
    	GlobalValues.preinitialise();
    }
    
	/**
	 * Called from FML during the initialisation phase
	 * @param event Init event
	 */
    @EventHandler 
	public void initialise(FMLInitializationEvent event) {
		GlobalValues.initialise();
	}
	
	/**
	 * Called from FML during the post initialisation phase
	 * @param event Post-Init event
	 */
    @EventHandler
	public void postInitialise(FMLPostInitializationEvent event) {
		GlobalValues.postInitialise();
	}
	
}
