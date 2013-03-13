package anotherWorld.common.machines.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySeparator extends TileEntity implements IInventory {

        private ItemStack[] inv;

        public TileEntitySeparator(){
        		super();
                inv = new ItemStack[9];
        }
       
        @Override
        public int getSizeInventory() {
                return inv.length;
        }

        @Override
        public ItemStack getStackInSlot(int slot) {
                return inv[slot];
        }
       
        @Override
        public void setInventorySlotContents(int slot, ItemStack stack) {
                inv[slot] = stack;
                if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                        stack.stackSize = getInventoryStackLimit();
                }              
        }

        @Override
        public ItemStack decrStackSize(int slot, int amt) {
                ItemStack stack = getStackInSlot(slot);
                if (stack != null) {
                        if (stack.stackSize <= amt) {
                                setInventorySlotContents(slot, null);
                        } else {
                                stack = stack.splitStack(amt);
                                if (stack.stackSize == 0) {
                                        setInventorySlotContents(slot, null);
                                }
                        }
                }
                return stack;
        }

        @Override
        public ItemStack getStackInSlotOnClosing(int slot) {
                ItemStack stack = getStackInSlot(slot);
                if (stack != null) {
                        setInventorySlotContents(slot, null);
                }
                return stack;
        }
       
        @Override
        public int getInventoryStackLimit() {
                return 64;
        }

        @Override
        public boolean isUseableByPlayer(EntityPlayer player) {
                return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this &&
                player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
        }
        @Override
        public void openChest() {}

        @Override
        public void closeChest() {}
       
        public void readFromNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.readFromNBT(par1NBTTagCompound);
            NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
            inv = new ItemStack[this.getSizeInventory()];

            for (int var3 = 0; var3 < var2.tagCount(); ++var3)
            {
                NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
                int var5 = var4.getByte("Slot") & 255;

                if (var5 >= 0 && var5 < this.inv.length)
                {
                    this.inv[var5] = ItemStack.loadItemStackFromNBT(var4);
                }
            }
        }

        public void writeToNBT(NBTTagCompound par1NBTTagCompound)
        {
            super.writeToNBT(par1NBTTagCompound);
            NBTTagList var2 = new NBTTagList();

            for (int var3 = 0; var3 < inv.length; ++var3)
            {
                if (inv[var3] != null)
                {
                    NBTTagCompound tagCom = new NBTTagCompound();
                    tagCom.setByte("Slot", (byte)var3);
                    inv[var3].writeToNBT(tagCom);
                    var2.appendTag(tagCom);
                }
            }

            par1NBTTagCompound.setTag("Items", var2);
        }

                @Override
                public String getInvName() {
                        return "tco.tileentitytiny";
                }
}
