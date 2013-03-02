package anotherWorld.common;

import anotherWorld.common.basicItems.BasicItems;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import static anotherWorld.common.basicBlocks.BasicBlocks.*;
import static anotherWorld.common.basicItems.BasicItems.*;
public class Config {

	public static void doReadWrite(FMLPreInitializationEvent event) {

        
        AnotherWorld.configAW.load();
        //Blocks
        
        
        //Items
         ItemGlueID = AnotherWorld.configAW.get("Items", ItemGlueName, ItemGlueID).getInt();
         ItemBlueprintID = AnotherWorld.configAW.get("Items", ItemBlueprintName, ItemBlueprintID).getInt();
         ItemBlueprintPartID = AnotherWorld.configAW.get("Items", ItemBlueprintPartName, ItemBlueprintPartID).getInt();
         ItemRedLEDID = AnotherWorld.configAW.get("Items", ItemRedLEDName, ItemRedLEDID).getInt();
         ItemGreenLEDID = AnotherWorld.configAW.get("Items", ItemGreenLEDName, ItemGreenLEDID).getInt();
         ItemBlueLEDID = AnotherWorld.configAW.get("Items", ItemBlueLEDName, ItemBlueLEDID).getInt();
         ItemSiliconSlagID = AnotherWorld.configAW.get("Items", ItemSiliconSlagName, ItemSiliconSlagID).getInt();
         ItemMetGradeSiliconID = AnotherWorld.configAW.get("Items", ItemMetGradeSiliconName, ItemMetGradeSiliconID).getInt();
         ItemSiliconChipID = AnotherWorld.configAW.get("Items", ItemSiliconChipName, ItemSiliconChipID).getInt();
         
         //Blocks
         BlockEngineeringGlassID = AnotherWorld.configAW.get("Blocks", BlockEngineeringGlassName, BlockEngineeringGlassID).getInt();
         BlockTriCSFlowID = AnotherWorld.configAW.get("Blocks", BlockTriCSName, BlockTriCSFlowID).getInt();
         
         
         AnotherWorld.configAW.save();
	}
}
