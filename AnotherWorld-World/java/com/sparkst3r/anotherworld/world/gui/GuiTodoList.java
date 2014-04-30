/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.world.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.sparkst3r.anotherworld.core.GlobalValues;

/** 
 * GuiTodoList
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 5 Apr 2014
 */
public class GuiTodoList extends GuiScreen {
	
	/** GUI texture */
	private static final ResourceLocation texture = new ResourceLocation(GlobalValues.MODIDWORLD, "textures/gui/TODO.png");
	
	/** The width of the texture */
	private static final int xTextSize = 240;
	
	/** The height of the texture */
	private static final int yTextSize = 176;

	private GuiButton testbutton;
	
	/**
	 * @param player the player using the book
	 * @param stack the book
	 */
	public GuiTodoList(EntityPlayer player, ItemStack stack) {
		this.initGui();
	}
	
	
	public void initGui() {
		this.buttonList.clear();
	
		int posX = (this.width - xTextSize) / 2;
		int posY = (this.height - yTextSize) / 2;
		testbutton = new GuiButton(0, posX+ 40, posY + 40, 100, 20, "fancy button");
		this.buttonList.add(this.testbutton);
	}
	
	/**
	 * Draws the GUI
	 */
	@Override
	public void drawScreen(int x, int y, float f) {
		this.drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(this.texture);
		int xTextPos = (width - xTextSize) / 2;
		int yTextPos = (height - yTextSize) / 2;
		this.drawTexturedModalRect(xTextPos, yTextPos, 0, 0, xTextSize, yTextSize);
		this.testbutton.drawButton(this.mc, xTextPos + 40, yTextPos + 40);
	}
	
	/**
	 * Does this gui pause the game while open
	 */
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
}
