package mods.anotherWorld.common.spaceship.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import mods.anotherWorld.common.Base.BasicBlock;

public class BlockCarbonPlating extends BasicBlock{
	private static String iconTex;
	public BlockCarbonPlating(int id, String name, String icon) {
		super(id, name, Material.rock);
		this.iconTex = icon;
	}
	
    @Override
    public void registerIcons(IconRegister ir) {
    	this.blockIcon = ir.registerIcon("anotherworld:" + iconTex);
    }	

}
