package anotherWorld.common.machines;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import anotherWorld.AnotherWorld;
import anotherWorld.common.basicBlocks.BasicBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;



public class BlockEngineeringGlass extends Block{
    public BlockEngineeringGlass(int id, int texture, Material material) {
        super(id, texture, material);
        this.setBlockName(Machines.BlockEngineeringGlassName);
        this.setCreativeTab(AnotherWorld.TabAW);
        
        this.setHardness(4.0F);
        this.setStepSound(Block.soundGlassFootstep);


        LanguageRegistry.addName(this, Machines.BlockEngineeringGlassName);
        GameRegistry.registerBlock(this, Machines.BlockEngineeringGlassName);
}
    
    
	public String getTextureFile() {
		return AnotherWorld.blockTex;
	}
	public boolean renderAsNormalBlock() {
		return false;
	}
	public boolean isOpaqueCube() {
		return false;
	}	
}
