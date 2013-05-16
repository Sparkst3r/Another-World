package mods.anotherworld.world;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import mods.anotherworld.common.CommonProxy;
import mods.anotherworld.core.GlobalValues;
import mods.anotherworld.util.EntityUtils;
import mods.anotherworld.world.entity.EntityBee;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
		modid = GlobalValues.MODIDWORLD, 
		name = GlobalValues.MODNAMEWORLD, 
		version = GlobalValues.MODVERSION,
		dependencies = GlobalValues.DEPENDCORE 
		)


//NetworkMod annotation. Defines client/server requirement and the packet handler
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false)


public class AnotherWorldExpansionWorld {
	
	/** Sided proxy */
	@SidedProxy(
			clientSide="mods.anotherworld.client.ClientProxy",
			serverSide="mods.anotherworld.common.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(GlobalValues.MODIDWORLD)
	public static AnotherWorldExpansionWorld instance = new AnotherWorldExpansionWorld();
	
	//Called during the pre-load phase
	@PreInit
	public void PreLoad(FMLPreInitializationEvent event) {
		EntityRegistry.registerModEntity(EntityBee.class, "Bee", 0, this, 40, 3, true);
		EntityRegistry.addSpawn(EntityBee.class, 90, 1, 10, EnumCreatureType.monster, BiomeGenBase.desert);
		
		EntityUtils.registerEntityEgg(EntityBee.class, 0x000000, 0xFFFFFF);
    	
		WorldValues.initialise();
		GameRegistry.registerWorldGenerator(new WorldGenerator());
	}
    
	//Called during the loading phase
	@Init 
	public void load(FMLInitializationEvent event) {
	}
	
	//Called during the post-load phase
	@PostInit 
	public void PostLoad(FMLPostInitializationEvent event) {
	}
	
}
