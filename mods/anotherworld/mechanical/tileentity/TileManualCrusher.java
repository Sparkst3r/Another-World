package mods.anotherworld.mechanical.tileentity;

import mods.anotherworld.mechanical.crafting.ManualCrusherManager;
import mods.anotherworld.mechanical.crafting.ManualCrusherManager.ManualCrusherRecipe;
import mods.anotherworld.util.WorldUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileManualCrusher extends TileEntity implements IInventory, ISidedInventory {
	private int clicks = 0;
	
	
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
	
	/**
	 * Gets the current amount of clicks
	 * @return clicks
	 */
	public int getClicks() {
		return clicks;
	}

	
	/**
	 * Set clicks to a value
	 * @param clicks Amount of clicks
	 */
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	
	
	/**
	 * Reads a tile entity from NBT.
	 */
	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items");
		inv = new ItemStack[this.getSizeInventory()];
		
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.tagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;
			
			if (j >= 0 && j < inv.length) {
				inv[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}
	
	/**
	 * Writes a tile entity to NBT.
	 */
	@Override
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = new NBTTagList();
		
		for (int i = 0; i < inv.length; ++i) {
			if (inv[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				inv[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		
		par1NBTTagCompound.setTag("Items", nbttaglist);
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
	public String getInvName() {
		return "inventory.mcrusher";
	}
	
	@Override
	public boolean isInvNameLocalized() {
		return true;
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
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 */
	@Override
	public boolean isStackValidForSlot(int slot, ItemStack stack) {
		return true;
	}
	

	
	
	/** Client side instance of the TileEntity */
	public TileManualCrusher tileClient;
	/** Server side instance of the TileEntity */
	public TileManualCrusher tileServer;

	
	@Override
	public void updateEntity() {
		
		/* If we are on the client world */
		if (tileClient != null && WorldUtils.isClientSide(tileClient.worldObj)) {
			/* Resets clicks when it gets to 16 */
			if (tileClient.getClicks() >= 16) {
				tileClient.setClicks(0);
			}
		}
		
		
		if (tileClient != null && tileServer != null) {
			if (WorldUtils.isServerSide(tileServer.worldObj)) {
				if (tileClient.getClicks() == 15 && tileServer.getStackInSlot(1) == null && tileServer.getStackInSlot(0) != null) {
					ManualCrusherRecipe recipe = ManualCrusherManager.getOutput(tileServer.getStackInSlot(0));
					if (recipe != null) {
						tileServer.setInventorySlotContents(1, recipe.getRecipeOutput());
						tileServer.getStackInSlot(0).stackSize	-= recipe.getInputStack().stackSize;
						if (tileServer.getStackInSlot(0).stackSize <= 0) {
							tileServer.inv[0] = null;
						}
						tileClient.setClicks(0);
					}
				}
			}

		}
	}

	/**
	 * Slots that are open for a particular side
	 */
	@Override
	public int[] getSizeInventorySide(int side) {
		switch (side) {
			case 0:
				return new int[] {1};
			default:
				return new int[] {0};
		}
	}

	/**
	 * ISidedInventory.canInsertItem
	 * Returns true if automation can insert the given item in the given slot from the given side.
	 */
	@Override
	public boolean func_102007_a(int slot, ItemStack stack, int side) {
		if (side != 0) {
			if (this.getStackInSlot(slot) == null || this.getStackInSlot(slot).stackSize < 4) {
				return true;
			}	
	}
		return false;
	}

	/**
	 * ISidedInventory.canExtractItem
	 * Returns true if automation can extract the given item in the given slot
	 */
	@Override
	public boolean func_102008_b(int slot, ItemStack stack, int side) {
		if (side == 0) {
			if (this.getStackInSlot(1) != null) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void openChest() {}
	@Override
	public void closeChest() {}
}
