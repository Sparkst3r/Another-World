package mods.anotherWorld.common;

import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.basicItems.BasicItems;
import mods.anotherWorld.common.basicItems.ItemBlueprint;
import mods.anotherWorld.common.basicItems.ItemBlueprintPart;
import mods.anotherWorld.common.basicItems.ItemGlue;
import mods.anotherWorld.common.basicItems.ItemSalt;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import static mods.anotherWorld.common.basicBlocks.BasicBlocks.*;
import static mods.anotherWorld.common.basicItems.BasicItems.*;
import static mods.anotherWorld.common.machines.Machines.*;
public class Config {

	public static void doReadWrite(FMLPreInitializationEvent event) {

        
        AnotherWorld.configAW.load();
        
        //Tool Items
        ItemRaygunID =				AnotherWorld.configAW.get("Tools", ItemRaygunName, ItemRaygunID).getInt();
        
        //Player Items
        ItemForkkID =				AnotherWorld.configAW.get("Characters", ItemForkkName, ItemForkkID).getInt();
        ItemCadenDonutID =			AnotherWorld.configAW.get("Items", ItemCadenDonutName, ItemCadenDonutID).getInt();
        
        
        
        //Items
         ItemGlueID = 				AnotherWorld.configAW.get("Items", ItemGlueName, ItemGlueID).getInt();
         ItemBlueprintPartID = 		AnotherWorld.configAW.get("Items", ItemBlueprintPartName, ItemBlueprintPartID).getInt();
         ItemBlueprintID =		 	AnotherWorld.configAW.get("Items", ItemBlueprintName, ItemBlueprintID).getInt();
         ItemSiliconChipID =		AnotherWorld.configAW.get("Items", ItemSiliconChipName, ItemSiliconChipID).getInt();
         ItemLEDRedID =				AnotherWorld.configAW.get("Items", ItemLEDRedName, ItemLEDRedID).getInt();
         ItemLEDGreenID = 			AnotherWorld.configAW.get("Items", ItemLEDGreenName, ItemLEDGreenID).getInt();
         ItemLEDBlueID = 			AnotherWorld.configAW.get("Items", ItemLEDBlueName, ItemLEDBlueID).getInt();
         ItemSiliconSlagID = 		AnotherWorld.configAW.get("Items", ItemSiliconSlagName, ItemSiliconSlagID).getInt();
         ItemMetGradeSiliconID =	AnotherWorld.configAW.get("Items", ItemMetGradeSiliconName, ItemMetGradeSiliconID).getInt();
         ItemQuartzCrucibleID = 	AnotherWorld.configAW.get("Items", ItemQuartzCrucibleName, ItemQuartzCrucibleID).getInt();
         ItemSiliconBouleID =		AnotherWorld.configAW.get("Items", ItemSiliconBouleName, ItemSiliconBouleID).getInt();
         ItemSiliconSliceID =		AnotherWorld.configAW.get("Items", ItemSiliconSliceName, ItemSiliconSliceID).getInt();
         ItemSaltID = 				AnotherWorld.configAW.get("Items", ItemSaltName, ItemSaltID).getInt();
     
   
         
         
         
         
         
         
         AnotherWorld.configAW.save();
	}
}
