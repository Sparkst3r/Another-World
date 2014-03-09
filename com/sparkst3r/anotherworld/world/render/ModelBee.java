package main.java.com.sparkst3r.anotherworld.world.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBee extends ModelBase {
	
	public int textureX = 64;
	public int textureY = 32;
	
	/* Parts */
	public ModelRenderer body;
	public ModelRenderer wingLeft;
	public ModelRenderer wingRight;
	public ModelRenderer eyeLeft;
	public ModelRenderer eyeRight;
	public ModelRenderer legs;
	
	public ModelBee() {
		body = new ModelRenderer(this, 0, 0);
		body.addBox(0F, 0F, 0F, 2, 2, 5);
		body.setRotationPoint(0F, 21F, 0F);
		body.setTextureSize(textureX, textureY);
		body.mirror = true;
		this.setRotation(body, 0F, 0F, 0F);
		
		wingLeft = new ModelRenderer(this, 15, 4);
		wingLeft.addBox(0F, 0F, 0F, 3, 1, 3);
		wingLeft.setRotationPoint(2F, 20F, 1F);
		wingLeft.setTextureSize(64, 32);
		wingLeft.mirror = true;
		this.setRotation(wingLeft, 0F, 0F, 0F);
		
		wingRight = new ModelRenderer(this, 15, 0);
		wingRight.addBox(0F, 0F, 0F, 3, 1, 3);
		wingRight.setRotationPoint(-3F, 20F, 1F);
		wingRight.setTextureSize(64, 32);
		wingRight.mirror = true;
		this.setRotation(wingRight, 0F, 0F, 0F);
		
		eyeLeft = new ModelRenderer(this, 0, 7);
		eyeLeft.addBox(0F, 0F, 0F, 1, 1, 1);
		eyeLeft.setRotationPoint(1.5F, 20.5F, -0.5F);
		eyeLeft.setTextureSize(64, 32);
		eyeLeft.mirror = true;
		this.setRotation(eyeLeft, 0F, 0F, 0F);
		
		eyeRight = new ModelRenderer(this, 4, 7);
		eyeRight.addBox(0F, 0F, 0F, 1, 1, 1);
		eyeRight.setRotationPoint(-0.5F, 20.5F, -0.5F);
		eyeRight.setTextureSize(64, 32);
		eyeRight.mirror = true;
		this.setRotation(eyeRight, 0F, 0F, 0F);
		
		legs = new ModelRenderer(this, 9, 7);
		legs.addBox(0F, 0F, 0F, 2, 1, 1);
		legs.setRotationPoint(0F, 22.5F, 5F);
		legs.setTextureSize(64, 32);
		legs.mirror = true;
		this.setRotation(legs, 0F, 0F, 0F);
		
	}
	
	public void render(float scale) {
		body.render(scale);
		wingLeft.render(scale);
		wingRight.render(scale);
		eyeLeft.render(scale);
		eyeRight.render(scale);
		legs.render(scale);
	}
	
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float scale) {
		super.render(par1Entity, par2, par3, par4, par5, par6, scale);
		setRotationAngles(par2, par3, par4, par5, par6, scale, par1Entity);
		body.render(scale);
		wingLeft.render(scale);
		wingRight.render(scale);
		eyeLeft.render(scale);
		eyeRight.render(scale);
		legs.render(scale);
		
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
	}
	
}
