package anotherWorld.common.basicItems;

import net.minecraft.item.Item;

public class BasicItems {
	public static int ItemGlueID = 8001;
	public static int ItemBlueprintID = 8002;
	public static int ItemBlueprintPartID = 8003;
	public static int ItemSiliconChipID = 8004;
	public static int ItemRedLEDID = 8005;
	public static int ItemSiliconSlagID = 8006;
	
	
	public static Item Glue;
	public static Item Blueprint;
	public static Item BlueprintPart;
	public static Item SiliconChip;
	public static Item RedLED;
	public static Item SiliconSlag;
	
	public static void addItems() {
		Glue = new ItemGlue(ItemGlueID);
		BlueprintPart = new ItemBlueprintPart(ItemBlueprintPartID);
		Blueprint = new ItemBlueprint(ItemBlueprintID);
		SiliconChip = new ItemSiliconChip(ItemSiliconChipID);
		RedLED = new ItemRedLED(ItemRedLEDID);
		SiliconSlag = new ItemSiliconSlag(ItemSiliconSlagID);
	}
	
}
