package anotherWorld;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import anotherWorld.api.core.BasicItemRegistry;
import anotherWorld.client.ClientProxy;
import anotherWorld.client.GuiHandler;
import anotherWorld.common.CommonPacketHandler;
import anotherWorld.common.Config;
import anotherWorld.common.CreativeTabAnotherWorld;
import anotherWorld.common.ModsExist;
import anotherWorld.common.onLoad;
import anotherWorld.common.machines.tile.TileEntitySeparator;
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
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.registry.GameRegistry;

//Mod details 
@Mod(
		modid = AnotherWorld.modID, 
		name = AnotherWorld.modName, 
		version = AnotherWorld.modVersion)

//Client side required. Server side not required.
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false,
		clientPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialMod" }, packetHandler = anotherWorld.client.ClientPacketHandler.class),
		serverPacketHandlerSpec = @SidedPacketHandler(channels = {"TutorialMod" }, packetHandler = CommonPacketHandler.class)
)

public class AnotherWorld {
	@Instance
	public static AnotherWorld instance = new AnotherWorld();
	//Create clientProxy as a new ClientProxyAnotherWorld instance
	
	
	

	public static final String modID = "anotherWorld";
	public static final String modName = "Another World";
	public static final String modVersion = "0.0.3";

	public static final String mainDir = "/anotherWorld/";
	public static final String texDir = mainDir + "gfx/";
	public static final String blockTex = texDir + "blocks.png";
	public static final String itemTex = texDir + "items.png";
	public static final String guiDir = texDir + "gui/";
	public static Configuration configAW;
	
	private GuiHandler guiHandler = new GuiHandler();
	
	public static ClientProxy clientProxy;

	
	//Create TabAN as a new CreativeTabAnotherWorld instance
	public static CreativeTabs TabAW = new CreativeTabAnotherWorld(CreativeTabs.getNextID(), "Another World");
	
    @PreInit
    public void PreLoad(FMLPreInitializationEvent event){    	
    	ModsExist.check();
		configAW = new Configuration(event.getSuggestedConfigurationFile());
    	Config.doReadWrite(event);
    }
	@Init 
	public void load(FMLInitializationEvent event) {
		NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
        
		onLoad.onLoading();

	}
	@PostInit 
	public void PostLoad(FMLPostInitializationEvent event) {
		onLoad.onPostLoad();
	}
	
}
