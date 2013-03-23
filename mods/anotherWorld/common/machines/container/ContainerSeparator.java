package mods.anotherWorld.common.machines.container;

import mods.anotherWorld.common.machines.tile.TileEntitySeparator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerSeparator extends Container {
		private static int slots = 7;
        protected TileEntitySeparator tileEntity;

        public ContainerSeparator (InventoryPlayer inventoryPlayer, TileEntitySeparator te){
                tileEntity = te;

                //Slot number in the container. Starts at zero as this is the first set of slots to add.
                int atSlot = 0;
                //Add input buffer slots.
                for (int xPos = 0; xPos < 2; xPos++) {
                	for (int yPos= 0; yPos < 3; yPos++) {
                		atSlot += 1;
                        addSlotToContainer(new Slot(tileEntity, atSlot, 12 + (18 * xPos), 17 + (18 * yPos)));
                	}
 
                }
                
                //Input slot
                addSlotToContainer(new Slot(tileEntity, 7, 58, 35));
                
                //Add the player's inventory
                bindPlayerInventory(inventoryPlayer);
        }

        //Can the player open this container?
        @Override
        public boolean canInteractWith(EntityPlayer player) {
                return tileEntity.isUseableByPlayer(player);
        }

        //Vanilla method to add player's inventory
        protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 9; j++) {
                                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                                8 + j * 18, 84 + i * 18));
                        }
                }

                for (int i = 0; i < 9; i++) {
                        addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
                }
        }

        public void detectAndSendChanges() {
        	bufferInput();
        }
        
        
        //Handle shift clicking of ItemStack
        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int slot)
        {
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

        public void bufferInput() {

        	}
}