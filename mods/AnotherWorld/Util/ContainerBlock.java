package mods.AnotherWorld.Util;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.AnotherWorld.Core.GlobalValues;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ContainerBlock extends BlockContainer {

	/**
	 * Extend this class to create a block with a container
	 * @param id BlockID
	 * @param mat Material
	 * @param name Human-readable name of the block
	 * @param identifier Non human-readable name of the block. Used for texture file name.
	 */
	public ContainerBlock(int id, Material mat, String name, String identifier) {
		super(id, mat);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GlobalValues.AnotherTab);
		GameRegistry.registerBlock(this, identifier);
		LanguageRegistry.addName(this, name);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
}
