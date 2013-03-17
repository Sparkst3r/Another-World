package anotherWorld.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraftforge.client.MinecraftForgeClient;
import anotherWorld.AnotherWorld;
import anotherWorld.common.CommonProxy;
import anotherWorld.common.machines.Machines;
import anotherWorld.common.machines.tile.TileEntitySeparator;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
	}	
}