package com.sparkst3r.anotherworld.util;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.sparkst3r.anotherworld.core.GlobalValues;

/** 
 * Some rendering methods. 
 * Credit to MachineMuse for these methods from 'MuseRenderer.class'.
 *
 */
public class RenderingUtils {

	/**
	 * 'adapted from MachineMuse's Modular Powersuits'~
	 * Draws a MuseIcon
	 *
	 * @param x
	 * @param y
	 * @param icon
	 * @param colour
	 */
	public static void drawIconAt(double x, double y, IIcon icon) {
		drawIconPartial(x, y, icon, 0, 0, 16, 16);
	}
	
	public static void drawTextureAt(double x, double y, ResourceLocation texture) {
		drawTexturePartial(x, y, texture, 0, 0, 16, 16);
	}
	
	/**
	 * 'adapted from MachineMuse's Modular Powersuits'~
	 * Draws a MuseIcon
	 *
	 * @param x
	 * @param y
	 * @param icon
	 * @param colour
	 */
	public static void drawIconPartial(double x, double y, IIcon icon, double left, double top, double right, double bottom) {
		if (icon == null) {
			return;
		}
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		texturelessOff();
		blendingOn();
		Tessellator tess = Tessellator.instance;
		tess.startDrawingQuads();
		float u1 = icon.getMinU();
		float v1 = icon.getMinV();
		float u2 = icon.getMaxU();
		float v2 = icon.getMaxV();
		double xoffset1 = left * (u2 - u1) / 16.0f;
		double yoffset1 = top * (v2 - v1) / 16.0f;
		double xoffset2 = right * (u2 - u1) / 16.0f;
		double yoffset2 = bottom * (v2 - v1) / 16.0f;

		tess.addVertexWithUV(x + left, y + top, 0, u1 + xoffset1, v1 + yoffset1);
		tess.addVertexWithUV(x + left, y + bottom, 0, u1 + xoffset1, v1 + yoffset2);
		tess.addVertexWithUV(x + right, y + bottom, 0, u1 + xoffset2, v1 + yoffset2);
		tess.addVertexWithUV(x + right, y + top, 0, u1 + xoffset2, v1 + yoffset1);
		tess.draw();

		blendingOff();
		GL11.glEnable(GL11.GL_CULL_FACE);
		// GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glPopMatrix();
	}
	
	public static void drawTexturePartial(double x, double y, ResourceLocation texture, double left, double top, double right, double bottom) {
		if (texture == null || texture.equals("")) {
			return;
		}
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		texturelessOff();
		blendingOn();
		Tessellator tess = Tessellator.instance;
		tess.startDrawingQuads();
		float u1 = 0;
		float v1 = 0;
		float u2 = 16;
		float v2 = 16;
		double xoffset1 = left * (u2 - u1) / 16.0f;
		double yoffset1 = top * (v2 - v1) / 16.0f;
		double xoffset2 = right * (u2 - u1) / 16.0f;
		double yoffset2 = bottom * (v2 - v1) / 16.0f;

		tess.addVertexWithUV(x + left, y + top, 0, u1 + xoffset1, v1 + yoffset1);
		tess.addVertexWithUV(x + left, y + bottom, 0, u1 + xoffset1, v1 + yoffset2);
		tess.addVertexWithUV(x + right, y + bottom, 0, u1 + xoffset2, v1 + yoffset2);
		tess.addVertexWithUV(x + right, y + top, 0, u1 + xoffset2, v1 + yoffset1);
		tess.draw();

		blendingOff();
		GL11.glEnable(GL11.GL_CULL_FACE);
		// GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glPopMatrix();
	}
	
	
	/**
	 * 'adapted from MachineMuse's Modular Powersuits'~
	 * Call after doing anything with alpha blending
	 */
	public static void blendingOff() {
		GL11.glShadeModel(GL11.GL_FLAT);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
		GL11.glDisable(GL11.GL_POLYGON_SMOOTH);
		GL11.glDisable(GL11.GL_BLEND);
		// GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}
	/**
	 * 'adapted from MachineMuse's Modular Powersuits'~
	 * Singleton pattern for RenderEngine
	 */
	public static TextureManager getRenderEngine() {
		return Minecraft.getMinecraft().renderEngine;
	}
	
	/**
	 * 'adapted from MachineMuse's Modular Powersuits'~
	 * Call after doing pure geometry (ie. with colours) to go back to the texture mode (default).
	 */
	public static void texturelessOff() {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	/**
	 * 'adapted from MachineMuse's Modular Powersuits'~
	 * Call before doing anything with alpha blending
	 */
	public static void blendingOn() {
		if (Minecraft.isFancyGraphicsEnabled()) {
			GL11.glShadeModel(GL11.GL_SMOOTH);
			// GL11.glEnable(GL11.GL_LINE_SMOOTH);
			// GL11.glEnable(GL11.GL_POLYGON_SMOOTH);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		}
	}
	
	/**
	 *  'adapted from MachineMuse's Modular Powersuits'~
	 * Does the necessary openGL calls and calls the Minecraft font renderer to draw a string such that the xcoord is halfway through the string
	 */
    public static void drawString(String s, double x, double y) {
    	RenderHelper.disableStandardItemLighting();
    	getFontRenderer().drawStringWithShadow(s, (int) x, (int) y, new ColourUtils(0.75, 0.75, 0.75, 1).getInt());
	}
    
    /**
     * Singleton pattern for FontRenderer
     */
    public static FontRenderer getFontRenderer() {
    	return Minecraft.getMinecraft().fontRenderer;
    }
	
	
    /**
     * Draws a textured rectangle at the stored z-value. Args: x, y, u, v, width, height
     */
    public static void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6)  {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + par6), (double)0, (double)((float)(par3 + 0) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + par6), (double)0, (double)((float)(par3 + par5) * f), (double)((float)(par4 + par6) * f1));
        tessellator.addVertexWithUV((double)(par1 + par5), (double)(par2 + 0), (double)0, (double)((float)(par3 + par5) * f), (double)((float)(par4 + 0) * f1));
        tessellator.addVertexWithUV((double)(par1 + 0), (double)(par2 + 0), (double)0, (double)((float)(par3 + 0) * f), (double)((float)(par4 + 0) * f1));
        tessellator.draw();
    }
	
	
	
}
