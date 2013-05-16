package mods.anotherworld.mechanical.container;

import mods.anotherworld.mechanical.tileentity.TileLogicSimple;
import mods.anotherworld.util.ContainerBase;
import mods.anotherworld.util.SlotLocked;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerLogicSimple extends ContainerBase {
	
	private TileLogicSimple tile;


	public ContainerLogicSimple (InventoryPlayer inventoryPlayer, TileLogicSimple te){
		this.tile = te;
		this.bindPlayerInv(inventoryPlayer, 6, 86);
		this.addSlotToContainer(new SlotLocked(tile, 0, 0, 0));
		this.addSlotToContainer(new SlotLocked(tile, 1, 20, 0));
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}
	
}
