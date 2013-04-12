package mods.AnotherWorld.Mechanical.Gui;


import mods.AnotherWorld.Core.GlobalValues;
import mods.AnotherWorld.Mechanical.Container.ContainerMechanicsTable;
import mods.AnotherWorld.Mechanical.TileEntity.TileMechanicsTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;


public class GuiMechanicsTable extends GuiContainer {

	public GuiMechanicsTable (InventoryPlayer inventoryPlayer, TileMechanicsTable tileEntity) {
			super(new ContainerMechanicsTable(inventoryPlayer, tileEntity));
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
                fontRenderer.drawString("Mechanics Table", 88, 1, 0xFFFFFF, true);
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 95, 69, 0xFFFFFF, true);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.mc.renderEngine.bindTexture(GlobalValues.guiDir + "MechanicsTable.png");
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        }

}