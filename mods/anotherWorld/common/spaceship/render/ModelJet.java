package mods.anotherWorld.common.spaceship.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelJet extends ModelBase
{
    public ModelRenderer CaseT;
    public ModelRenderer CaseB;
    public ModelRenderer CaseL;
    public ModelRenderer CaseR;
    public ModelRenderer InnerT;
    public ModelRenderer InnerB;
    public ModelRenderer InnerL;
    public ModelRenderer InnerR;
    public ModelRenderer Turbine;
    public ModelRenderer Shaft;
    public ModelRenderer Cap;
    
    public ModelJet()
    {
    	
        this.CaseT = (new ModelRenderer(this, 0, 29)).setTextureSize(64, 64);
        this.CaseT.addBox(0F, 0F, 0F, 14, 1, 12);
        this.CaseT.rotationPointX = 1.0F;
        this.CaseT.rotationPointY = 0.0F;
        this.CaseT.rotationPointZ = 0.0F;
        
        this.CaseB = (new ModelRenderer(this, 0, 29)).setTextureSize(64, 64);
        this.CaseB.addBox(0F, 0F, 0F, 14, 1, 12);
        this.CaseB.rotationPointX = 1.0F;
        this.CaseB.rotationPointY = 15.0F;
        this.CaseB.rotationPointZ = 0.0F;
        
        this.CaseL = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
        this.CaseL.addBox(0F, 0F, 0F, 1, 16, 12);
        this.CaseL.rotationPointX = 15.0F;
        this.CaseL.rotationPointY = 0.0F;
        this.CaseL.rotationPointZ = 0.0F;
        	
        this.CaseR = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
        this.CaseR.addBox(0F, 0F, 0F, 1, 16, 12);
        this.CaseR.rotationPointX = 0.0F;
        this.CaseR.rotationPointY = 0.0F;
        this.CaseR.rotationPointZ = 0.0F;
        
        this.InnerT = (new ModelRenderer(this, 19, 43)).setTextureSize(64, 64);
        this.InnerT.addBox(0F, 0F, 0F, 8, 1, 8);
        this.InnerT.rotationPointX = 4.0F;
        this.InnerT.rotationPointY = 3.0F;
        this.InnerT.rotationPointZ = 6.0F;
        
        this.InnerB = (new ModelRenderer(this, 19, 43)).setTextureSize(64, 64);
        this.InnerB.addBox(0F, 0F, 0F, 8, 1, 8);
        this.InnerB.rotationPointX = 4.0F;
        this.InnerB.rotationPointY = 12.0F;
        this.InnerB.rotationPointZ = 6.0F;
        
        this.InnerL = (new ModelRenderer(this, 0, 43)).setTextureSize(64, 64);
        this.InnerL.addBox(0F, 0F, 0F, 1, 10, 8);
        this.InnerL.rotationPointX = 3.0F;
        this.InnerL.rotationPointY = 3.0F;
        this.InnerL.rotationPointZ = 6.0F;
        
        this.InnerR = (new ModelRenderer(this, 0, 43)).setTextureSize(64, 64);
        this.InnerR.addBox(0F, 0F, 0F, 1, 10, 8);
        this.InnerR.rotationPointX = 12.0F;
        this.InnerR.rotationPointY = 3.0F;
        this.InnerR.rotationPointZ = 6.0F;
        
        this.Turbine = (new ModelRenderer(this, 27, 0)).setTextureSize(64, 64);
        this.Turbine.addBox(0F, 0F, 0F, 14, 14, 0);
        this.Turbine.rotationPointX = 1.0F;
        this.Turbine.rotationPointY = 1.0F;
        this.Turbine.rotationPointZ = 2.0F;
        
        this.Shaft = (new ModelRenderer(this, 27, 15)).setTextureSize(64, 64);
        this.Shaft.addBox(0F, 0F, 0F, 2, 2, 10);
        this.Shaft.rotationPointX = 7.0F;
        this.Shaft.rotationPointY = 7.0F;
        this.Shaft.rotationPointZ = 1.0F;
        
        this.Cap = (new ModelRenderer(this, 19, 53)).setTextureSize(64, 64);
        this.Cap.addBox(0F, 0F, 0F, 4, 4, 4);
        this.Cap.rotationPointX = 6.0F;
        this.Cap.rotationPointY = 6.0F;
        this.Cap.rotationPointZ = 12.0F;
        
    }

    /**
     * This method renders out all parts of the chest model.
     */
    public void renderAll()
    {
        this.CaseT.render(0.0625F);
        this.CaseB.render(0.0625F);
        this.CaseL.render(0.0625F);
        this.CaseR.render(0.0625F);
        this.InnerT.render(0.0625F);
        this.InnerB.render(0.0625F);
        this.InnerL.render(0.0625F);
        this.InnerR.render(0.0625F);
        this.Turbine.render(0.0625F);
        this.Shaft.render(0.0625F);
        this.Cap.render(0.0625F);
    }
}