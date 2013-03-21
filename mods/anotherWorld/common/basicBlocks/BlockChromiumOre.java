package mods.anotherWorld.common.basicBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockChromiumOre extends Ore{

	public BlockChromiumOre(int id, String name) {
		super(id, name);
	}
	
    @Override
    public void registerIcons(IconRegister ir) {
    	this.blockIcon = ir.registerIcon("anotherWorld:oreChromium");
    }

}
