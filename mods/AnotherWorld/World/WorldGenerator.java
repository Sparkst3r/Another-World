package mods.AnotherWorld.World;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * World Generation. Generates Copper, Tin, Silver and Lead
 * 
 * @author Sparkst3r
 *
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
	 * 
	 */
	public void generateCopper(Random random, int chunkX16, int chunkZ16, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int block = 0; block < 11; block++) {
			int xCoord = chunkX16 + random.nextInt(16);
			int yCoord = random.nextInt(40);
			int zCoord = chunkZ16 + random.nextInt(16);
			new WorldGenMinable(WorldValues.BlockOreField.blockID, 0 , 6, Block.stone.blockID).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
	
	/**
	 * 	Generate Tin Ore
	 * 
	 */
	public void generateTin(Random random, int chunkX16, int chunkZ16, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int block = 0; block < 9; block++) {
			int xCoord = chunkX16 + random.nextInt(16);
			int yCoord = random.nextInt(30);
			int zCoord = chunkZ16 + random.nextInt(16);
			new WorldGenMinable(WorldValues.BlockOreField.blockID, 1, 5, Block.stone.blockID).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
	/**
	 * Generates Silver and Lead Ore
	 * 
	 */
	public void generateSilverAndLead(Random random, int chunkX16, int chunkZ16, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int block = 0; block < 7; block++) {
			int xCoord = chunkX16 + random.nextInt(16);
			int yCoord = random.nextInt(20);
			int zCoord = chunkZ16 + random.nextInt(16);
			int xCoordSilver = xCoord + (random.nextInt(2) - random.nextInt(4));
			int yCoordSilver = yCoord + (random.nextInt(2) - random.nextInt(4));
			int zCoordSilver = zCoord + (random.nextInt(2) - random.nextInt(4));
			new WorldGenMinable(WorldValues.BlockOreField.blockID, 3, 5, Block.stone.blockID).generate(world, random, xCoord, yCoord, zCoord);
			new WorldGenMinable(WorldValues.BlockOreField.blockID, 2, 3, Block.stone.blockID).generate(world, random, xCoordSilver, yCoordSilver, zCoordSilver);
		}
	}
	
	

}
