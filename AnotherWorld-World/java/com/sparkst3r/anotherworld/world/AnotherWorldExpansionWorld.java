package com.sparkst3r.anotherworld.world;

import com.sparkst3r.anotherworld.core.GlobalValues;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


/**
 * AnotherWorldExpansionWorld
 *
 * AnotherWorld world expansion
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 14 Mar 2014
 */
@Mod(
		modid = GlobalValues.MODIDWORLD, 
		name = GlobalValues.MODNAMEWORLD, 
		version = GlobalValues.MODVERSION,
		dependencies = GlobalValues.DEPENDCORE 
		)
public class AnotherWorldExpansionWorld {
	
	/** Mod instance */
	@Instance(GlobalValues.MODIDWORLD)
	public static AnotherWorldExpansionWorld instance;
	

	/** Sided proxy */
	@SidedProxy(
			clientSide="com.sparkst3r.anotherworld.world.ClientProxy",
			serverSide="com.sparkst3r.anotherworld.world.CommonProxy")
	public static CommonProxy proxy;
	
	
	/**
	 * Called from FML during the pre initialisation phase
	 * @param event Pre-Init event
	 */
    @EventHandler
    public void preInitialise(FMLPreInitializationEvent event) {
    	//EntityRegistry.registerModEntity(EntityBee.class, "Bee", 0, this, 40, 3, true);
		//EntityRegistry.addSpawn(EntityBee.class, 90, 1, 10, EnumCreatureType.monster, BiomeGenBase.desert);
		
		//EntityUtils.registerEntityEgg(EntityBee.class, 0x000000, 0xFFFFFF);
    	
		WorldValues.initialise();
		GameRegistry.registerWorldGenerator(new WorldGenerator(), 3);
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
