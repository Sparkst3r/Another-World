package anotherWorld.common.basicBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BasicBlocks {
	public static int BlockEngineeringGlassID = 3000;
	
	public static Block EngineeringGlass;
	
	public static void addItems() {
		EngineeringGlass = new BlockEngineeringGlass(BlockEngineeringGlassID, 0, Material.glass);
	}
	
}
