package mods.AnotherWorld.Util.Basic;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.AnotherWorld.Core.GlobalValues;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

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
	public BasicBlock(int id, Material mat, String name, String identifier) {
		super(id, mat);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GlobalValues.AnotherTab);
		GameRegistry.registerBlock(this, identifier);
		LanguageRegistry.addName(this, name);
	}

}
