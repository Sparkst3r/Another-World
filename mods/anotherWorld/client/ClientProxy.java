package mods.anotherWorld.client;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.SidedProxy;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.CommonProxy;
import mods.anotherWorld.common.machines.Machines;
import mods.anotherWorld.common.machines.render.TileEntitySpaceChestRenderer;
import mods.anotherWorld.common.machines.tile.TileEntitySeparator;
import mods.anotherWorld.common.machines.tile.TileEntitySpaceChest;
import mods.anotherWorld.common.renderBase.EntityFXPlasma;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	@SidedProxy(clientSide = "mods.anotherWorld.client.ClientProxy", serverSide = "mods.anotherWorld.common.CommonProxy")
	public static ClientProxy proxy;
	
	
}