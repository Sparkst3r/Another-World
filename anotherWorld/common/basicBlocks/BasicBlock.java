package anotherWorld.common.basicBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import anotherWorld.AnotherWorld;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BasicBlock extends Block
{
	public BasicBlock(int id, String name, int idInTexture, Material mat)
	{
		super(id, idInTexture, mat);
		this.setBlockName(name);
		this.setCreativeTab(AnotherWorld.TabAW);
		this.setTextureFile(AnotherWorld.blockTex);
		this.blockIndexInTexture = idInTexture;
		GameRegistry.registerBlock(this, name);
		LanguageRegistry.addName(this, name);
	}
}