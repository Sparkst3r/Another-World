package com.sparkst3r.anotherworld.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.sparkst3r.anotherworld.world.WorldValues;

import cpw.mods.fml.common.IWorldGenerator;

/**
 * WorldGenerator
 *
 * World expansion generator
 * 
 * TODO Make better way to generate ores case other expansion trees require other ores
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 14 Mar 2014
 */
public class WorldGenerator implements IWorldGenerator {

	/**
	 * Generate the world and populate the world with AnotherWorld ores
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		//chunkX/Z is the first block in the chunk, this calculates the whole chunk
		int chunkX16 = chunkX * 16;
		int chunkZ16 = chunkZ * 16;

		//If the world is not the end or the nether, Generate in this world.
		if (!(world.provider.dimensionId == -1) || !(world.provider.dimensionId == 1)) {
			//Generate Copper Ore
			generateCopper(random, chunkX16, chunkZ16, world, chunkProvider, chunkProvider);
			generateTin(random, chunkX16, chunkZ16, world, chunkProvider, chunkProvider);
			generateSilverAndLead(random, chunkX16, chunkZ16, world, chunkProvider, chunkProvider);
		}
	}

	/**
	 * 	Generate Copper Ore
	 * @param random Random generator instance
	 * @param chunkX16 X Chunk
	 * @param chunkZ16 Y Chunk
	 * @param world World instance
	 * @param chunkGenerator The chunk generator
	 * @param chunkProvider The chunk provider
	 */
	public void generateCopper(Random random, int chunkX16, int chunkZ16, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int block = 0; block < 11; block++) {
			int xCoord = chunkX16 + random.nextInt(16);
			int yCoord = random.nextInt(40);
			int zCoord = chunkZ16 + random.nextInt(16);
			new WorldGenMinable(WorldValues.blockOre, 0 , 6, Blocks.stone).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
	
	/**
	 * 	Generate Tin Ore
	 * @param random Random generator instance
	 * @param chunkX16 X Chunk
	 * @param chunkZ16 Y Chunk
	 * @param world World instance
	 * @param chunkGenerator The chunk generator
	 * @param chunkProvider The chunk provider
	 */
	public void generateTin(Random random, int chunkX16, int chunkZ16, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int block = 0; block < 9; block++) {
			int xCoord = chunkX16 + random.nextInt(16);
			int yCoord = random.nextInt(30);
			int zCoord = chunkZ16 + random.nextInt(16);
			new WorldGenMinable(WorldValues.blockOre, 1, 5, Blocks.stone).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
	/**
	 * Generates Silver and Lead Ore
	 * @param random Random generator instance
	 * @param chunkX16 X Chunk
	 * @param chunkZ16 Y Chunk
	 * @param world World instance
	 * @param chunkGenerator The chunk generator
	 * @param chunkProvider The chunk provider
	 */
	public void generateSilverAndLead(Random random, int chunkX16, int chunkZ16, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int block = 0; block < 7; block++) {
			int xCoord = chunkX16 + random.nextInt(16);
			int yCoord = random.nextInt(20);
			int zCoord = chunkZ16 + random.nextInt(16);
			int xCoordSilver = xCoord + (random.nextInt(2) - random.nextInt(4));
			int yCoordSilver = yCoord + (random.nextInt(2) - random.nextInt(4));
			int zCoordSilver = zCoord + (random.nextInt(2) - random.nextInt(4));
			new WorldGenMinable(WorldValues.blockOre, 3, 5, Blocks.stone).generate(world, random, xCoord, yCoord, zCoord);
			new WorldGenMinable(WorldValues.blockOre, 2, 3, Blocks.stone).generate(world, random, xCoordSilver, yCoordSilver, zCoordSilver);
		}
	}
	
	

}
