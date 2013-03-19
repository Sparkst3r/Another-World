package mods.anotherWorld.client;

import cpw.mods.fml.common.network.IGuiHandler;
import mods.anotherWorld.common.machines.container.ContainerSeparator;
import mods.anotherWorld.common.machines.container.ContainerSpaceChest;
import mods.anotherWorld.common.machines.gui.GUISeparator;
import mods.anotherWorld.common.machines.gui.GUISpaceChest;
import mods.anotherWorld.common.machines.tile.TileEntitySeparator;
import mods.anotherWorld.common.machines.tile.TileEntitySpaceChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		switch(id)
		{
		
		case 0: return new ContainerSeparator(player.inventory, (TileEntitySeparator) tile_entity);
		case 4: return new ContainerSpaceChest(player.inventory, (TileEntitySpaceChest) tile_entity);

		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
	TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
	
	switch(id)
	{
	case 0: return new GUISeparator(player.inventory, (TileEntitySeparator) tile_entity);
	case 4: return new GUISpaceChest(player.inventory, (TileEntitySpaceChest) tile_entity);

	}
	return null;
	}
}