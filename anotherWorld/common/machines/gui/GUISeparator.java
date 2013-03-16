package anotherWorld.common.machines.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import anotherWorld.AnotherWorld;
import anotherWorld.common.machines.container.ContainerSeparator;
import anotherWorld.common.machines.tile.TileEntitySeparator;

public class GUISeparator extends GuiContainer {

        public GUISeparator (InventoryPlayer inventoryPlayer,
                        TileEntitySeparator tileEntity) {
                //the container is instantiated and passed to the superclass for handling
                super(new ContainerSeparator(inventoryPlayer, tileEntity));
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
                //draw text and stuff here
                //the parameters for drawString are: string, x, y, color
                fontRenderer.drawString("Separator", 8, 6, 4210752);
                //draws "Inventory" or your regional equivalent
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
                int texture = mc.renderEngine.getTexture(AnotherWorld.guiDir + "SeparatorGUI.png");
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.mc.renderEngine.bindTexture(texture);
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        }

}