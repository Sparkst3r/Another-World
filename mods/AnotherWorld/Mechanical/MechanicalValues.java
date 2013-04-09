package mods.AnotherWorld.Mechanical;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.AnotherWorld.Core.AnotherWorld;
import mods.AnotherWorld.Mechanical.Blocks.*;
import mods.AnotherWorld.Mechanical.Items.ItemBaseParts;
import mods.AnotherWorld.Mechanical.Items.ItemTool;
import mods.AnotherWorld.Util.RegistryUtils;
import mods.AnotherWorld.World.Items.ItemIngot;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class MechanicalValues {
	
	
	//Blocks
	public static Block BlockMechTablePartsField;
	public static Block BlockBasePartsField;
	
	public static Item ItemToolField;
	public static Item ItemBasePartsField;

	
	public static void initialise() {
		BlockBasePartsField = new BlockBaseParts(712);
		BlockMechTablePartsField = new BlockMechanicsTableParts(711);

		
		ItemToolField = new ItemTool(5001);
		ItemBasePartsField = new ItemBaseParts(5002);
		addInfoForMeta();
		ItemCrafting.initialise();
		AnotherWorld.proxy.registerRenders();
	}
	
	public static void addInfoForMeta() {
		//Tool
		for (int meta = 0; meta < 5; meta++) {
			RegistryUtils.addName(ItemToolField, meta, ItemTool.names[meta]);
		}
		for (int meta = 0; meta < 1; meta++) {
			RegistryUtils.addName(ItemBasePartsField, meta, ItemBaseParts.names[meta]);
		}
	}

}
