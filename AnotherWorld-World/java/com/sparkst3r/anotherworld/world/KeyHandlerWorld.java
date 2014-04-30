/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.world;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.world.network.packet.OpenBackpackPacket;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

/**
 * KeyHandlerWorld
 * 
 * Handles key presses for the world expansion
 *
 * @author Sparkst3r
 * @since 29 Apr 2014
 */
public class KeyHandlerWorld {
	
	/** KeyBinding for openening the backpack */
	private KeyBinding OPENBACKPACK = new KeyBinding("key." + GlobalValues.MODIDWORLD + ".backpack", Keyboard.KEY_X, "key.catagories." + GlobalValues.MODIDCORE);
	
	/**
	 * Constructor
	 */
	public KeyHandlerWorld() {
	    ClientRegistry.registerKeyBinding(OPENBACKPACK);
	}
	
	/**
	 * Handle key presses on KeyInputEvent
	 */
	@SubscribeEvent
	public void handleKeyPress(KeyInputEvent event) {
		//Ensure the chat gui isn't open
		if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
			
			if(OPENBACKPACK.isPressed()) {
				GlobalValues.packetPipeline.sendToServer(new OpenBackpackPacket());
			}
			
		}
	}
	
}
