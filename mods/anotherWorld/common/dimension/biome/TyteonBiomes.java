package mods.anotherWorld.common.dimension.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class TyteonBiomes {
	public static BiomeGenBase biomeIrradiated;
	public static BiomeGenBase biomeGlubber;
	
	
	public static void init() {
		TyteonBiomes.biomeIrradiated = new TyteonBiomeIrradiated(100);
		TyteonBiomes.biomeGlubber = new TyteonBiomeGlubber(101);
	}
}
