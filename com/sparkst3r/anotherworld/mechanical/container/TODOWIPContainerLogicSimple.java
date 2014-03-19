package com.sparkst3r.anotherworld.mechanical.container;

import com.sparkst3r.anotherworld.mechanical.tileentity.TileLogicSimple;
import com.sparkst3r.anotherworld.util.ContainerBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class TODOWIPContainerLogicSimple extends ContainerBase {
	
	private TileLogicSimple tile;


	public TODOWIPContainerLogicSimple (InventoryPlayer inventoryPlayer, TileLogicSimple te){
		this.tile = te;
		this.bindPlayerInv(inventoryPlayer, 6, 86);
		//this.addSlotToContainer(new SlotLocked(tile, 0, 0, 0));
		//this.addSlotToContainer(new SlotLocked(tile, 1, 20, 0));
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	
}
