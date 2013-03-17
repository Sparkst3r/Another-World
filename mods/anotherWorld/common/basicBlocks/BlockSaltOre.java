package mods.anotherWorld.common.basicBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockSaltOre extends Ore{

	public BlockSaltOre(int id, String name, Material mat) {
		super(id, name, null);
		this.setLightOpacity(1);
	}
	
    @Override
    public void func_94332_a(IconRegister ir) {
    	this.field_94336_cN = ir.func_94245_a("anotherWorld:oreSalt");
    }	

}
