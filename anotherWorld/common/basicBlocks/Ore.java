package anotherWorld.common.basicBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class Ore extends BasicBlock {

	public Ore(int id, String name, int idInTexture, Material mat) {
		super(id, name, idInTexture, Material.rock);
		this.setHardness(10F);
		this.setStepSound(Block.soundStoneFootstep);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);
	}
	

}
