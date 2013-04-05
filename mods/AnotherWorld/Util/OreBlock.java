package mods.AnotherWorld.Util;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * 
 * Basic Ore block. Just sets some parameters so I don't have to later
 * 
 * @author Sparkst3r
 *
 */
public class OreBlock extends BasicBlock {

	/**
	 * Extend OreBlock to inherit base Ore parameters
	 * @param id BlockID
	 * @param name Block name
	 */
	public OreBlock(int id, String name, String identifier) {
		super(id, Material.rock, name, identifier);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}

}
