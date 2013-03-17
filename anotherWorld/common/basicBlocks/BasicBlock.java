package anotherWorld.common.basicBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import anotherWorld.AnotherWorld;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BasicBlock extends Block
{
	public BasicBlock(int id, String name, Material mat)
	{
		super(id, mat);
		this.setUnlocalizedName(name);
		this.setCreativeTab(AnotherWorld.TabAW);
		GameRegistry.registerBlock(this, name);
		LanguageRegistry.addName(this, name);
	}
}