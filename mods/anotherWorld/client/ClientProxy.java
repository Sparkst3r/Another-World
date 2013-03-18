package mods.anotherWorld.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.CommonProxy;
import mods.anotherWorld.common.machines.Machines;
import mods.anotherWorld.common.machines.tile.TileEntitySeparator;
import mods.anotherWorld.common.machines.tile.TileEntitySpaceChest;
import mods.anotherWorld.common.machines.tile.TileEntitySpaceChestRenderer;
import net.minecraft.block.Block;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
	}	
}