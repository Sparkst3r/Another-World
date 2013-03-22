package mods.anotherWorld.common.basicBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.Base.BasicBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockTyteonRock extends Ore {

	private static String iconTex;

	public BlockTyteonRock(int id, String name, String icon) {
		super(id, name);
		this.iconTex = icon;
		this.setHardness(4F);
	}
	
	  @Override
	    public void registerIcons(IconRegister ir) {
	    	this.blockIcon = ir.registerIcon("anotherworld:" + iconTex);
	    }	

}
