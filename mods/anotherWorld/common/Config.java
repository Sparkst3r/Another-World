package mods.anotherWorld.common;

import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.basicItems.BasicItems;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import static mods.anotherWorld.common.basicBlocks.BasicBlocks.*;
import static mods.anotherWorld.common.basicItems.BasicItems.*;
import static mods.anotherWorld.common.machines.Machines.*;
public class Config {

	public static void doReadWrite(FMLPreInitializationEvent event) {

        
        AnotherWorld.configAW.load();
        //Blocks
        
        
        //Items
         ItemGlueID = AnotherWorld.configAW.get("Items", ItemGlueName, ItemGlueID).getInt();
         ItemBlueprintID = AnotherWorld.configAW.get("Items", ItemBlueprintName, ItemBlueprintID).getInt();
         ItemBlueprintPartID = AnotherWorld.configAW.get("Items", ItemBlueprintPartName, ItemBlueprintPartID).getInt();
         ItemLEDRedID = AnotherWorld.configAW.get("Items", ItemLEDRedName, ItemLEDRedID).getInt();
         ItemLEDGreenID = AnotherWorld.configAW.get("Items", ItemLEDGreenName, ItemLEDBlueID).getInt();
         ItemLEDBlueID = AnotherWorld.configAW.get("Items", ItemLEDBlueName, ItemLEDBlueID).getInt();
         ItemSiliconSlagID = AnotherWorld.configAW.get("Items", ItemSiliconSlagName, ItemSiliconSlagID).getInt();
         ItemMetGradeSiliconID = AnotherWorld.configAW.get("Items", ItemMetGradeSiliconName, ItemMetGradeSiliconID).getInt();
         ItemSiliconChipID = AnotherWorld.configAW.get("Items", ItemSiliconChipName, ItemSiliconChipID).getInt();
         
         //Blocks
         BlockEngineeringGlassID = AnotherWorld.configAW.get("Blocks", BlockEngineeringGlassName, BlockEngineeringGlassID).getInt();
         BlockTriCSFlowID = AnotherWorld.configAW.get("Blocks", "Trichlorosilane", BlockTriCSFlowID).getInt();
         
         
         AnotherWorld.configAW.save();
	}
}
