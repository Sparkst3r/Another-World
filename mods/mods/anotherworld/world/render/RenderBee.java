package mods.anotherworld.world.render;

import mods.anotherworld.world.entity.EntityBee;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderBee extends RenderLiving {
	protected ModelBee model;
	
	public RenderBee(ModelBee bee) {
		super(bee, 0F);
		model = (ModelBee) mainModel;
	}
	
	public void renderBee(EntityBee entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		renderBee((EntityBee) par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		renderBee((EntityBee) par1Entity, par2, par4, par6, par8, par9);
	}
}