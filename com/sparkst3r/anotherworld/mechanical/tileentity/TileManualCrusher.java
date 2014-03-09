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
import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.mechanical.blocks.BlockManualCrusher;
import com.sparkst3r.anotherworld.mechanical.crafting.ManualCrusherManager;
import com.sparkst3r.anotherworld.network.packet.PacketManualCrusher;
import com.sparkst3r.anotherworld.util.WorldUtils;


public class TileManualCrusher extends TileEntity implements IInventory, ISidedInventory {

	
	public ItemStack[] inv = new ItemStack[2];
	
	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory() {
		return inv.length;
	}
	
	public TileManualCrusher() {
		super();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound NBTComp) {
		super.readFromNBT(NBTComp);
		//NBTTagList NBTTag = NBTComp.getTagList("Items", 10);
		//this.inv = new ItemStack[this.getSizeInventory()];
		//
		//for (int slotPos = 0; slotPos < NBTTag.tagCount(); slotPos++) {
		//	NBTTagCompound NBTSlotComp = (NBTTagCompound) NBTTag.getCompoundTagAt(slotPos);
		//	int slot = NBTSlotComp.getByte("Slot");
		//	
		//	if (slot >= 0 && slot < inv.length) {
		//		this.inv[slot] = ItemStack.loadItemStackFromNBT(NBTSlotComp);
		//	}
		//}
		this.clickState = NBTComp.getInteger("clickState");
		System.out.println("Read   " +  this.clickState);
	}
	
	/**
	 * Writes a tile entity to NBT.
	 */
	@Override
	public void writeToNBT(NBTTagCompound NBTComp) {
		super.writeToNBT(NBTComp);
		//NBTTagList NBTTag = new NBTTagList();
		//
		//for (int slot = 0; slot < inv.length; ++slot) {
		//	if (inv[slot] != null) {
		//		NBTTagCompound NBTSlotComp = new NBTTagCompound();
		//		NBTSlotComp.setByte("Slot", (byte) slot);
		//		inv[slot].writeToNBT(NBTSlotComp);
		//		NBTTag.appendTag(NBTSlotComp);
		//	}
		//}
//		/NBTComp.setTag("Items", NBTTag);
		NBTComp.setInteger("clickState", this.clickState);
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
	
	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a new stack.
	 */
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
	
	public int clickState = 0;
	private int prevClickState = 0;
	
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
				
				IManualCrusherRecipe recipe = ManualCrusherManager.getOutput(this.getStackInSlot(0));
				if (recipe == null) {
					clickState = 0;
				}
				if (clickState >= 16) {
				clickState = 0;
				if (this.getStackInSlot(1) == null && this.getStackInSlot(0) != null) {
					this.setInventorySlotContents(1, recipe.getRecipeOutput());
					this.getStackInSlot(0).stackSize -= recipe.getInputStack().stackSize;
					if (this.getStackInSlot(0).stackSize <= 0) {
						this.inv[0] = null;
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
	
	
	
	

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {}
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
