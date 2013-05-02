package mods.anotherworld.mechanical;

import mods.anotherworld.mechanical.container.ContainerLogicSimple;
import mods.anotherworld.mechanical.container.ContainerMechanicsTable;
import mods.anotherworld.mechanical.gui.GuiLogicSimple;
import mods.anotherworld.mechanical.gui.GuiMechanicsTable;
import mods.anotherworld.mechanical.tileentity.TileLogicSimple;
import mods.anotherworld.mechanical.tileentity.TileMechanicsTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

/**
 * GUI Handler for the mechanical expansion
 * @author Sparkst3r
 *
 */
public class GuiHandlerMechanical implements IGuiHandler{

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity teMechTable;
			switch(ID){
				case 0: 
					teMechTable = world.getBlockTileEntity(x, y, z);
					if (teMechTable != null) {
						return new GuiMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
					}
				case 1: 
					teMechTable = world.getBlockTileEntity(x - 1, y, z);
					if (teMechTable != null) {
						return new GuiMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
					}
				case 2: 
					teMechTable = world.getBlockTileEntity(x, y, z - 1);
					
					if (teMechTable != null) {
						return new GuiMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
					}
				case 3: 
					teMechTable = world.getBlockTileEntity(x - 1, y, z - 1);
					if (teMechTable != null) {
						return new GuiMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
					}
				case 4:
					TileLogicSimple teLogicSimple = (TileLogicSimple) world.getBlockTileEntity(x, y, z);
					if (teLogicSimple != null) {
						return new GuiLogicSimple(player.inventory, teLogicSimple);
					}
					
			}
			return null;
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity teMechTable;
		
		switch(ID){
			case 0: 
				teMechTable = world.getBlockTileEntity(x, y, z);
				if (teMechTable != null) {
					return new ContainerMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
				}
			case 1: 
				teMechTable = world.getBlockTileEntity(x - 1, y, z);
				if (teMechTable != null) {
					return new ContainerMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
				}
			case 2: 
				teMechTable = world.getBlockTileEntity(x, y, z - 1);
				if (teMechTable != null) {
					return new ContainerMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
				}
			case 3: 
				teMechTable = world.getBlockTileEntity(x - 1, y, z - 1);
				if (teMechTable != null) {
					return new ContainerMechanicsTable(player.inventory, (TileMechanicsTable) teMechTable);
				}
			case 4:
				TileLogicSimple teLogicSimple = (TileLogicSimple) world.getBlockTileEntity(x, y, z);
				if (teLogicSimple != null) {
					return new ContainerLogicSimple(player.inventory, teLogicSimple);
				}
		}
		return null;
	}
}
