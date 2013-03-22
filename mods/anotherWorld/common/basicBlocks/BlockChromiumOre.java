package mods.anotherWorld.common.basicBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockChromiumOre extends Ore{
	private static String iconTex;
	public BlockChromiumOre(int id, String name, String icon) {
		super(id, name);
		this.iconTex = icon;
	}
	
    @Override
    public void registerIcons(IconRegister ir) {
    	this.blockIcon = ir.registerIcon("anotherworld:" + iconTex);
    }

}
