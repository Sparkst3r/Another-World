package mods.anotherworld.mechanical.render;

import mods.anotherworld.mechanical.items.ItemTool;
import mods.anotherworld.util.RenderingUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

/**
 * Tinkering Tool's model
 * @author Sparkst3r
 *
 */
public class ToolModel extends ModelBase {
	
	
	public ModelRenderer base;
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
		this.base = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 32);
		this.base.addBox(0F, 0F, 0F, 4, 4, 4);
		this.base.rotationPointX = 0.0F;
		this.base.rotationPointY = 0.0F;
		this.base.rotationPointZ = 0.0F;
		this.base.mirror = true;
        
        this.shaft = (new ModelRenderer(this, 17, 0)).setTextureSize(64, 32);
        this.shaft.addBox(0F, 0F, 0F, 2, 2, 8);
        this.shaft.rotationPointX = 1.0F;
        this.shaft.rotationPointY = 1.0F;
        this.shaft.rotationPointZ = 4.0F;
		this.shaft.mirror = true;
        
        this.tipRight = (new ModelRenderer(this, 38, 0)).setTextureSize(64, 32);
        this.tipRight.addBox(0F, 0F, 0F, 1, 2, 4);
        this.tipRight.rotationPointX = 0.0F;
        this.tipRight.rotationPointY = 1.0F;
        this.tipRight.rotationPointZ = 10.0F;
		this.tipRight.mirror = true;
        this.tipLeft = (new ModelRenderer(this, 38, 0)).setTextureSize(64, 32);
        this.tipLeft.addBox(0F, 0F, 0F, 1, 2, 4);
        this.tipLeft.rotationPointX = 3.0F;
        this.tipLeft.rotationPointY = 1.0F;
        this.tipLeft.rotationPointZ = 10.0F;
		this.tipLeft.mirror = true;
        this.tipTop = (new ModelRenderer(this, 38, 7)).setTextureSize(64, 32);
        this.tipTop.addBox(0F, 0F, 0F, 2, 1, 4);
        this.tipTop.rotationPointX = 1.0F;
        this.tipTop.rotationPointY = 0.0F;
        this.tipTop.rotationPointZ = 10.0F;
		this.tipTop.mirror = true;
        this.tipBottom = (new ModelRenderer(this, 38, 7)).setTextureSize(64, 32);
        this.tipBottom.addBox(0F, 0F, 0F, 2, 1, 4);
        this.tipBottom.rotationPointX = 1.0F;
        this.tipBottom.rotationPointY = 3.0F;
        this.tipBottom.rotationPointZ = 10.0F;
		this.tipBottom.mirror = true;
        this.plate = (new ModelRenderer(this, 0, 9)).setTextureSize(64, 32);
        this.plate.addBox(0F, 0F, 0F, 6, 6, 1);
        this.plate.rotationPointX = -1.0F;
        this.plate.rotationPointY = -1.0F;
        this.plate.rotationPointZ = -1.0F;
        this.plate.mirror = true;
        this.handRight = (new ModelRenderer(this, 0, 17)).setTextureSize(64, 32);
        this.handRight.addBox(0F, 0F, 0F, 1, 4, 5);
        this.handRight.rotationPointX = 4.0F;
        this.handRight.rotationPointY = 0.0F;
        this.handRight.rotationPointZ = -6.0F;
        this.handRight.mirror = true;
        this.handLeft = (new ModelRenderer(this, 0, 17)).setTextureSize(64, 32);
        this.handLeft.addBox(0F, 0F, 0F, 1, 4, 5);
        this.handLeft.rotationPointX = -1.0F;
        this.handLeft.rotationPointY = 0.0F;
        this.handLeft.rotationPointZ = -6.0F;
        this.handLeft.mirror = true;
        this.handTop = (new ModelRenderer(this, 15, 11)).setTextureSize(64, 32);
        this.handTop.addBox(0F, 0F, 0F, 4, 1, 5);
        this.handTop.rotationPointX = 0.0F;
        this.handTop.rotationPointY = 4.0F;
        this.handTop.rotationPointZ = -6.0F;
        this.handTop.mirror = true;
        this.handBottom = (new ModelRenderer(this, 15, 11)).setTextureSize(64, 32);
        this.handBottom.addBox(0F, 0F, 0F, 4, 1, 5);
        this.handBottom.rotationPointX = 0.0F;
        this.handBottom.rotationPointY = -1.0F;
        this.handBottom.rotationPointZ = -6.0F;
        this.handBottom.mirror = true;
        
        this.display = (new ModelRenderer(this, 13, 18)).setTextureSize(64, 32);
        this.display.addBox(0F, 0F, 0F, 4, 2, 4);
        this.display.rotationPointX = 0.0F;
        this.display.rotationPointY = 3.0F;
        this.display.rotationPointZ = -0.0F;
        this.display.rotateAngleX = -32F;
        this.display.mirror = true;
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
    	
    	/* */
		GL11.glPushMatrix();
			GL11.glTranslatef(0.3F, 0.61F, 0.00F);
			GL11.glScalef(0.008F, 0.008F, 0.008F);
			GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(-30, 1.0F, 0.0F, 0.0F);
			switch(stack.getItemDamage()) {
				case 0: 
					RenderingUtils.drawIconAt(0, 0, ItemTool.iconBuffer[ItemTool.types.length + 1]);
					break;
				case 1: 
					RenderingUtils.drawIconAt(0, 0, ItemTool.iconBuffer[ItemTool.types.length + 2]);
				break;
				case 2: 
					RenderingUtils.drawIconAt(0, 0, ItemTool.iconBuffer[ItemTool.types.length + 3]);
					break;
				case 3: 
					RenderingUtils.drawIconAt(0, 0, ItemTool.iconBuffer[ItemTool.types.length + 4]);
					break;
				case 4:
					RenderingUtils.drawIconAt(0, 0, ItemTool.iconBuffer[ItemTool.types.length + 5]);
					break;
				case 5: 
					RenderingUtils.drawIconAt(0, 0, ItemTool.iconBuffer[ItemTool.types.length + 6]);
			}
			GL11.glPopMatrix();
    	
			GL11.glPushMatrix();
				GL11.glTranslatef(0.4F, 0.69F, 0.14F);
				GL11.glScalef(0.008F, 0.008F, 0.008F);
				GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-32, 1.0F, 0.0F, 0.0F);
    		
				RenderHelper.disableStandardItemLighting();
    	
    	
				switch(stack.getItemDamage()) {
					case 0: 
						Minecraft.getMinecraft().fontRenderer.drawString("Activate", 1, 1, 0x000000);
						break;
					case 1: 
						Minecraft.getMinecraft().fontRenderer.drawString("Dismantle", 1, 1, 0xFF0000);
						break;
					case 2: 
						Minecraft.getMinecraft().fontRenderer.drawString("Rotate", 1, 1, 0x00FF00);
						break;
					case 3: 
						Minecraft.getMinecraft().fontRenderer.drawString("Help", 1, 1, 0x0000FF);
						break;
					case 4: 
						Minecraft.getMinecraft().fontRenderer.drawString("Settings", 1, 1, 0xFF00FF);
						break;
					case 5: 
						Minecraft.getMinecraft().fontRenderer.drawString("Move", 1, 1, 0x00FFFF);
	     			break;
					default: 
						Minecraft.getMinecraft().fontRenderer.drawString("Unknown", 1, 1, 0x000000);
						break;
	     	}
     	
	    	
	     	GL11.glTranslatef(5.0F, 8.0F, -1.0F);
	    	Minecraft.getMinecraft().fontRenderer.drawString("Mode", 1, 1, 0xFFFF00);
	    	GL11.glPopMatrix();
    	
       	RenderHelper.enableStandardItemLighting();
    }
	
}
