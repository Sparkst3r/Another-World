package mods.anotherworld.util;

import org.lwjgl.opengl.GL11;

/**
 * 'adapted from MachineMuse's Modular Powersuits'~
 * Credit to MachineMuse for this class.
 * 
 * 
 * A class representing an RGBA colour and various helper functions. Mainly to
 * improve readability elsewhere.
 * 
 * @author MachineMuse
 */
public class ColourUtils {
	public static final ColourUtils LIGHTBLUE = new ColourUtils(0.5, 0.5, 1.0, 1.0);
	public static final ColourUtils DARKBLUE = new ColourUtils(0.0, 0.0, 0.5, 1.0);
	public static final ColourUtils ORANGE = new ColourUtils(0.9, 0.6, 0.2, 1.0);
	public static final ColourUtils YELLOW = new ColourUtils(0.0, 0.0, 0.5, 1.0);
	public static final ColourUtils WHITE = new ColourUtils(1.0, 1.0, 1.0, 1.0);
	public static final ColourUtils BLACK = new ColourUtils(0.0, 0.0, 0.0, 1.0);

	/**
	 * The RGBA values are stored as floats from 0.0F (nothing) to 1.0F (full
	 * saturation/opacity)
	 */
	public double r, g, b, a;

	/**
	 * Constructor. Just sets the RGBA values to the parameters.
	 */
	public ColourUtils(double r, double g, double b, double a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	/**
	 * Secondary constructor. Sets RGB accordingly and sets alpha to 1.0F (full
	 * opacity)
	 */
	public ColourUtils(float r, float g, float b) {
		this(r, g, b, 1.0F);
	}

	/**
	 * Takes colours in the integer format that Minecraft uses, and converts.
	 */
	public ColourUtils(int c) {
		this.a = (c >> 24 & 255) / 255.0F;
		this.r = (c >> 16 & 255) / 255.0F;
		this.g = (c >> 8 & 255) / 255.0F;
		this.b = (c & 255) / 255.0F;
	}

	/**
	 * Returns this colour as an int in Minecraft's format (I think)
	 * 
	 * @return int value of this colour
	 */
	public int getInt() {
		int val = 0;
		val = val | ((int) (a * 255) << 24);
		val = val | ((int) (r * 255) << 16);
		val = val | ((int) (g * 255) << 8);
		val = val | ((int) (b * 255));

		return val;
	}

	/**
	 * Returns a colour with RGB set to the same value ie. a shade of grey.
	 */

	public static ColourUtils getGreyscale(float value, float alpha) {
		return new ColourUtils(value, value, value, alpha);
	}

	/**
	 * Returns a colour at interval interval along a linear gradient from this
	 * to target
	 */

	public ColourUtils interpolate(ColourUtils target, double d) {
		double complement = 1 - d;
		return new ColourUtils(this.r * complement + target.r * d, this.g * complement + target.g * d, this.b * complement + target.b * d, this.a
				* complement + target.a * d);
	}

	public void doGL() {
		GL11.glColor4d(r, g, b, a);
	}

	public ColourUtils withAlpha(double newalpha) {
		return new ColourUtils(this.r, this.g, this.b, newalpha);
	}

	public double[] asArray() {
		return new double[] { r, g, b, a };
	}
}