package mods.anotherWorld.common;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import mods.anotherWorld.common.machines.Machines;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CommonProxy {
	@SidedProxy(clientSide = "mods.anotherWorld.client.ClientProxy", serverSide = "mods.anotherWorld.common.CommonProxy")
	public static CommonProxy proxy;

	public void FXPlasma(World world, double x, double y, double z, double xVel, double yVel, double zVel) {
		
	}


}