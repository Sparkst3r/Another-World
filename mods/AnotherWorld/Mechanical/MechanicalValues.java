package mods.AnotherWorld.Mechanical;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.AnotherWorld.Mechanical.Blocks.*;
import mods.AnotherWorld.Mechanical.Items.ItemTool;
import mods.AnotherWorld.Util.RegistryUtils;
import mods.AnotherWorld.World.Items.ItemIngot;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class MechanicalValues {
	
	
	//Blocks
	public static Block BlockMechanicBlockField;
	public static Block BlockMechTablePartsField;

	public static Item ItemToolField;
	
	public static void initialise() {
		BlockMechanicBlockField = new BlockMechanicBlock(710, "Mechanics Block", "blockMechanic");
		BlockMechTablePartsField = new BlockMechanicsTableParts(711);
		
		ItemToolField = new ItemTool(5001);
		
		addInfoForMeta();
		ItemCrafting.initialise();
	}
	
	public static void addInfoForMeta() {
		//Tool
		for (int meta = 0; meta < 5; meta++) {
			RegistryUtils.addName(ItemToolField, meta, ItemTool.names[meta]);
		}
	}

}
