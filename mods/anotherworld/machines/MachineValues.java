package mods.anotherworld.machines;

import mods.anotherworld.machines.items.ItemBaseParts;
import mods.anotherworld.util.RegistryUtils;
import net.minecraft.item.Item;




public class MachineValues {
	public static Item ItemBasePartsField;
	
	
	public static void initialise() {
		ItemBasePartsField = new ItemBaseParts(5007);
		addInfoForMeta();
	}
	
	public static void addInfoForMeta() {
		for (int meta = 0; meta < ItemBaseParts.types.length; meta++) {
			RegistryUtils.addName(ItemBasePartsField, meta, ItemBaseParts.names[meta]);
		}
	}



}
