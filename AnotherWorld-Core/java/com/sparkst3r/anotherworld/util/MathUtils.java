package com.sparkst3r.anotherworld.util;

/**
 * Some basic maths functions.
 * @author Sparkst3r
 *
 */
public class MathUtils {
	
	/**
	 * Clamps a value between a minimum and maximum integer value.
	 * @param value The value to clamp
	 * @param min The maximum value
	 * @param max The minimum value
	 * @return The clamped output
	 */
	public static int clampInt(int value, int min, int max) {
		if (value <= max && value >= min) {
			return value;
		}
		else if (value > max) {
			return max;
		}
		else if (value < min) {
			return min;
		}
		return value;
	}
}
