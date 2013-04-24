package mods.anotherworld.mechanical.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileMechanicsTable extends TileEntity implements IInventory {
	
	/** ItemStack array of the inventory slots */
	public ItemStack[] inv;
	public World world = this.worldObj;
	
	/**
	 * Constructor
	 */
	public TileMechanicsTable() {
		super();
		inv = new ItemStack[17];
	}
	
	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	/**
	 * Returns the stack in slot (slot)
	 * @param slot Slot to check
	 */
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
			} 
			else {
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
		return world.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
    
    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
        this.inv = new ItemStack[this.getSizeInventory()];


        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            int j = nbttagcompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.inv.length) {
                this.inv[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
                System.out.println("Read: " + ItemStack.loadItemStackFromNBT(nbttagcompound1).getDisplayName());
            }
        }
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inv.length; ++i)
        {
            if (this.inv[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.inv[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
    			System.out.println("Write: " + inv[i].getDisplayName());
            }
        }

        par1NBTTagCompound.setTag("Items", nbttaglist);
    }

	@Override
	public String getInvName() {
		return "inventory.mechtable";
	}

	@Override
	public boolean isInvNameLocalized() {
		return true;
	}



	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isStackValidForSlot(int i, ItemStack itemstack) {
		
		return false;
	}
	
	@Override
	public void updateEntity() {

	}

}
