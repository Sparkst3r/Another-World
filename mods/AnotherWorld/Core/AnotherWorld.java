/**
 * Released under GNU Lesser Public License v3
 * http://www.gnu.org/licenses/lgpl.html
 * Mods relying on AnotherWorld's API are allowed to be released under proprietary licenses.
 * On condition a link must be provided to the source code of AnotherWorld eg. GitHub on your download page.
 * Credit is to also be given to the author of the code.
 */

package mods.AnotherWorld.Core;
import mods.AnotherWorld.Common.CommonPacketHandler;
import mods.AnotherWorld.Common.CommonProxy;
import mods.AnotherWorld.Mechanical.GuiHandlerMechanical;
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


/**
 * 
 * AnotherWorld Core.
 * Provides minimal/zero functionality. 
 * Is the base dependency of all modules
 * 
 * @author Sparkst3r
 * @version 0.1.0
 * 
 */

//Mod annotation. Defines the mod's Name, Id and Version
@Mod(
		modid = GlobalValues.ModIDCore, 
		name = GlobalValues.ModNameCore, 
		version = GlobalValues.ModVersion)


/** NetworkMod annotation. Defines client/server requirement and the packet handler */
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false,
		channels = "AnotherWorld",
		packetHandler = CommonPacketHandler.class
)
public class AnotherWorld {
	
	/** Mod instance*/
	@Instance(GlobalValues.ModIDCore)
	public static AnotherWorld instance;
	

	
	/** Sided proxy */
	@SidedProxy(
			clientSide="mods.AnotherWorld.Client.ClientProxy",
			serverSide="mods.AnotherWorld.Common.CommonProxy")
	public static CommonProxy proxy;
	
	
	//Called during the pre-load phase
    @PreInit
    public void PreLoad(FMLPreInitializationEvent event) {
    }
    
	//Called during the loading phase
	@Init 
	public void load(FMLInitializationEvent event) {
		//Any fields in that class that require instantiating won't be. This loads the class and instantiates everything. 
		GlobalValues.initialize();
		
	}
	
	//Called during the post-load phase
	@PostInit 
	public void PostLoad(FMLPostInitializationEvent event) {
	}
	
}
