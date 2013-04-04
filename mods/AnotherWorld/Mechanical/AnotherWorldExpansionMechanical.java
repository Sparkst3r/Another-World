package mods.AnotherWorld.Mechanical;

import mods.AnotherWorld.Client.ClientPacketHandler;
import mods.AnotherWorld.Common.CommonPacketHandler;
import mods.AnotherWorld.Common.CommonProxy;
import mods.AnotherWorld.Core.GlobalValues;
import mods.AnotherWorld.Core.Load;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
		modid = GlobalValues.ModIDMechanical, 
		name = GlobalValues.ModNameMechanical, 
		version = GlobalValues.ModVersion,
		dependencies = GlobalValues.World
		)


//NetworkMod annotation. Defines client/server requirement and the packet handler
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false
)

public class AnotherWorldExpansionMechanical {

	//SidedProxy annotation to specify the Client and Common proxies
	@SidedProxy(
			clientSide="mods.AnotherWorld.Client.ClientProxy",
			serverSide="mods.AnotherWorld.Common.CommonProxy")
	public static CommonProxy proxy;
	
	
	//Called during the pre-load phase
    @PreInit
    public void PreLoad(FMLPreInitializationEvent event) {
    	MechanicalValues.initialise();
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