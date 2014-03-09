package com.sparkst3r.anotherworld.util;

import net.minecraft.block.Block;

public class MetaSensitiveBlock {
	
	private Block block;
	private int metadata;

	public MetaSensitiveBlock(Block block, int metadata) {
		this.block = block;
		this.metadata = metadata;
	}
	
	@Override
	public boolean equals(Object object) {

		if (object instanceof MetaSensitiveBlock) {
			MetaSensitiveBlock metaBlock = (MetaSensitiveBlock) object;
			if (this.block.getUnlocalizedName().equals(metaBlock.block.getUnlocalizedName()) && this.metadata == metaBlock.metadata) {
				return true;
			}
			
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return metadata * block.getUnlocalizedName().length() + block.getUnlocalizedName().length();
	}
	
}
