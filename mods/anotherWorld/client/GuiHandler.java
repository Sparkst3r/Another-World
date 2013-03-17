package mods.anotherWorld.client;

import cpw.mods.fml.common.network.IGuiHandler;
import mods.anotherWorld.common.machines.container.ContainerSeparator;
import mods.anotherWorld.common.machines.gui.GUISeparator;
import mods.anotherWorld.common.machines.tile.TileEntitySeparator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te instanceof TileEntitySeparator){
			return new ContainerSeparator(player.inventory, (TileEntitySeparator) te);
		}
	
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
		TileEntity te = world.getBlockTileEntity(x, y, z);

		if(te instanceof TileEntitySeparator){
			return new GUISeparator(player.inventory, (TileEntitySeparator) te);
		}
		return null;
	}
}