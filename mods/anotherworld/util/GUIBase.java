package mods.anotherworld.util;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

public abstract class GUIBase extends GuiContainer {

	public GUIBase(Container par1Container) {
		super(par1Container);
	}

	@Override
	protected abstract void drawGuiContainerBackgroundLayer(float f, int i, int j);
	

	
	
}
