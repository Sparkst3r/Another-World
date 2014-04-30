package com.sparkst3r.anotherworld.world;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.sparkst3r.anotherworld.util.ItemStackUtils;
import com.sparkst3r.anotherworld.world.container.ContainerBackpackContents;
import com.sparkst3r.anotherworld.world.container.ContainerTodoList;
import com.sparkst3r.anotherworld.world.gui.GuiBackpackContents;
import com.sparkst3r.anotherworld.world.gui.GuiTodoList;

import cpw.mods.fml.common.network.IGuiHandler;

/**
 * GuiHandlerWorld
 * 
 * Gui handler for World
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 5 Apr 2014
 */
public class GuiHandlerWorld implements IGuiHandler {

	/** TodoList gui id */
	public static final int TODOLIST = 0;
	
	/** Backpack contents id */
	public static final int BACKPACK = 1;
	
	/** Backpack upgrade id */
	public static final int BACKPACKUPG = 2;
	
	
	
	/**
	 * Get client side gui element
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		switch(ID) {
			case TODOLIST: {
				if (ItemStackUtils.areStacksOfSameType(player.getCurrentEquippedItem(), new ItemStack(WorldValues.itemTodoList))) {
					return new GuiTodoList(player, player.getCurrentEquippedItem());
				}
				break;
			}
			
			case BACKPACK: {
				if(player.inventory.hasItem(WorldValues.itemBackpack)) {
					for(ItemStack stack : player.inventory.mainInventory) {
						if (stack != null && stack.getItem() == WorldValues.itemBackpack) {
							return new GuiBackpackContents(player, stack);
						}
					}
				}
				
			}
		
		}
		
		return null;
	}
	
	/**
	 * Get server side gui element
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
			case TODOLIST: {
				if (ItemStackUtils.areStacksOfSameType(player.getCurrentEquippedItem(), new ItemStack(WorldValues.itemTodoList))) {
					return new ContainerTodoList(player, player.getCurrentEquippedItem());
				}
				break;
			}
			
			case BACKPACK: {
				if(player.inventory.hasItem(WorldValues.itemBackpack)) {
					for(ItemStack stack : player.inventory.mainInventory) {
						if (stack != null && stack.getItem() == WorldValues.itemBackpack) {
							return new ContainerBackpackContents(player, stack);
						}
					}
				}
			}
		
		}
		return null;
	}
}
