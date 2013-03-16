package anotherWorld.common.basicBlocks;

import net.minecraft.block.material.Material;

public class BlockSaltOre extends Ore{

	public BlockSaltOre(int id, String name, int idInTexture, Material mat) {
		super(id, name, 8, null);
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
		
	}

}
