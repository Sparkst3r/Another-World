package mods.anotherWorld.common.basicBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.anotherWorld.AnotherWorld;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockTyteonRock extends BasicBlock {

	public BlockTyteonRock(int id, String name) {
		super(id, name, Material.rock);
	}
	
	  @Override
	    public void func_94332_a(IconRegister ir) {
	    	this.field_94336_cN = ir.func_94245_a("anotherWorld:rockTyteon");
	    }	

}
