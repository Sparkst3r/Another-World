package anotherWorld.common;

import net.minecraft.creativetab.CreativeTabs;
import anotherWorld.client.ClientProxyAnotherWorld;
import anotherWorld.common.basicItems.BasicItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

//Mod details 
@Mod(
		modid = "anotherWorld", 
		name = "Another World", 
		version = "0.0.2")

//Client side required. Server side not required.
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false
)


public class AnotherWorld {
	//Create clientProxy as a new ClientProxyAnotherWorld instance
	public static ClientProxyAnotherWorld clientProxy = new ClientProxyAnotherWorld();
	
	//Create TabAN as a new CreativeTabAnotherWorld instance
	public static CreativeTabs TabAW = new CreativeTabAnotherWorld(CreativeTabs.getNextID(), "Another World");
	
    @PreInit
    public void PreLoad(FMLPreInitializationEvent event){    	
    	ModsExist.check();
    }
	@Init 
	public void load(FMLInitializationEvent event) {
		BasicItems.addItems();
	}
	@PostInit 
	public void PostLoad(FMLPostInitializationEvent event) {
	}
	
}
