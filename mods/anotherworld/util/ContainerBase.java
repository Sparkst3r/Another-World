package mods.anotherworld.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class ContainerBase extends Container {

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return false;
	}
	
	protected void bindPlayerInv(IInventory playerInv, int x, int y) { 
		/** The player's backpack inventory */
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 9; column++) {
				addSlotToContainer(new Slot(playerInv, column + (row * 9) + 9, x + (column * 18), y + (row * 18)));
			}
		}
        		
		/** The player's hotbar inventory */
		for(int column = 0; column < 9; column++) {
			addSlotToContainer(new Slot(playerInv, column, x + (column * 18), y + 58));
		}
	}
	
	protected void newInputMatrix(IInventory inv, int startSlot, int x, int y, int rows, int columns) {
		int slot = startSlot;
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				addSlotToContainer(new Slot(inv, slot, x + (column * 18), y + (row * 18)));
				slot++;
			}
		}
	}
	
}
