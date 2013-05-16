package mods.anotherworld.machines;

import mods.anotherworld.common.CommonProxy;
import mods.anotherworld.core.GlobalValues;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(
		modid = GlobalValues.MODIDMACHINES, 
		name = GlobalValues.MODNAMEMACHINES, 
		version = GlobalValues.MODVERSION,
		dependencies = GlobalValues.DEPENDMECHANICAL
		)


//NetworkMod annotation. Defines client/server requirement and the packet handler
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false)


public class AnotherWorldExpansionMachines {
	
	/** Sided proxy */
	@SidedProxy(
			clientSide="mods.anotherworld.client.ClientProxy",
			serverSide="mods.anotherworld.common.CommonProxy")
	public static CommonProxy proxy;
	
	
	//Called during the pre-load phase
    @PreInit
    public void PreLoad(FMLPreInitializationEvent event) {
    	MachineValues.initialise();
    }
    
	//Called during the loading phase
	@Init 
	public void load(FMLInitializationEvent event) {
	}
	
	//Called during the post-load phase
	@PostInit 
	public void PostLoad(FMLPostInitializationEvent event) {
	}
	
}