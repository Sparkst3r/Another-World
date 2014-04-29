package com.sparkst3r.anotherworld.mechanical.render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.mechanical.MechanicalValues;
import com.sparkst3r.anotherworld.mechanical.items.ItemTinkeringTool;
import com.sparkst3r.anotherworld.util.RenderingUtils;

/**
 * Renders the Tinkering tool
 * 
 * @author Sparkst3r
 *
 */
public class ToolRenderer implements IItemRenderer{
	
	/** Instance of the Tinkering Tool model */
	public ToolModel tool = new ToolModel();
	
	/** Checks if this renderer should handle a specific item's render type */
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	/** Checks if certain helper functionality should be executed for this renderer */
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return type == ItemRenderType.ENTITY;
	}

	
	//TODO Oh so much broken stuff. Fix Rendering in 3rd person
	/** Renders the item */
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		/** Binds the Tool texture */
		//
		switch (type) {
			
			/** Called when the item is a dropped entity in the world*/
			case ENTITY:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(GlobalValues.TEXTURE + "textures/entities/toolBase.png"));
				GL11.glTranslatef(1.0F, 0.5F, 0.0F);
				GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-45, 1.0F, 0.0F, 0.0F);
				tool.renderAll(0.1F, item);
				break;
			
			/** Called when the item is in the inventory as an item */
			case INVENTORY:
				//MachineMuse's code to draw the item sprite
				RenderingUtils.drawIconAt(0, 0, ((ItemTinkeringTool)MechanicalValues.itemTinkeringTool).getIconFromDamage(item.getItemDamage()));
				break;
				
			/** Called when the item is in the players hand */
			case EQUIPPED_FIRST_PERSON:
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(GlobalValues.TEXTURE + "textures/entities/toolBase.png"));
				/** If the incoming data is a player */
				if (data[1] != null && data[1] instanceof EntityPlayer) {
					
					/** How the item should render in 3rd person  !((EntityPlayer) data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 1 */
					if (!((EntityPlayer) data[1]).equals(Minecraft.getMinecraft().renderViewEntity)) {
						GL11.glScalef(1.1F, 1.1F, 1.1F);
						GL11.glRotatef(11F, 1.0F, 0.0F, 0.0F);
						GL11.glRotatef(13.5F, 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(13.5F, 0.0F, 0.0F, 1.0F);
						GL11.glTranslatef(0.186F, -0.3F, 0.186F);
						System.out.println("Ya wot");
					}
					
					/** How the item should render in 1st person */
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
			default:
				break;
		}
	}
	
}
