package mods.AnotherWorld.Mechanical.TileEntity;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.AnotherWorld.Mechanical.Util.MechanicsTableValidation;
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
    
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList items = par1NBTTagCompound.getTagList("Items");
		NBTTagList other = par1NBTTagCompound.getTagList("Other");
        inv = new ItemStack[this.getSizeInventory()];
        
        
        for (int var3 = 0; var3 < items.tagCount(); ++var3) {
            NBTTagCompound itemsCom = (NBTTagCompound) items.tagAt(var3);
            int var5 = itemsCom.getByte("Slot") & 255;

            if (var5 >= 0 && var5 < this.inv.length) {
                this.inv[var5] = ItemStack.loadItemStackFromNBT(itemsCom);
            }
        }
        NBTTagCompound otherCom = (NBTTagCompound) items.tagAt(0);
    }

    
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        NBTTagList items = new NBTTagList();
        for (int var3 = 0; var3 < inv.length; ++var3)
        {
            if (inv[var3] != null)
            {
                NBTTagCompound tagCom = new NBTTagCompound();
                tagCom.setByte("Slot", (byte)var3);
                inv[var3].writeToNBT(tagCom);
                items.appendTag(tagCom);
            }
        }
        
        
        par1NBTTagCompound.setTag("Items", items);
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
