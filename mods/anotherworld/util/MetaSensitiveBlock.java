package mods.anotherworld.util;

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
			if (this.block.blockID == metaBlock.block.blockID && this.metadata == metaBlock.metadata) {
				System.out.println("Meoweaw");
				return true;
			}
			
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return metadata * block.blockID + block.blockID;
	}
	
}
