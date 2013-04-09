package mods.AnotherWorld.Mechanical.Render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLLog;
import mods.AnotherWorld.Core.GlobalValues;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ToolRenderer implements IItemRenderer{
	public ToolModel tool = new ToolModel();
	
	/** Checks if this renderer should handle a specific item's render type */
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	/** Checks if certain helper functionality should be executed for this renderer */
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return type == ItemRenderType.ENTITY;
	}

	/** Renders the item */
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		/** Binds the Tool texture */
		Minecraft.getMinecraft().renderEngine.bindTexture(GlobalValues.entityDir + "toolBase.png");
		switch (type) {
			case ENTITY:

				GL11.glTranslatef(1.0F, 0.5F, 0.0F);
				GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-45, 1.0F, 0.0F, 0.0F);
				tool.renderAll(0.1F, item);
				break;
			case INVENTORY:
				break;
			case EQUIPPED:
				if (data[1] != null && data[1] instanceof EntityPlayer) {
					if (!((EntityPlayer) data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0)) {
					GL11.glScalef(1.2F, 1.2F, 1.2F);
					GL11.glRotatef(18, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(19, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(4, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.12F, -0.3F, 0.2F);
					
					} 
					else {
						GL11.glTranslatef(1.0F, 0.5F, 0.0F);
						GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(-45, 1.0F, 0.0F, 0.0F);

					}
					
				}
				
				tool.renderAll(0.1F, item);	
				break;
			case FIRST_PERSON_MAP:
				break;
		}
	}
	
}
