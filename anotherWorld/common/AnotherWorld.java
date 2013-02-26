package anotherWorld.common;

import net.minecraft.creativetab.CreativeTabs;
import anotherWorld.client.ClientProxyAnotherWorld;
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
		modid = AnotherWorld.modID, 
		name = AnotherWorld.modName, 
		version = AnotherWorld.modVersion)

//Client side required. Server side not required.
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false
)


public class AnotherWorld {
	public static final String modID = "anotherWorld";
	public static final String modName = "Another World";
	public static final String modVersion = "0.0.3";

	public static final String mainDir = "/anotherWorld/";
	public static final String texDir = mainDir + "gfx/";
	public static final String blockTex = texDir + "blocks.png";
	public static final String itemTex = texDir + "items.png";
	public static final String guiDir = texDir + "gui/";

	
	
	
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
		onLoad.onLoading();

	}
	@PostInit 
	public void PostLoad(FMLPostInitializationEvent event) {
		onLoad.onPostLoad();
	}
	
}
