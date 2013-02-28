package anotherWorld.common.basicItems;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BasicItems {
	public static int ItemGlueID = 8001;
	public static int ItemBlueprintID = 8002;
	public static int ItemBlueprintPartID = 8003;
	public static int ItemSiliconChipID = 8004;
	public static int ItemSiliconSlagID = 8005;
	public static int ItemRedLEDID = 8006;
	public static int ItemGreenLEDID = 8007;
	public static int ItemBlueLEDID = 8008;
	public static int ItemMetGradeSiliconID = 8009;
	
	
	public static Item Glue;
	public static Item Blueprint;
	public static Item BlueprintPart;
	public static Item SiliconChip;
	public static Item RedLED;
	public static Item GreenLED;
	public static Item BlueLED;
	public static Item SiliconSlag;
	public static Item MetGradeSilicon;
	
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
