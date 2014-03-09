package com.sparkst3r.anotherworld.mechanical.blockinfo;

import com.sparkst3r.anotherworld.api.info.IStandardBlockInfoPage;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;


public class StandardBlockInfoGrass implements IStandardBlockInfoPage {
	String[] infoBlurb = new String[] {
			"Grass covers the majority of the exposed ",
			"ground in Minecraft.",
			"Dirt is found underneath this layer of grass.",
			"Grass can be broken with a bare hand or more",
			"efficiently with a shovel of any material"
	};
	
	String[] infoComplete = new String[] { 
			"Found in every biome and is scattered with ores throughout the",
			"Minecraft world.",
			"",
			"Technical info :",
			"	Block ID = '2'",
			"	Metadata = N/A",
			
	};
	
	@Override
	public ItemStack block() {
		return new ItemStack(Block.getBlockFromName("grass"), 1, 0);
	}
	
	@Override
	public ItemStack displayBlock() {
		return new ItemStack(Block.getBlockFromName("grass"), 1, 0);
	}
	
	@Override
	public String[] blurbInfo() {
		return infoBlurb;
	}
	
	@Override
	public String[] fullInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean callback() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
