package mods.anotherWorld;

import mods.anotherWorld.api.core.BasicItemRegistry;
import mods.anotherWorld.client.ClientPacketHandler;
import mods.anotherWorld.client.ClientProxy;
import mods.anotherWorld.client.GuiHandler;
import mods.anotherWorld.common.CommonPacketHandler;
import mods.anotherWorld.common.CommonProxy;
import mods.anotherWorld.common.Config;
import mods.anotherWorld.common.CreativeTabAnotherWorld;
import mods.anotherWorld.common.ModsExist;
import mods.anotherWorld.common.onLoad;
import mods.anotherWorld.common.machines.tile.TileEntitySeparator;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
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
		clientPacketHandlerSpec = @SidedPacketHandler(channels = {"AnotherWorld" }, packetHandler = ClientPacketHandler.class),
		serverPacketHandlerSpec = @SidedPacketHandler(channels = {"AnotherWorld" }, packetHandler = CommonPacketHandler.class)
)

public class AnotherWorld {
	@Instance
	public static AnotherWorld instance = new AnotherWorld();
	//Create clientProxy as a new ClientProxyAnotherWorld instance
	
	
	

	public static final String modID = "anotherWorld";
	public static final String modName = "Another World";
	public static final String modVersion = "0.0.3";

	public static final String mainDir = "mods/anotherWorld/";
	public static final String texDir = mainDir + "textures/";
	public static final String guiDir = texDir + "gui/";
	public static Configuration configAW;
	
	private GuiHandler guiHandler = new GuiHandler();
	
	public static CommonProxy proxy;
	
	
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
