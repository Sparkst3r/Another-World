package mods.AnotherWorld.Mechanical;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.AnotherWorld.Mechanical.Blocks.*;
import net.minecraft.block.Block;

public class MechanicalValues {
	
	
	//Blocks
	public static Block BlockMechanicBlock;
	public static Block BlockMechTableParts;

	
	
	public static void initialise() {
		BlockMechanicBlock = new BlockMechanicBlock(710, "Mechanics Block", "blockMechanic");
		BlockMechTableParts = new BlockMechanicsTableParts(711);
		
		
	}

}
