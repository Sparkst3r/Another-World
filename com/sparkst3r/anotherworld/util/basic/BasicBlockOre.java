package com.sparkst3r.anotherworld.util.basic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * 
 * Basic Ore block. Just sets some parameters so I don't have to later
 * 
 * @author Sparkst3r
 *
 */
public class BasicBlockOre extends BasicBlock {

	/**
	 * Extend OreBlock to inherit base Ore parameters
	 * @param id BlockID
	 * @param name Block name
	 */
	public BasicBlockOre(String identifier) {
		super(Material.rock, identifier);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(Block.soundTypeStone);
	}

}
