package mods.anotherworld.mechanical.gui;

import mods.anotherworld.core.GlobalValues;
import mods.anotherworld.mechanical.container.ContainerLogicSimple;
import mods.anotherworld.mechanical.tileentity.TileLogicSimple;
import mods.anotherworld.util.GUIBase;
import mods.anotherworld.util.RenderingUtils;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiLogicSimple extends GUIBase {

	public TileLogicSimple te;
	
	
	public GuiLogicSimple(InventoryPlayer inventoryPlayer, TileLogicSimple tileEntity) {
		super(new ContainerLogicSimple(inventoryPlayer, tileEntity));
		this.te = tileEntity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		RenderingUtils.getRenderEngine().bindTexture(GlobalValues.GUIDIR + "LogicSimple.png");
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		
		RenderingUtils.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		
		int logicCons1X = x + 0;
		int logicCons1Y = y + 0;
		
		if (te.logicCons1[0]) {
			RenderingUtils.drawTexturedModalRect(logicCons1X, logicCons1Y + 10, 198, 16, 8, 32);
		}
		if (te.logicCons1[2]) {
			RenderingUtils.drawTexturedModalRect(logicCons1X + 48, logicCons1Y + 10, 245, 16, 8, 32);
		}
		if (te.logicCons1[1]) {
			RenderingUtils.drawTexturedModalRect(logicCons1X + 10, logicCons1Y, 208, 6, 32, 8);
		}
		if (te.logicCons1[3]) {
			RenderingUtils.drawTexturedModalRect(logicCons1X + 10, logicCons1Y + 48, 208, 6, 32, 8);
		}
		
		
		
	}
	
}
