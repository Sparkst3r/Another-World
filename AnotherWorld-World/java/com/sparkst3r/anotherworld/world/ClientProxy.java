package com.sparkst3r.anotherworld.world;

import cpw.mods.fml.common.FMLCommonHandler;


/**
 * ClientProxy
 *	
 * World client proxy
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 3 Mar 2014
 */
public class ClientProxy extends CommonProxy {
	
	/**
	 * Register keybindings
	 */
	@Override
	public void registerKeyBindings() {
		FMLCommonHandler.instance().bus().register(new KeyHandlerWorld());
	}
	
}
