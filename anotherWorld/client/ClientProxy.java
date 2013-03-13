package anotherWorld.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.client.MinecraftForgeClient;
import anotherWorld.common.AnotherWorld;
import anotherWorld.common.CommonProxy;
import anotherWorld.common.machines.Machines;
import anotherWorld.common.machines.tile.TileEntitySeparator;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
		MinecraftForgeClient.preloadTexture(AnotherWorld.blockTex);
		MinecraftForgeClient.preloadTexture(AnotherWorld.itemTex);
		MinecraftForgeClient.preloadTexture(AnotherWorld.texDir + "advanced.png");
	}	
}