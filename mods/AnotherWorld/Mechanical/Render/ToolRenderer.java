package mods.AnotherWorld.Mechanical.Render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLLog;
import mods.AnotherWorld.Core.GlobalValues;
import mods.AnotherWorld.Mechanical.MechanicalValues;
import mods.AnotherWorld.Util.RenderingUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

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

	/** Renders the item */
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		/** Binds the Tool texture */
		Minecraft.getMinecraft().renderEngine.bindTexture(GlobalValues.entityDir + "toolBase.png");
		switch (type) {
			
			/** Called when the item is a dropped entity in the world*/
			case ENTITY:

				GL11.glTranslatef(1.0F, 0.5F, 0.0F);
				GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-45, 1.0F, 0.0F, 0.0F);
				tool.renderAll(0.1F, item);
				break;
			
			/** Called when the item is in the inventory as an item */
			case INVENTORY:
				
				//MachineMuse's code to draw the item sprite
				RenderingUtils.drawIconAt(0, 0, MechanicalValues.ItemToolField.getIconIndex(item));
				break;
				
			/** Called when the item is in the players hand */
			case EQUIPPED:
				
				/** If the incoming data is a player */
				if (data[1] != null && data[1] instanceof EntityPlayer) {
					
					/** How the item should render in 3rd person */
					if (!((EntityPlayer) data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0)) {
						GL11.glScalef(1.1F, 1.1F, 1.1F);
						GL11.glRotatef(11F, 1.0F, 0.0F, 0.0F);
						GL11.glRotatef(13.5F, 0.0F, 1.0F, 0.0F);
						GL11.glRotatef(13.5F, 0.0F, 0.0F, 1.0F);
						GL11.glTranslatef(0.186F, -0.3F, 0.186F);
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
		}
	}
	
}