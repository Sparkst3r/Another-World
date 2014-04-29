package com.sparkst3r.anotherworld.mechanical.blockinfo;

import com.sparkst3r.anotherworld.api.info.IStandardBlockInfoPage;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class StandardBlockInfoStone implements IStandardBlockInfoPage {
	String[] infoBlurb = new String[] {
			"Stone is the most common block found within the minecraft world",
			"Can be broken with a pickaxe of any material. And when broken",
			"will drop cobblestone."
	};
	
	String[] infoComplete = new String[] { 
			"Found in every biome and is scattered with ores throughout the",
			"Minecraft world.",
			"",
			"Technical info :",
			"	Block ID = '1'",
			"	Metadata = N/A",
			
	};
	
	@Override
	public ItemStack block() {
		return new ItemStack(Block.getBlockFromName("stone"), 1, 0);
	}
	
	@Override
	public ItemStack displayBlock() {
		return new ItemStack(Block.getBlockFromName("stone"), 1, 0);
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
