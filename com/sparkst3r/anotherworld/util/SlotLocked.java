package com.sparkst3r.anotherworld.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotLocked extends Slot {

	public SlotLocked(IInventory inventory, int slotIndex, int x, int y) {
		super(inventory, slotIndex, x, y);
	}
	
	
	public boolean canTakeStack(EntityPlayer player) {
		return false;
	}
	
}
