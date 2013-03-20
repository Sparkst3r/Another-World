package mods.anotherWorld.common;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import mods.anotherWorld.common.machines.Machines;
import net.minecraft.item.ItemStack;

public class CommonProxy {
	@SidedProxy(clientSide = "mods.anotherWorld.client.ClientProxy", serverSide = "mods.anotherWorld.common.CommonProxy")
	public static CommonProxy proxy;
}