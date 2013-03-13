package anotherWorld.client;

import anotherWorld.common.machines.container.ContainerSeparator;
import anotherWorld.common.machines.gui.GUISeparator;
import anotherWorld.common.machines.tile.TileEntitySeparator;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{
	
@Override
public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
	
TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

if(tile_entity instanceof TileEntitySeparator){
	// If it is it returns a new ContainerTutorial instance
	return new ContainerSeparator(player.inventory, (TileEntitySeparator) tile_entity);
}

// Returns null if not
return null;
}

@Override
public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

if(tile_entity instanceof TileEntitySeparator){
	return new GUISeparator(player.inventory, (TileEntitySeparator) tile_entity);
}

// Returns null if not
return null;
}
}