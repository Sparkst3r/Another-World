/**
 * Released under GNU Lesser General Public License.
 * Mods relying on AnotherWorld's API are allowed to be released under proprietary licenses.
 * On condition a link must be provided to the source code of AnotherWorld eg. GitHub on your download page.
 * Credit is to also be given to the author of the code.
 */

package mods.AnotherWorld.Core;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;


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


//NetworkMod annotation. Defines client/server requirement and the packet handler
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false
		)


public class AnotherWorld {
	
	//Called during the pre-load phase
    @PreInit
    public void PreLoad(FMLPreInitializationEvent event) {
    	Load.onPreLoad(event);
    }
    
	//Called during the loading phase
	@Init 
	public void load(FMLInitializationEvent event) {
		Load.onLoad(event);
	}
	
	//Called during the post-load phase
	@PostInit 
	public void PostLoad(FMLPostInitializationEvent event) {
	    Load.onPostLoad(event);
	}
	
}
