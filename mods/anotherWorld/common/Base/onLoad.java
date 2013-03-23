package mods.anotherWorld.common.Base;

import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.basicBlocks.BasicBlocks;
import mods.anotherWorld.common.basicBlocks.BasicBlocksCrafting;
import mods.anotherWorld.common.basicItems.BasicItems;
import mods.anotherWorld.common.basicItems.BasicItemsCrafting;
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
import mods.anotherWorld.common.spaceship.blocks.SpaceshipBlocks;
import mods.anotherWorld.common.spaceship.items.SpaceshipItems;
import mods.anotherWorld.common.spaceship.render.JetRender;
import mods.anotherWorld.common.spaceship.render.TileEntityJetRenderer;
import mods.anotherWorld.common.spaceship.tile.TileEntityJet;
import mods.anotherWorld.common.village.TradeHandlerVillagerAdvanced;





public class onLoad{
	public static void onLoading() {
		registerRenderers();
		registerTileEntities();
		
		BasicItems.addItems();
		BasicBlocks.addItems();
		Machines.addItems();
		MachineItems.addItems();
		SpaceshipBlocks.addItems();
		SpaceshipItems.addItems();
		VillagerInit();
		TyteonBiomes.init();
	}

	
	private static void registerRenderers() {
		RenderingRegistry.registerBlockHandler(GlobalIDs.SpaceChestRenderID, new SpaceChestRender());
		RenderingRegistry.registerBlockHandler(GlobalIDs.SeparatorRenderID, new SeparatorRender());
		RenderingRegistry.registerBlockHandler(GlobalIDs.SpaceCactusRenderID, new SpaceCactusRender());
		RenderingRegistry.registerBlockHandler(GlobalIDs.JetRenderID, new JetRender());
	}
	private static void registerTileEntities() {
		ClientRegistry.registerTileEntity(TileEntitySpaceChest.class, "tileSpaceBlock",  (TileEntitySpecialRenderer) new TileEntitySpaceChestRenderer());
		ClientRegistry.registerTileEntity(TileEntitySeparator.class, "tileSeperator",  (TileEntitySpecialRenderer) new TileEntitySeparatorRenderer());
		ClientRegistry.registerTileEntity(TileSpaceCactus.class, "tileSpaceCactus",  (TileEntitySpecialRenderer) new TileRenderSpaceCactus());	
		ClientRegistry.registerTileEntity(TileEntityJet.class, "tileJet",  (TileEntitySpecialRenderer) new TileEntityJetRenderer());
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
