package mods.anotherworld.client;

import mods.anotherworld.common.CommonProxy;
import mods.anotherworld.mechanical.MechanicalValues;
import mods.anotherworld.mechanical.render.ToolRenderer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerRenders() {
		MinecraftForgeClient.registerItemRenderer(MechanicalValues.ItemToolField.itemID, new ToolRenderer());
	}
	
	
	
	
	/**
	 * Client Particle spawner for plasma
	 * Spawns a Plasma particle
	 * @param world The world to spawn the particle in
	 * @param x X location to spawn the particle at
	 * @param y Y location to spawn the particle at
	 * @param z Z location to spawn the particle at
	 * @param xVel X velocity to spawn the particle with
	 * @param yVel Y velocity to spawn the particle with
	 * @param zVel Z velocity to spawn the particle with
	 * @param colour RGB colour to spawn the particle as
	 */
	public void spawnPlasma(World world, double x, double y, double z, double xVel, double yVel, double zVel, float[] colour) {
    	//EntityFX fx = new EntityFXPlasma(Minecraft.getMinecraft().theWorld, x, y, z, xVel, yVel, zVel, colour);
    	//FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)fx);

    }
	
	
	
	
}