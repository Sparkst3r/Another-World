package mods.anotherworld.mechanical.gui;

import mods.anotherworld.core.GlobalValues;
import mods.anotherworld.mechanical.container.ContainerLogicSimple;
import mods.anotherworld.mechanical.tileentity.TileLogicSimple;
import mods.anotherworld.util.GUIBase;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;

public class GuiLogicSimple extends GUIBase {

	public GuiLogicSimple(InventoryPlayer inventoryPlayer, TileLogicSimple tileEntity) {
		super(new ContainerLogicSimple(inventoryPlayer, tileEntity));
		System.out.println("hhdhadads");
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(GlobalValues.guiDir + "LogicSimple.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
}
