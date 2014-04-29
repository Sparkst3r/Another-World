package com.sparkst3r.anotherworld.util;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * A bare bones box in a model.
 * @author Sparkst3r
 *
 */
public class ModelBox extends ModelRenderer {

	/**
	 * Adds a new box
	 * @param modelParent The model it will be added to
	 * @param u The U coordinate on the texture file
	 * @param v The V coordinate on the texture file
	 * @param width The width of the texture file
	 * @param height The height of the texture file
	 * @param originX The X origin point of the box
	 * @param originY The Y origin point of the box
	 * @param originZ The Z origin point of the box
	 * @param boxWidth The width of the box
	 * @param boxHeight The height of the box
	 * @param boxDepth The depth of the box
	 */
	public ModelBox(ModelBase modelParent, int u, int v, int width, int height, float originX,  float originY, float originZ, int boxWidth, int boxHeight, int boxDepth) {
		super(modelParent, u, v);
		this.setTextureSize(width, height);
		this.addBox(originX, originY, originZ, boxWidth, boxHeight, boxDepth, 0.0F);
        this.mirror = true;
	}
}
