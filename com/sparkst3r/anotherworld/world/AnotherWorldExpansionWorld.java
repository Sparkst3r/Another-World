package com.sparkst3r.anotherworld.world;

import com.sparkst3r.anotherworld.core.GlobalValues;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
		modid = GlobalValues.MODIDWORLD, 
		name = GlobalValues.MODNAMEWORLD, 
		version = GlobalValues.MODVERSION,
		dependencies = GlobalValues.DEPENDCORE 
		)
public class AnotherWorldExpansionWorld {
	
	@Instance(GlobalValues.MODIDWORLD)
	public static AnotherWorldExpansionWorld instance = new AnotherWorldExpansionWorld();
	

	/** Sided proxy */
	@SidedProxy(
			clientSide="com.sparkst3r.anotherworld.world.ClientProxy",
			serverSide="com.sparkst3r.anotherworld.world.CommonProxy")
	public static CommonProxy proxy;
	
	
	//Called during the pre-load phase
    @EventHandler
    public void preInitialise(FMLPreInitializationEvent event) {
    	//EntityRegistry.registerModEntity(EntityBee.class, "Bee", 0, this, 40, 3, true);
		//EntityRegistry.addSpawn(EntityBee.class, 90, 1, 10, EnumCreatureType.monster, BiomeGenBase.desert);
		
		//EntityUtils.registerEntityEgg(EntityBee.class, 0x000000, 0xFFFFFF);
    	
		WorldValues.initialise();
		//GameRegistry.registerWorldGenerator(new WorldGenerator());
    }
    
	//Called during the loading phase
    @EventHandler 
	public void initialise(FMLInitializationEvent event) {
		WorldValues.initialise();
	}
	
	//Called during the post-load phase
    @EventHandler
	public void postInitialise(FMLPostInitializationEvent event) {
	}
	
	
	
	
	
}
