package com.sparkst3r.anotherworld.mechanical.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import org.lwjgl.opengl.GL11;

import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.mechanical.MechanicalValues;
import com.sparkst3r.anotherworld.mechanical.items.ItemTinkeringTool;
import com.sparkst3r.anotherworld.mechanical.tool.ToolActionShowInfoForBlock;
import com.sparkst3r.anotherworld.util.RenderingUtils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;

public class RenderHelpOverlay {
	
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution screen = event.resolution;
		
		EntityClientPlayerMP player = mc.thePlayer;
			if (player != null ) {
				
				ItemStack heldItem = player.getHeldItem();
				if (heldItem != null && heldItem.getUnlocalizedName().contains(MechanicalValues.itemTinkeringTool.identifierBase)) {
					ItemTinkeringTool currentTool = ((ItemTinkeringTool)heldItem.getItem());
					if (currentTool.currentModeIdentifier.equals("tool.tinker.mode.help")) {
						if (currentTool.currentAction instanceof ToolActionShowInfoForBlock) {
							ToolActionShowInfoForBlock action = (ToolActionShowInfoForBlock) currentTool.currentAction;
							if (action.blurbInfo != null) {
								renderHelp(action, screen);
							}
						}
					}
				}
		}

	}

	
	public void renderHelp(ToolActionShowInfoForBlock action, ScaledResolution screen) {
		/* Draws the block name background*/
		RenderingUtils.getRenderEngine().bindTexture(new ResourceLocation(GlobalValues.TEXTURE + "textures/gui/help_bg.png"));
		RenderingUtils.drawTexturedModalRect(16, 28, 0, 0, 200, 50);
		
		RenderingUtils.drawTexturedModalRect(2, 48, 0, 48, 200, 50);
		RenderingUtils.drawTexturedModalRect(2, 72, 0, 192, 200, 50);
		//RenderingUtils.getRenderEngine().resetBoundTexture();
		
		GL11.glPushMatrix();
			GL11.glScalef(0.75F, 0.75F, 1.0F);
			for (int line = 0; line < action.blurbInfo.length; line++) {
				RenderingUtils.getFontRenderer().drawString(action.blurbInfo[line], 10, 93 + line * 8, 0xFFFFFF, true);
			}
        GL11.glPopMatrix();
		
		RenderItem itemRenderer = new RenderItem();
		RenderingUtils.getFontRenderer().drawString(action.clickedBlock.getDisplayName(), 24, 40, 0xFFFFFF, true);
        itemRenderer.renderItemIntoGUI(RenderingUtils.getFontRenderer(), RenderingUtils.getRenderEngine(), action.renderIcon, 98, 37);

	}
}
