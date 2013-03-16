package anotherWorld.common;

import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.item.ItemStack;

public class CommonProxy {
	@SidedProxy(clientSide = "anotherWorld.client.ClientProxy", serverSide = "anotherWorld.common.CommonProxy")
	public static CommonProxy proxy;
	//Register Renders, does nothing as the server doesn't render anything.
	public void registerRenders() {
		
	}
	
	public void registerTickHandler() {
		TickRegistry.registerTickHandler(new CommonTickHandler(), Side.SERVER);
	}
}