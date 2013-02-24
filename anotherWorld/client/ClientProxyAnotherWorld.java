package anotherWorld.client;

import net.minecraftforge.client.MinecraftForgeClient;
import anotherWorld.common.CommonProxyAnotherWorld;

public class ClientProxyAnotherWorld extends CommonProxyAnotherWorld{
	@Override
	public void registerRenders() {
		MinecraftForgeClient.preloadTexture("/anotherWorld/gfx/blocks.png");
		MinecraftForgeClient.preloadTexture("/anotherWorld/gfx/items.png");
		MinecraftForgeClient.preloadTexture("/anotherWorld/gfx/advanced.png");
	}
}