package com.sparkst3r.anotherworld.util.basic;

import com.sparkst3r.anotherworld.core.AnotherWorldTab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Provides basic block functionality and registers the block with the Language 
 * and Game registry
 * Class needs to be extended by the new block
 * 
 * @author Sparkst3r
 *
 */
public class BasicBlock extends Block {

	/**
	 * Extend this class to create a standard block
	 * @param id BlockID
	 * @param mat Material
	 * @param name Human-readable name of the block
	 * @param identifier Non human-readable name of the block. Used for texture file name.
	 */
	public BasicBlock(Material mat, String identifier) {
		super(mat);
		this.setCreativeTab(AnotherWorldTab.TAB);
		GameRegistry.registerBlock(this, identifier);
	}

}
