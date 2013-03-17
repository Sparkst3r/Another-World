package mods.anotherWorld.common.machines;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.basicBlocks.BasicBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;



public class BlockEngineeringGlass extends Block{
    public BlockEngineeringGlass(int id, Material material) {
        super(id,material);
        this.setUnlocalizedName(Machines.BlockEngineeringGlassName);
        this.setCreativeTab(AnotherWorld.TabAW);
        this.setHardness(4.0F);
        this.setStepSound(Block.soundGlassFootstep);


        LanguageRegistry.addName(this, Machines.BlockEngineeringGlassName);
        GameRegistry.registerBlock(this, Machines.BlockEngineeringGlassName);
}
    
    @Override
    public void func_94332_a(IconRegister ir) {
    	this.field_94336_cN = ir.func_94245_a("anotherWorld:glassEngineering");
    }
    
    
    
	public boolean renderAsNormalBlock() {
		return false;
	}
	public boolean isOpaqueCube() {
		return false;
	}	
}
