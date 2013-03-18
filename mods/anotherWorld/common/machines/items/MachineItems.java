package mods.anotherWorld.common.machines.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MachineItems {
	
	//Glue
	public static Item BismuthDrill;
	public static String ItemBismuthDrillName = "Bismuth Drill";
	public static int ItemBismuthDrillID = 8001;
	
	public static void addItems() {
		BismuthDrill = new ItemBismuthDrill(ItemBismuthDrillID, "bismuthDrill");
	}
	
}
