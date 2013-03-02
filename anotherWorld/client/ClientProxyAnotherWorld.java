package anotherWorld.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import anotherWorld.common.AnotherWorld;
import anotherWorld.common.CommonProxyAnotherWorld;

public class ClientProxyAnotherWorld extends CommonProxyAnotherWorld{
	@Override
	public void registerRenders() {
		MinecraftForgeClient.preloadTexture(AnotherWorld.blockTex);
		MinecraftForgeClient.preloadTexture(AnotherWorld.itemTex);
		MinecraftForgeClient.preloadTexture(AnotherWorld.texDir + "advanced.png");
	
	}
}