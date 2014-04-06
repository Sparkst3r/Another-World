package com.sparkst3r.anotherworld.world;

import com.sparkst3r.anotherworld.mechanical.container.TODOWIPContainerLogicSimple;
import com.sparkst3r.anotherworld.mechanical.container.ContainerMechanicsTable;
import com.sparkst3r.anotherworld.mechanical.gui.TODOWIPGuiLogicSimple;
import com.sparkst3r.anotherworld.mechanical.gui.GuiMechanicsTable;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileLogicSimple;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileMechanicsTable;
import com.sparkst3r.anotherworld.util.ItemStackUtils;
import com.sparkst3r.anotherworld.world.container.ContainerTodoList;
import com.sparkst3r.anotherworld.world.gui.GuiTodoList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
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
	
	/**
	 * Get client side gui element
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if (ID == TODOLIST) {
			System.out.println(ID);
			if (ItemStackUtils.areStacksOfSameType(player.getCurrentEquippedItem(), new ItemStack(WorldValues.itemTodoList))) {
				return new GuiTodoList(player, player.getCurrentEquippedItem());
			}
		}
		
		return null;
	}
	
	/**
	 * Get server side gui element
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == TODOLIST) {
			if (player.getCurrentEquippedItem().getUnlocalizedName().equals(WorldValues.itemTodoList.getUnlocalizedName())) {
				return new ContainerTodoList(player, player.getCurrentEquippedItem());
			}
		}
		return null;
	}
}
