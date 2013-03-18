package mods.anotherWorld.common;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.client.ClientProxy;
import mods.anotherWorld.common.basicBlocks.BasicBlocks;
import mods.anotherWorld.common.basicBlocks.BasicBlocksCrafting;
import mods.anotherWorld.common.basicItems.BasicItems;
import mods.anotherWorld.common.basicItems.BasicItemsCrafting;
import mods.anotherWorld.common.dimension.biome.TyteonBiomeIrradiated;
import mods.anotherWorld.common.dimension.biome.TyteonBiomes;
import mods.anotherWorld.common.machines.Machines;
import mods.anotherWorld.common.machines.MachinesCrafting;
import mods.anotherWorld.common.machines.items.MachineItems;
import mods.anotherWorld.common.machines.tile.TileEntitySeparator;
import mods.anotherWorld.common.machines.tile.TileEntitySpaceChest;
import mods.anotherWorld.common.machines.tile.TileEntitySpaceChestRenderer;
import mods.anotherWorld.common.village.TradeHandlerVillagerAdvanced;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;



public class onLoad{
	public static void onLoading() {

		BasicItems.addItems();
		BasicBlocks.addItems();
		Machines.addItems();
		MachineItems.addItems();
		VillagerInit();
		TyteonBiomes.init();
		ClientRegistry.registerTileEntity(TileEntitySpaceChest.class, "tile blach",  (TileEntitySpecialRenderer) new TileEntitySpaceChestRenderer());
		GameRegistry.registerTileEntity(TileEntitySeparator.class, "tileEntitySeparator");
        //AnotherWorld.proxy.registerTileEntitySpecialRenderer();
	}

	private static void VillagerInit() {
	      VillagerRegistry reg = VillagerRegistry.instance();
	      TradeHandlerVillagerAdvanced handler = new TradeHandlerVillagerAdvanced();
	      reg.registerVillageTradeHandler(50, handler);
	      VillagerRegistry.instance().registerVillagerType(50, AnotherWorld.guiDir + "advanced.png");
		
	}

	public static void onPostLoad() { 
		    BasicItemsCrafting.crafting();
		    BasicBlocksCrafting.crafting();
		    MachinesCrafting.crafting();
		    //Debug Output
			//ItemRegistry.printItemNames();
	}

}
