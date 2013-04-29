package mods.anotherworld.mechanical.tick;

import java.util.EnumSet;

import mods.anotherworld.mechanical.MechanicalValues;
import mods.anotherworld.mechanical.items.ItemTool;
import mods.anotherworld.mechanical.tool.ToolActionShowInfoForBlock;
import mods.anotherworld.util.RenderingUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class RenderTick implements ITickHandler {
	public static int timeSinceRenderRequest = 0;

	
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {

	}

	
	
	
	
	
	
	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution screen = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		
		EntityClientPlayerMP player = mc.thePlayer;

		 if (timeSinceRenderRequest > 0) {
			if (player != null && mc.currentScreen == null) {
				
				ItemStack heldItem = player.getHeldItem();
				if (heldItem != null && heldItem.itemID == MechanicalValues.ItemToolField.itemID) {
					ItemTool currentTool = ((ItemTool)heldItem.getItem());
					
					if (currentTool.currentModeIdentifier.equals("help") && currentTool.currentAction instanceof ToolActionShowInfoForBlock) {
						ToolActionShowInfoForBlock action = (ToolActionShowInfoForBlock) currentTool.currentAction;
						System.out.println("LOL FUN");
						if (action.blurbInfo != null) {
							
							renderHelp(action, screen);
						}

					}
				}
			}
			timeSinceRenderRequest--;
		}

	}

	
	public void renderHelp(ToolActionShowInfoForBlock action, ScaledResolution screen) {
		RenderItem itemRenderer = new RenderItem();
		RenderingUtils.getFontRenderer().drawString(action.clickedBlock.getDisplayName(), 37, 40, 0xFFFFFF, true);
        itemRenderer.renderItemIntoGUI(RenderingUtils.getFontRenderer(), RenderingUtils.getRenderEngine(), action.renderIcon, 100, 37);
        GL11.glScalef(0.75F, 0.75F, 1.0F);
        for (int line = 0; line < action.blurbInfo.length; line++) {
    		RenderingUtils.drawString(action.blurbInfo[line], 10, 90 + line * 8);
        }
	}
	
	
	
	@Override
	public EnumSet<TickType> ticks() {
    	return EnumSet.of(TickType.RENDER);
	}

	@Override
	public String getLabel() {
		return "AnotherWorld_Mech_TickRender";
	}
	
}
