package com.sparkst3r.anotherworld.mechanical.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.mechanical.items.ItemTinkeringTool;
import com.sparkst3r.anotherworld.mechanical.tool.ToolModeManager;
import com.sparkst3r.anotherworld.util.ModelBox;
import com.sparkst3r.anotherworld.util.RenderingUtils;

/**
 * Tinkering Tool's model
 * @author Sparkst3r
 *
 */
public class ToolModel extends ModelBase {
	int textureWidth = 64;
	int textureHeight = 32;
	
	public ModelBox base;
	public ModelRenderer shaft;
	public ModelRenderer tipRight;
	public ModelRenderer tipLeft;
	public ModelRenderer tipTop;
	public ModelRenderer tipBottom;
	public ModelRenderer plate;
	public ModelRenderer handRight;
	public ModelRenderer handLeft;
	public ModelRenderer handTop;
	public ModelRenderer handBottom;
	public ModelRenderer display;
	
	
	/** Model Constructor */
	public ToolModel() {
		base = new ModelBox(this, 0, 0, textureWidth, textureHeight, 0, 0, 0, 4, 4, 4);
		
		shaft = new ModelBox(this, 17, 0, textureWidth, textureHeight, 1, 1, 4, 2, 2, 8);
		
		tipRight = new ModelBox(this, 38, 0, textureWidth, textureHeight, 0, 1, 10, 1, 2, 4);

		tipLeft = new ModelBox(this, 38, 0, textureWidth, textureHeight, 3, 1, 10, 1, 2, 4);

		tipTop = new ModelBox(this, 38, 7, textureWidth, textureHeight, 1, 0, 10, 2, 1, 4);
		
		tipBottom = new ModelBox(this, 38, 7, textureWidth, textureHeight, 1, 3, 10, 2, 1, 4);
		
		plate = new ModelBox(this, 0, 9, textureWidth, textureHeight, -1, -1, -1, 6, 6, 1);
		
		handRight = new ModelBox(this, 0, 17, textureWidth, textureHeight, 4, 0, -6, 1, 4, 5);
		
		handLeft = new ModelBox(this, 0, 17, textureWidth, textureHeight, -1, 0, -6, 1, 4, 5);
		
		handTop = new ModelBox(this, 15, 11, textureWidth, textureHeight, 0, 4, -6, 4, 1, 5);
		
		handBottom = new ModelBox(this, 15, 11, textureWidth, textureHeight, 0, -1, -6, 4, 1, 5);
		
		display = new ModelBox(this, 13, 18, textureWidth, textureHeight, 0, 2.5F, 2F, 4, 2, 4);
        display.rotateAngleX = -32F;
        
	}
	
	
	/** Renders the model */
	public void renderAll(float scale, ItemStack stack) {
		
		base.render(scale);
		shaft.render(scale);
		tipRight.render(scale);
		tipLeft.render(scale);
		tipTop.render(scale);
		tipBottom.render(scale);
		plate.render(scale);
		handRight.render(scale);
		handLeft.render(scale);
		handTop.render(scale);
		handBottom.render(scale);
		display.render(scale);
    	
		/* Draw the mode icon. */
		GL11.glPushMatrix();
			calibrateForIcon();
			//TODO Fix mode icon
			RenderingUtils.drawIconAt(0, 0, ItemTinkeringTool.iconBuffer[stack.getItemDamage() + ToolModeManager.getModes().size()]);
			
		GL11.glPopMatrix();
		
		/* Draw the mode text. */
		GL11.glPushMatrix();
			calibrateForText();
			RenderHelper.disableStandardItemLighting();
			Minecraft.getMinecraft().fontRenderer.drawString(StatCollector.translateToLocal(ToolModeManager.getModes().get(stack.getItemDamage()).identifier()) , 1, 1, ToolModeManager.getModes().get(stack.getItemDamage()).nameColour());
			GL11.glTranslatef(5.0F, 8.0F, -1.0F);
			Minecraft.getMinecraft().fontRenderer.drawString(StatCollector.translateToLocal("tool.tinker.text.mode"), 1, 1, 0xFFFF00);
			RenderHelper.enableStandardItemLighting();
		GL11.glPopMatrix();
	}
	
	public void calibrateForIcon() {
		GL11.glTranslatef(0.3F, 0.61F, 0.00F);
		GL11.glScalef(0.008F, 0.008F, 0.008F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-32, 1.0F, 0.0F, 0.0F);
	}
	
	public void calibrateForText() {
		GL11.glTranslatef(0.4F, 0.69F, 0.14F);
		GL11.glScalef(0.008F, 0.008F, 0.008F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-32, 1.0F, 0.0F, 0.0F);
	}
	

	
}
