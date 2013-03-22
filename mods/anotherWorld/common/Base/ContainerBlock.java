package mods.anotherWorld.common.Base;

import mods.anotherWorld.AnotherWorld;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ContainerBlock extends BlockContainer
{
	public ContainerBlock(int id, String name, Material mat)
	{
		super(id, mat);
		this.setUnlocalizedName(name);
		this.setCreativeTab(AnotherWorld.TabAW);
		GameRegistry.registerBlock(this, name);
		LanguageRegistry.addName(this, name);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}
}