package com.sparkst3r.anotherworld.mechanical;

import com.sparkst3r.anotherworld.mechanical.container.TODOWIPContainerLogicSimple;
import com.sparkst3r.anotherworld.mechanical.container.ContainerMechanicsTable;
import com.sparkst3r.anotherworld.mechanical.gui.TODOWIPGuiLogicSimple;
import com.sparkst3r.anotherworld.mechanical.gui.GuiMechanicsTable;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileLogicSimple;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileMechanicsTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

/**
 * GuiHandlerMechanical
 * 
 * GUI Handler for the mechanical expansion
 * 
 * @author Sparkst3r
 *
 */
public class GuiHandlerMechanical implements IGuiHandler {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity teMechTable;
			switch(ID){
				case 0: 
					teMechTable = world.getTileEntity(x, y, z);
					if (teMechTable != null) {
						return new GuiMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
					}
				case 1: 
					teMechTable = world.getTileEntity(x - 1, y, z);
					if (teMechTable != null) {
						return new GuiMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
					}
				case 2: 
					teMechTable = world.getTileEntity(x, y, z - 1);
					
					if (teMechTable != null) {
						return new GuiMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
					}
				case 3: 
					teMechTable = world.getTileEntity(x - 1, y, z - 1);
					if (teMechTable != null) {
						return new GuiMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
					}
				case 4:
					TileLogicSimple teLogicSimple = (TileLogicSimple) world.getTileEntity(x, y, z);
					if (teLogicSimple != null) {
						return new TODOWIPGuiLogicSimple(player.inventory, teLogicSimple);
					}
					
			}
			return null;
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity teMechTable;
		
		switch(ID){
			case 0: 
				teMechTable = world.getTileEntity(x, y, z);
				if (teMechTable != null) {
					return new ContainerMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
				}
			case 1: 
				teMechTable = world.getTileEntity(x - 1, y, z);
				if (teMechTable != null) {
					return new ContainerMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
				}
			case 2: 
				teMechTable = world.getTileEntity(x, y, z - 1);
				if (teMechTable != null) {
					return new ContainerMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
				}
			case 3: 
				teMechTable = world.getTileEntity(x - 1, y, z - 1);
				if (teMechTable != null) {
					return new ContainerMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
				}
			case 4:
				TileLogicSimple teLogicSimple = (TileLogicSimple) world.getTileEntity(x, y, z);
				if (teLogicSimple != null) {
					return new TODOWIPContainerLogicSimple(player.inventory, teLogicSimple);
				}
		}
		return null;
	}
}
