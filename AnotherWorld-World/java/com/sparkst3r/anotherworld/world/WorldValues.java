package com.sparkst3r.anotherworld.world;

import com.sparkst3r.anotherworld.world.blocks.BlockOre;
import com.sparkst3r.anotherworld.world.blocks.ItemBlockOre;
import com.sparkst3r.anotherworld.world.items.ItemIngot;
import com.sparkst3r.anotherworld.world.items.ItemTodolist;

import cpw.mods.fml.common.network.NetworkRegistry;


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
	public static final BlockOre blockOre = new BlockOre();
	
	/**
	 * World Expansion ingots.
	 * <p> Meta values are noted in ItemIngot.class </p>
	 * @see ItemIngot
	 */
	public static final ItemIngot itemIngot = new ItemIngot();
	
	/**
	 * Todolist item
	 * @see ItemTodolist
	 */
	public static final ItemTodolist itemTodoList = new ItemTodolist();
	
	/**
	 * World Expansion gui handler
	 */
	public static final GuiHandlerWorld WORLDGUI = new GuiHandlerWorld();
	
	/**
	 * Initialise world expansion features
	 */
	public static void initialise() {
		NetworkRegistry.INSTANCE.registerGuiHandler(AnotherWorldExpansionWorld.instance, WorldValues.WORLDGUI);
		WorldCrafting.addSmelting();
		BlockCrafting.initialise();
	}
}
