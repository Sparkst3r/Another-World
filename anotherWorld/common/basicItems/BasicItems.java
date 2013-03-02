package anotherWorld.common.basicItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BasicItems {
	
	//Glue
	public static Item Glue;
	public static String ItemGlueName = "Glue";
	public static int ItemGlueID = 8001;
	//Blueprint
	public static Item Blueprint;
	public static String ItemBlueprintName = "Blueprint";
	public static int ItemBlueprintID = 8002;
	//Blueprint Part
	public static Item BlueprintPart;
	public static String ItemBlueprintPartName = "Blueprint Part";
	public static int ItemBlueprintPartID = 8003;
	//Red LED
	public static Item RedLED;
	public static String ItemRedLEDName = "Red LED";
	public static int ItemRedLEDID = 8004;
	//Green LED
	public static Item GreenLED;
	public static String ItemGreenLEDName = "Green LED";
	public static int ItemGreenLEDID = 8005;
	//Blue LED
	public static Item BlueLED;
	public static String ItemBlueLEDName = "Blue LED";
	public static int ItemBlueLEDID = 8006;
	//Silicon Slag
	public static Item SiliconSlag;
	public static String ItemSiliconSlagName = "Silicon Slag";
	public static int ItemSiliconSlagID = 8007;
	//Met Grade Silicon
	public static Item MetGradeSilicon;
	public static String ItemMetGradeSiliconName = "Metallurgical silicon";
	public static int ItemMetGradeSiliconID = 8008;
	//Silicon Chip
	public static Item SiliconChip;
	public static String ItemSiliconChipName = "Silicon Chip";
	public static int ItemSiliconChipID = 8009;
	
	
	public static void addItems() {
		Glue = new ItemGlue(ItemGlueID);
		BlueprintPart = new ItemBlueprintPart(ItemBlueprintPartID);
		Blueprint = new ItemBlueprint(ItemBlueprintID);
		SiliconChip = new ItemSiliconChip(ItemSiliconChipID);
		RedLED = new ItemRedLED(ItemRedLEDID);
		GreenLED = new ItemGreenLED(ItemGreenLEDID);
		BlueLED = new ItemBlueLED(ItemBlueLEDID);
		SiliconSlag = new ItemSiliconSlag(ItemSiliconSlagID);
		MetGradeSilicon = new ItemMetGradeSilicon(ItemMetGradeSiliconID);
	}
	
}
