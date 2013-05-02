package mods.anotherworld.mechanical.container;

import mods.anotherworld.mechanical.tileentity.TileLogicSimple;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerLogicSimple extends Container {
	
	public ContainerLogicSimple (InventoryPlayer inventoryPlayer, TileLogicSimple te){
		
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	
}
