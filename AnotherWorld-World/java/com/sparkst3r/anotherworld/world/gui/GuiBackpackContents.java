/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.world.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.world.container.ContainerBackpackContents;

/**
 * GuiBackpackContents
 *
 * @author Sparkst3r
 * @since 30 Apr 2014
 */
public class GuiBackpackContents extends GuiContainer {

	/** GUI texture */
	private static final ResourceLocation TEXTURE = new ResourceLocation(GlobalValues.MODIDWORLD, "textures/gui/Backpack.png");
	
	/** The width of the texture */
	private static final int xTextSize = 176;
	
	/** The height of the texture */
	private static final int yTextSize = 232;
	
	/** width/height of the pouch overlay */
	private static final int overlaySize = 60;
	
	/** Stack containing the backpack item */
	private ItemStack backpackStack;
	
	
	
	/**
	 * Contructor
	 * @param player the player using the gui
	 * @param stack the backpack item
	 */
	public GuiBackpackContents(EntityPlayer player, ItemStack stack) {
		super(new ContainerBackpackContents(player, stack));
		backpackStack = stack;
		xSize = xTextSize;
		ySize = yTextSize;
	}

	/** 
	 * Draws everything behind the slots
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		this.drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(GuiBackpackContents.TEXTURE);
		int xTextPos = (width - xTextSize) / 2;
		int yTextPos = (height - yTextSize) / 2;
		this.drawTexturedModalRect(xTextPos, yTextPos, 0, 0, xTextSize, yTextSize);
		
		int pouchLevel = backpackStack.getTagCompound().getInteger("pouchLevel");
		
		if (pouchLevel != -1) {
			switch(pouchLevel) {
				case 4: {
					this.drawTexturedModalRect(xTextPos + 87, yTextPos + 82, 192, 4, overlaySize, overlaySize);
				}
				case 3: {
					this.drawTexturedModalRect(xTextPos + 29, yTextPos + 82, 192, 4, overlaySize, overlaySize);
				}
				case 2: {
					this.drawTexturedModalRect(xTextPos + 87, yTextPos + 24, 192, 4, overlaySize, overlaySize);
				}
				case 1: {
					this.drawTexturedModalRect(xTextPos + 29, yTextPos + 24, 192, 4, overlaySize, overlaySize);
				}
			}
		}
		
		
	}

}
