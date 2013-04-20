package mods.anotherworld.util;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockCoord {
	public int x;
	public int y;
	public int z;


	public BlockCoord(World world, int x, int y, int z, Block block, int meta) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
}
