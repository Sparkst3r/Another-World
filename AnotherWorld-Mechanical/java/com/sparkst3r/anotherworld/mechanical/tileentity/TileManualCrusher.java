package com.sparkst3r.anotherworld.mechanical.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.sparkst3r.anotherworld.api.crafting.IManualCrusherRecipe;
import com.sparkst3r.anotherworld.mechanical.blocks.BlockManualCrusher;
import com.sparkst3r.anotherworld.mechanical.crafting.ManualCrusherManager;

/**
 * TileManualCrusher
 *
 * <p>TileEntity for Manual Crusher {@link BlockManualCrusher}</p>
 * 
 * @see BlockManualCrusher
 *
 * @author Sparkst3r
 * @since 27 Apr 2014
 */
public class TileManualCrusher extends TileEntity implements IInventory, ISidedInventory {

	/** Input slot */
	public static final int INPUTSLOT = 0;
	
	/** Output slot */
	public static final int OUTPUTSLOT = 1;
	
	/** Inventory name of the crusher */
	private static final String INVNAME = "container.manualcrusher";
	
	/** Current amount of clicks this crusher has */
	public int clickState = 0;
	
	/** Previous click count*/
	private int prevClickState = 0;
	
	/** Contents of the crusher */
	public ItemStack[] slots = new ItemStack[2];
	
	/**
	 * Constructor
	 */
	public TileManualCrusher() {
		super();
	}
	

	/**
	 * Reads TileEntity data from NBT.
	 */
	@Override
	public void readFromNBT(NBTTagCompound nbtComp) {
		super.readFromNBT(nbtComp);
		NBTTagList nbttaglist = nbtComp.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];

		for (int tag = 0; tag < nbttaglist.tagCount(); tag++) {
			NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(tag);
			int slot = nbttagcompound.getByte("Slot") & 255;

			if (slot >= 0 && slot < this.slots.length) {
				this.slots[slot] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}
		}
		
		if (nbtComp.hasKey("clicks")) {
			this.clickState = nbtComp.getInteger("clicks");
		}
	}
	
	/**
	 * Writes TileEntity data to NBT.
	 */
	@Override
	public void writeToNBT(NBTTagCompound nbtComp) {
		super.writeToNBT(nbtComp);
		NBTTagList nbttaglist = new NBTTagList();
		
		for (int slot = 0; slot < this.slots.length; slot++) {
			if (this.slots[slot] != null) {
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte)slot);
				this.slots[slot].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
			}
		}
		nbtComp.setTag("Items", nbttaglist);

		nbtComp.setInteger("clicks", this.clickState);
	}
	
	/**
	 * Returns the stack in slot
	 * @param slot the id of the slot to return the stack from
	 * @return the stack
	 */
	@Override
	public ItemStack getStackInSlot(int slot) {
		return slots[slot];
	}
	
	/**
	 * Set the contents of the slot
	 * @param slot the id of the slot to enter a stack into
	 * @param stack the stack to insert
	 */
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		slots[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
	}
	
	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a new stack.
	 */
	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= amount) {
				setInventorySlotContents(slot, null);
			}
			else {
				stack = stack.splitStack(amount);
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
		return 16;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}


	/**
	 * Slots that are open for a particular side
	 */
	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		switch (side) {
			case 0:
				return new int[] {1};
			default:
				return new int[] {0};
		}
	}

	/**
	 * Returns true if automation can insert the given item in the given slot from the given side.
	 */
	@Override
	public boolean canInsertItem(int slot, ItemStack stack, int side) {
		if (side != 0) {
			if (this.getStackInSlot(slot) == null || this.getStackInSlot(slot).stackSize < 4) {
				return true;
			}	
		}
		return false;
	}

	/**
	 * Returns true if automation can extract the given item in the given slot
	 */
	@Override
	public boolean canExtractItem(int slot, ItemStack stack, int side) {
		if (side == 0) {
			if (this.getStackInSlot(1) != null) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void updateEntity() {
		if (prevClickState != 0 && clickState == 0) {
			BlockManualCrusher.updateBlockState(0, worldObj, xCoord, yCoord, zCoord);
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		else if (prevClickState != 4 && clickState == 4) {
			BlockManualCrusher.updateBlockState(1, worldObj, xCoord, yCoord, zCoord);
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		else if (prevClickState != 8 && clickState == 8) {
			BlockManualCrusher.updateBlockState(2, worldObj, xCoord, yCoord, zCoord);
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		else if (prevClickState != 12 && clickState == 12) {
			BlockManualCrusher.updateBlockState(3, worldObj, xCoord, yCoord, zCoord);
			this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		if (clickState != prevClickState) {
			prevClickState = clickState;
				
			IManualCrusherRecipe recipe = ManualCrusherManager.getOutput(this.getStackInSlot(INPUTSLOT));
			if (recipe == null) {
				clickState = 0;
			}
			else if (clickState >= 16) {
				clickState = 0;
				if (this.getStackInSlot(OUTPUTSLOT) == null && this.getStackInSlot(INPUTSLOT) != null) {
					this.setInventorySlotContents(OUTPUTSLOT, recipe.getRecipeOutput());
					this.getStackInSlot(INPUTSLOT).stackSize -= recipe.getInputStack().stackSize;
					if (this.getStackInSlot(INPUTSLOT).stackSize <= 0) {
						this.slots[0] = null;
					}
				}
				this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}	
		}


	}
	
	@Override
	public void onDataPacket(NetworkManager manager, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}
	
	@Override
	public Packet getDescriptionPacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        System.out.println(nbtTag.getInteger("clickState") + " PACKET");
        return new S35PacketUpdateTileEntity(this.xCoord, this.xCoord, this.xCoord, 1, nbtTag);
}
	
	
	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory() {
		return slots.length;
	}
	

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	/**
	 * Called on inventory open
	 */
	@Override
	public void openInventory() {}
	
	/**
	 * Called on inventory close
	 */
	@Override
	public void closeInventory() {}

	
	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 */
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return true;
	}
}
