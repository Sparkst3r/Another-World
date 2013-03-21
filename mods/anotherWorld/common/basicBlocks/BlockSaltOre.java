package mods.anotherWorld.common.basicBlocks;

import java.util.Random;

import mods.anotherWorld.common.basicItems.BasicItems;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockSaltOre extends Ore{

	public BlockSaltOre(int id, String name) {
		super(id, name);
		this.setLightOpacity(1);
	}
    
	public int quantityDropped(Random par1Random) {
		int rand = 1 + (int)(Math.random() * 5);
        return rand;
    }
    
	public int idDropped(int par1, Random par2Random, int par3) {
        return BasicItems.Salt.itemID;
    }
	
	
	
    @Override
    public void registerIcons(IconRegister ir) {
    	this.blockIcon = ir.registerIcon("anotherWorld:oreSalt");
    }	

}
