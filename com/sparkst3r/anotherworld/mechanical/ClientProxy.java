package com.sparkst3r.anotherworld.mechanical;

import com.sparkst3r.anotherworld.mechanical.CommonProxy;
import com.sparkst3r.anotherworld.mechanical.MechanicalValues;
import com.sparkst3r.anotherworld.mechanical.render.ToolRenderer;

import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;


import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * ClientProxy
 *
 * Client proxy for the mechanical expansion
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 4 Mar 2014
 */
public class ClientProxy extends CommonProxy{
	
	/**
	 * Registers renderers for the Mechanical Expansion
	 */
	@Override
	public void registerRendersForMechanical() {
		MinecraftForgeClient.registerItemRenderer(MechanicalValues.ItemToolField, new ToolRenderer());
	
	}
}
