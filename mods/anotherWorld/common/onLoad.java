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
import mods.anotherWorld.common.dimension.tyteonblocks.render.SpaceCactusRender;
import mods.anotherWorld.common.dimension.tyteonblocks.render.TileRenderSpaceCactus;
import mods.anotherWorld.common.dimension.tyteonblocks.render.TileSpaceCactus;
import mods.anotherWorld.common.machines.Machines;
import mods.anotherWorld.common.machines.MachinesCrafting;
import mods.anotherWorld.common.machines.items.MachineItems;
import mods.anotherWorld.common.machines.render.SeparatorRender;
import mods.anotherWorld.common.machines.render.SpaceChestRender;
import mods.anotherWorld.common.machines.render.TileEntitySeparatorRenderer;
import mods.anotherWorld.common.machines.render.TileEntitySpaceChestRenderer;
import mods.anotherWorld.common.machines.tile.TileEntitySeparator;
import mods.anotherWorld.common.machines.tile.TileEntitySpaceChest;
import mods.anotherWorld.common.village.TradeHandlerVillagerAdvanced;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;



public class onLoad{
	public static void onLoading() {

		
		
		RenderingRegistry.registerBlockHandler(80, new SpaceChestRender());
		RenderingRegistry.registerBlockHandler(81, new SeparatorRender());
		RenderingRegistry.registerBlockHandler(82, new SpaceCactusRender());
		
		ClientRegistry.registerTileEntity(TileEntitySpaceChest.class, "tileSpaceBlock",  (TileEntitySpecialRenderer) new TileEntitySpaceChestRenderer());
		ClientRegistry.registerTileEntity(TileEntitySeparator.class, "tileSeperator",  (TileEntitySpecialRenderer) new TileEntitySeparatorRenderer());
		ClientRegistry.registerTileEntity(TileSpaceCactus.class, "tileSpaceCactus",  (TileEntitySpecialRenderer) new TileRenderSpaceCactus());
		
		
		
		BasicItems.addItems();
		BasicBlocks.addItems();
		Machines.addItems();
		MachineItems.addItems();
		VillagerInit();
		TyteonBiomes.init();

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
