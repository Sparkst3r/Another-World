package anotherWorld.client;

import buildcraft.core.render.RenderingEntityBlocks;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.client.MinecraftForgeClient;
import anotherWorld.common.AnotherWorld;
import anotherWorld.common.CommonProxyAnotherWorld;
import anotherWorld.common.machines.Machines;
import anotherWorld.common.machines.TileEntityRenderSeparator;
import anotherWorld.common.machines.TileEntitySeparator;

public class ClientProxyAnotherWorld extends CommonProxyAnotherWorld{
	@Override
	public void registerRenders() {
		MinecraftForgeClient.preloadTexture(AnotherWorld.blockTex);
		MinecraftForgeClient.preloadTexture(AnotherWorld.itemTex);
		MinecraftForgeClient.preloadTexture(AnotherWorld.texDir + "advanced.png");
	}	
}