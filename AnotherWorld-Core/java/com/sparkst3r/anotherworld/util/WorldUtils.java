package com.sparkst3r.anotherworld.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

/**
 * Some simple methods for world functions. Just shortcuts for less code.
 * @author Sparkst3r
 *
 */
public class WorldUtils {
	
	/**
	 * Returns if the block at the (x,y,z) is a block(Metadata in-sensitive)
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param block
	 * @return Is the block at (x,y,z) the block specified.
	 */
	public static boolean isBlockAt(World world, int x, int y, int z, Block block) {
		if (world.getBlock(x, y, z).equals(block)) {
			return true;
		}
		return false;
	}
	/**
	 * Returns if the block at the (x,y,z) is a block(Metadata sensitive)
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param block
	 * @param meta
	 * @return Is the block at (x,y,z) the block specified.
	 */
	public static boolean isBlockAt(World world, int x, int y, int z, Block block, int meta) {
		if (world.getBlock(x, y, z).equals(block) && world.getBlockMetadata(x, y, z) == meta) {
			return true;
		}
		return false;
	}
	
	/**
	 * Set block in world with BUD, meta in-sensitive. Returns if it was successful
	 * @param world
	 * @param x X position to set
	 * @param y Y position to set
	 * @param z Z position to set
	 * @param block Block to set to
	 * @param valid Will check if block is air before setting
	 * @return success Returns true if this was successful
	 */
	public static boolean setBlockAt(World world, int x, int y, int z, Block block, boolean valid) {
		if(valid) {
			if(world.getBlock(x, y, z).equals(Block.getBlockFromName("air"))){
				world.setBlock(x, y, z, block, 0, 2);
				if (isBlockAt(world, x, y, z, block)){
					return true;
				}
			}
		}
		else {
			world.setBlock(x, y, z, block, 0, 2);
			if (isBlockAt(world, x, y, z, block)){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Set block in world with BUD, meta sensitive. Returns if it was successful
	 * @param world
	 * @param x X position to set
	 * @param y Y position to set
	 * @param z Z position to set
	 * @param block Block to set to
	 * @param meta The block's metadata
	 * @param valid Will check if block is air before setting
	 * @return Returns true if this was successful
	 */
	public static boolean setBlockAt(World world, int x, int y, int z, Block block, int meta, boolean valid) {
		if(valid) {
			if(world.getBlock(x, y, z).equals(Block.getBlockFromName("air"))){
				world.setBlock(x, y, z, block, meta, 2);
				if (isBlockAt(world, x, y, z, block, meta)){
					return true;
				}
			}
		}
		else {
			world.setBlock(x, y, z, block, meta, 2);
			if (isBlockAt(world, x, y, z, block, meta)){
				return true;
				}
		}
		
		return false;
	}
	
	/**
	 * Cleaner looking way to get entities in an AABB
	 * 
	 * @param world World
	 * @param minX MinX
	 * @param minY MinY
	 * @param minZ MinZ
	 * @param maxX MaxX
	 * @param maxY MaxY
	 * @param maxZ MaxZ
	 * @return items
	 */
	@SuppressWarnings("unchecked")
	public static List<EntityItem> getItemsInAABB(World world, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
		return world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(minX, minY, minZ, maxX, maxY, maxZ));
	}
	
	/**
	 * @param world
	 * @return is client side
	 */
	public static boolean isServerSide(World world) {
		return !world.isRemote;
	}
	
	/**
	 * @param world
	 * @return is client side
	 */
	public static boolean isClientSide(World world) {
		return world.isRemote;
	}
	
}
