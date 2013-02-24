package anotherWorld.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.NetworkMod;

//Mod details 
@Mod(
		modid = "anotherWorld", 
		name = "Another World", 
		version = "0.0.1")
//Client side required. Server side not required
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false
)


public class AnotherWorld {

}
