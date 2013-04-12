package mods.AnotherWorld.Util;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderEngine;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;

import org.lwjgl.opengl.GL11;

/** 
 * Some rendering methods. 
 * Credit to MachineMuse for these methods from 'MuseRenderer.class'.
 *
 */
public class RenderingUtils {

	public static String TEXTURE_MAP = "/gui/items.png";

	/**
	 * 'adapted from MachineMuse's Modular Powersuits'~
	 * Draws a MuseIcon
	 *
	 * @param x
	 * @param y
	 * @param icon
	 * @param colour
	 */
	public static void drawIconAt(double x, double y, Icon icon) {
		drawIconPartial(x, y, icon, 0, 0, 16, 16);
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
	public static void drawIconPartial(double x, double y, Icon icon, double left, double top, double right, double bottom) {
		if (icon == null) {
			return;
		}
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		texturelessOff();
		blendingOn();
		getRenderEngine().bindTexture(TEXTURE_MAP);
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
	public static RenderEngine getRenderEngine() {
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
	
	
}
