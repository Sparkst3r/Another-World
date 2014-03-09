package com.sparkst3r.anotherworld.world;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.sparkst3r.anotherworld.core.AnotherWorld;
import com.sparkst3r.anotherworld.world.blocks.BlockOre;
import com.sparkst3r.anotherworld.world.blocks.ItemBlockOre;
import com.sparkst3r.anotherworld.world.items.ItemIngot;


/**
 * WorldValues
 *
 * World Expansion values
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 4 Mar 2014
 */
public class WorldValues {
	
	/**
	 * World Expansion ore blocks, includes storage blocks.
	 * <p> Meta values are noted in ItemBlockOre.class </p>
	 * @see ItemBlockOre
	 */
	public static final BlockOre BlockOreField = new BlockOre();
	
	/**
	 * World Expansion ingots.
	 * <p> Meta values are noted in ItemIngot.class </p>
	 * @see ItemIngot
	 */
	public static final ItemIngot ItemIngotField = new ItemIngot();
	
	/**
	 * Initialise world expansion features
	 */
	public static void initialise() {
		ItemCrafting.initialise();
		BlockCrafting.initialise();
	}
}
