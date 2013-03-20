package mods.anotherWorld.common.basicItems;

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
	public static Item LEDRed;
	public static String ItemLEDRedName = "Red LED";
	public static int ItemLEDRedID = 8004;
	//Green LED
	public static Item LEDGreen;
	public static String ItemLEDGreenName = "Green LED";
	public static int ItemLEDGreenID = 8005;
	//Blue LED
	public static Item LEDBlue;
	public static String ItemLEDBlueName = "Blue LED";
	public static int ItemLEDBlueID = 8006;
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
	
	//Quartz Crucible
	public static Item QuartzCrucible;
	public static String ItemQuartzCrucibleName = "Quartz Crucible";
	public static int ItemQuartzCrucibleID = 8010;
		
	//Silicon Boule
	public static Item SiliconBoule;
	public static String ItemSiliconBouleName = "Silicon Boule";
	public static int ItemSiliconBouleID = 8011;
	
	//Silicon Slice
	public static Item SiliconSlice;
	public static String ItemSiliconSliceName = "Silicon Wafer";
	public static int ItemSiliconSliceID = 8012;
	
	//Lol CadenDonuts
	public static Item CadenDonut;
	public static String ItemCadenDonutName = "Caden Donut";
	public static int ItemCadenDonutID = 8013;
	
	//Lol Forkk
	public static Item Forkk;
	public static String ItemForkkName = "Forkk13";
	public static int ItemForkkID = 8015;
	
	//Salt
	public static Item Salt;
	public static String ItemSaltName = "Salt Pile";
	public static int ItemSaltID = 8014;
	
	public static Item Raygun;
	public static String ItemRaygunName = "Ronald Raygun";
	public static int ItemRaygunID = 8014;
	
	public static void addItems() {
		Glue = new ItemGlue(ItemGlueID, "glue");
		BlueprintPart = new ItemBlueprintPart(ItemBlueprintPartID, "blueprintPart");
		Blueprint = new ItemBlueprint(ItemBlueprintID, "blueprint");
		SiliconChip = new ItemSiliconChip(ItemSiliconChipID, "chip");
		LEDRed = new ItemLEDRed(ItemLEDRedID, "ledRed");
		LEDGreen = new ItemLEDGreen(ItemLEDGreenID, "ledGreen");
		LEDBlue = new ItemLEDBlue(ItemLEDBlueID, "ledBlue");
		SiliconSlag = new ItemSiliconSlag(ItemSiliconSlagID, "siliconSlag");
		MetGradeSilicon = new ItemMetGradeSilicon(ItemMetGradeSiliconID, "siliconMet");
		QuartzCrucible = new ItemQuartzCrucible(ItemQuartzCrucibleID, "crucibleQuartz");
		SiliconBoule = new ItemSiliconBoule(ItemSiliconBouleID, "siliconBoule");
		SiliconSlice = new ItemSiliconSlice(ItemSiliconSliceID, "siliconSlice");
		CadenDonut = new ItemCadenDonut(ItemCadenDonutID, "cadenDonut");
		Salt = new ItemSalt(ItemSaltID, "saltDust");
		Forkk = new ItemForkk(ItemForkkID, "forkk");
		//Raygun = new ItemForkk(ItemRaygunID, "raygun");
	}
	
}
