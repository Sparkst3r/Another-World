package mods.anotherWorld.common.machines.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSeparator extends ModelBase
{
    public ModelRenderer Base;
    public ModelRenderer Back;
    public ModelRenderer Tank;
    public ModelRenderer Liquid;
    
    public ModelSeparator()
    {
    	
        this.Base = (new ModelRenderer(this, 0, 0)).setTextureSize(128, 128);
        this.Base.addBox(0F, 0F, 0F, 14, 6, 14);
        this.Base.rotationPointX = 1.0F;
        this.Base.rotationPointY = 10.0F;
        this.Base.rotationPointZ = 2.0F;
        
        
        this.Back = (new ModelRenderer(this, 0, 21)).setTextureSize(128, 128);
        this.Back.addBox(0F, 0F, 0F, 12, 8, 5);
        this.Back.rotationPointX = 2.0F;
        this.Back.rotationPointY = 2.0F;
        this.Back.rotationPointZ = 11F;
        
        

 
            this.Tank = (new ModelRenderer(this, 0, 35)).setTextureSize(128, 128);
            Tank.addBox(0F, 0F, 0F, 16, 10, 11);
            this.Tank.rotationPointX = 0F;
            this.Tank.rotationPointY = 0.0F;
            this.Tank.rotationPointZ = 0.0F;
       
        	
    }

    /**
     * This method renders out all parts of the chest model.
     */
    public void renderAll()
    {
        this.Back.rotateAngleX = this.Base.rotateAngleX;
        this.Base.render(0.0625F);
        this.Back.render(0.0625F);
        this.Tank.render(0.0625F);
    }
}
