package mods.anotherWorld.common.basicBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class Ore extends BasicBlock {

	public Ore(int id, String name, Material mat) {
		super(id, name, Material.rock);
		this.setHardness(10F);
		this.setStepSound(Block.soundStoneFootstep);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 2);
	}
	

}
