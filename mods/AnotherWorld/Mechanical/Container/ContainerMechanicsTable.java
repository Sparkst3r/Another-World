package mods.AnotherWorld.Mechanical.Container;


import mods.AnotherWorld.Mechanical.TileEntity.TileMechanicsTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerMechanicsTable extends Container {
		private static int slots = 43;
        private TileMechanicsTable tileEntity;

        public ContainerMechanicsTable (InventoryPlayer inventoryPlayer, TileMechanicsTable te){
                tileEntity = te;
                
                int atSlot = 0;
                //Add input buffer slots.
                for (int xPos = 0; xPos < 2; xPos++) {
                	for (int yPos= 0; yPos < 3; yPos++) {
                		atSlot += 1;
                        addSlotToContainer(new Slot(tileEntity, atSlot, 12 + (18 * xPos), 17 + (18 * yPos)));
                	}
 
                }
                
                
        		//The player's backpack inventory
        		for(int row = 0; row < 3; row++) {
        			for(int column = 0; column < 9; column++) {
        				addSlotToContainer(new Slot(inventoryPlayer, column + row * 9 + 9, 8 + column * 18, 84 + (row * 18)));
        				}
        			}
        		/*
        		//The player's hotbar inventory
        		for(int column = 0; column < 9; column++) {
        			addSlotToContainer(new Slot(inventoryPlayer, column, 6 + column * 18, 20 + 58));
        			}
        			*/
        }
        

        //Can the player open this container?
        @Override
        public boolean canInteractWith(EntityPlayer player) {
                return true;
        }

        //Handle shift clicking of ItemStack
        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
             ItemStack stack = null;
             Slot slotObject = (Slot) inventorySlots.get(slot);

             //null checks and checks if the item can be stacked (maxStackSize > 1)
             if (slotObject != null && slotObject.getHasStack())
             {
                 ItemStack stackInSlot = slotObject.getStack();
                 stack = stackInSlot.copy();

                 //merges the item into player inventory since its in the tileEntity
                 if (slot < slots)
                 {
                     if (!this.mergeItemStack(stackInSlot, slots, 41, true))
                     {
                         return null;
                     }
                 }
                 //places it into the tileEntity is possible since its in the player inventory
                 else if (!this.mergeItemStack(stackInSlot, 0, slots, false))
                 {
                 return null;
                 }

                 if (stackInSlot.stackSize == 0)
                 {
                     slotObject.putStack(null);
                 }
                 else
                 {
                     slotObject.onSlotChanged();
                 }

                 if (stackInSlot.stackSize == stack.stackSize)
                 {
                     return null;
                 }
                 slotObject.onPickupFromSlot(player, stackInSlot);
             }
             return stack;
        }

}