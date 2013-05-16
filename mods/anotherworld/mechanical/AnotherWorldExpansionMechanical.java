package mods.anotherworld.mechanical;


import mods.anotherworld.common.CommonPacketHandler;
import mods.anotherworld.common.CommonProxy;
import mods.anotherworld.core.GlobalValues;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(
		modid = GlobalValues.MODIDMECHANICAL, 
		name = GlobalValues.MODNAMEMECHANICAL, 
		version = GlobalValues.MODVERSION,
		dependencies = GlobalValues.DEPENDWORLD
		)


/** NetworkMod annotation. Defines client/server requirement and the packet handler */
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false,
		channels = "AnotherWorld",
		packetHandler = CommonPacketHandler.class
)

public class AnotherWorldExpansionMechanical {
	@Instance(GlobalValues.MODIDMECHANICAL)
	public static AnotherWorldExpansionMechanical instance;

	/** Sided proxy */
	@SidedProxy(
			clientSide="mods.anotherworld.client.ClientProxy",
			serverSide="mods.anotherworld.common.CommonProxy")
	public static CommonProxy proxy;
	
	
	/** Called during the pre-load phase */
    @PreInit
    public void PreLoad(FMLPreInitializationEvent event) {
    	MechanicalValues.initialise();
    	NetworkRegistry.instance().registerGuiHandler(GlobalValues.MECHANICALINSTANCE, GlobalValues.MECHGUI);
    }
    
	/** Called during the loading phase */
	@Init 
	public void load(FMLInitializationEvent event) {
		
	}
	
	/** Called during the post-load phase */
	@PostInit 
	public void PostLoad(FMLPostInitializationEvent event) {
	}
	
}