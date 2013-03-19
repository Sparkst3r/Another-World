package mods.anotherWorld.common.machines.container;

import mods.anotherWorld.common.machines.tile.TileEntitySeparator;
import mods.anotherWorld.common.machines.tile.TileEntitySpaceChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerSpaceChest extends Container {
		private static int slots = 18;
        protected TileEntitySpaceChest tileEntity;

        public ContainerSpaceChest (InventoryPlayer inventoryPlayer, TileEntitySpaceChest te){
                tileEntity = te;

                //Slot number in the container. Starts at zero as this is the first set of slots to add.
                int atSlot = 0;
                
                //Add input buffer slots.
                for (int xPos = 0; xPos < 9; xPos++) {
                	for (int yPos= 0; yPos < 2; yPos++) {
                		atSlot += 1;
                        addSlotToContainer(new Slot(tileEntity, atSlot, 8 + (18 * xPos), 18 + (18 * yPos)));
                	}
 
                }
               
                
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
            //9 by 3 inventory    
        	for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 9; j++) {
                                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                                8 + j * 18, 68 + i * 18));
                        }
                }
        		//Hotbar
                for (int i = 0; i < 9; i++) {
                        addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 126));
                }
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

}
