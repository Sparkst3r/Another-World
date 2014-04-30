/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.world.container;

import com.sparkst3r.anotherworld.world.WorldValues;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * ContainerBackpackContents
 * 
 * Container for the contents of the backpack and its pouches
 *
 * @author Sparkst3r
 * @since 30 Apr 2014
 */
public class ContainerBackpackContents extends Container {
	
	/**
	 * Constructor
	 * @param player the player using the container
	 * @param stack the backpack item
	 */
	public ContainerBackpackContents(EntityPlayer player, ItemStack stack) {

		if (!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
		}
		stack.getTagCompound().setInteger("pouchLevel", 4);

		/** The player's backpack inventory */
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 9; column++) {
				addSlotToContainer(new Slot(player.inventory, column + row * 9 + 9, 8 + column * 18, 152 + (row * 18)));
			}
		}
		
		/** The player's hotbar inventory */
		for(int column = 0; column < 9; column++) {
			addSlotToContainer(new Slot(player.inventory, column, 8 + column * 18, 210));
		}
		
		/** The pouch inventory fall through previous pouch tiers*/
		int pouchLevel = stack.getTagCompound().getInteger("pouchLevel");
		
		if (pouchLevel != -1) {
			switch(pouchLevel) {
				case 4: {
					IInventory pouch4 = new PouchInventory(player, stack, 4);
					for (int row = 0; row < 3; row++) {
						for (int column = 0; column < 3; column++) {
							this.addSlotToContainer(new SlotBackpack(pouch4, column + row * 3, 91 + column * 18, 86 + row * 18));
						}
					}
				}
				case 3: {
					IInventory pouch3 = new PouchInventory(player, stack, 3);
					for (int row = 0; row < 3; row++) {
						for (int column = 0; column < 3; column++) {
							this.addSlotToContainer(new SlotBackpack(pouch3, column + row * 3, 33 + column * 18, 86 + row * 18));
						}
					}
				}
				case 2: {
					IInventory pouch2 = new PouchInventory(player, stack, 2);
					for (int row = 0; row < 3; row++) {
						for (int column = 0; column < 3; column++) {
							this.addSlotToContainer(new SlotBackpack(pouch2, column + row * 3, 91 + column * 18, 28 + row * 18));
						}
					}
				}
				case 1: {
					IInventory pouch1 = new PouchInventory(player, stack, 1);
					for (int row = 0; row < 3; row++) {
						for (int column = 0; column < 3; column++) {
							this.addSlotToContainer(new SlotBackpack(pouch1, column + row * 3, 33 + column * 18, 28 + row * 18));
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * Can the player interact with this container
	 */
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	/**
	 * PouchInventory
	 * 
	 * Inventory handler for a pouch in the backpack
	 *
	 * @author Sparkst3r
	 * @since 30 Apr 2014
	 */
	private class PouchInventory implements IInventory {

		/** The contents of the pouch */
		private ItemStack[] contents = new ItemStack[9];
		
		/** The backpack item */
		private ItemStack backpack;

		/** The id of the pouch in the backpack */
		private int pouchID;
		
		/**
		 * Constructor
		 * @param player the player using the inventory
		 * @param backpack the backpack items
		 * @param pouchID the id of the pouch in the backpack
		 */
		public PouchInventory(EntityPlayer player, ItemStack backpack, int pouchID) {
			this.backpack = backpack;
			this.pouchID = pouchID;
			loadpouchFromStack();
		}
		
	
		/**
		 * Load the contents of this pouch from the backpack
		 */
		private void loadpouchFromStack() {
			if (!backpack.hasTagCompound()) {
				backpack.setTagCompound(new NBTTagCompound());
			}
			NBTTagList tags = backpack.getTagCompound().getTagList(pouchID + "_contents", 10);
			for (int tag = 0; tag < tags.tagCount(); tag++) {
				NBTTagCompound slot = tags.getCompoundTagAt(tag);
				int slotID = slot.getInteger("Slot");
				if (slotID >= 0 && slotID < this.contents.length) {
					this.contents[slotID] = ItemStack.loadItemStackFromNBT(slot);
				}
			}
			markDirty();
		}
		
		/**
		 * Save the contents of this pouch to the backpack
		 */
		private void savepouchToStack() {
			
			NBTTagList tags = new NBTTagList();
			for (int tag = 0; tag < this.contents.length; tag++) {
				if (this.contents[tag] != null) {
					NBTTagCompound slot = new NBTTagCompound();
					slot.setInteger("Slot", tag);
					this.contents[tag].writeToNBT(slot);
					tags.appendTag(slot);
				}
			}
			backpack.getTagCompound().setTag(pouchID + "_contents", tags);
			
		}
		
		/**
		 * If the pouch is updated in some way save the pouch
		 */
		@Override
		public void markDirty() {
			savepouchToStack();
		}


		/**
		 * Returns the stack in slot
		 * @param slot the id of the slot to return the stack from
		 * @return the stack
		 */
		@Override
		public ItemStack getStackInSlot(int slot) {
			return contents[slot];
		}
		
		/**
		 * Set the contents of the slot
		 * @param slot the id of the slot to enter a stack into
		 * @param stack the stack to insert
		 */
		@Override
		public void setInventorySlotContents(int slot, ItemStack stack) {
			contents[slot] = stack;
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
		
		/**
		 * Get inventory size
		 */
		@Override
		public int getSizeInventory() {
			return contents.length;
		}

		/**
		 * Get the inventory name of this inventory
		 */
		@Override
		public String getInventoryName() {
			return "container.backpackpouch";
		}

		/**
		 * Does this inventory have a custom name?
		 */
		@Override
		public boolean hasCustomInventoryName() {
			return true;
		}

		/**
		 * The stack limit for items in this inventory
		 */
		@Override
		public int getInventoryStackLimit() {
			return 64;
		}

		/**
		 * Can the player use this inventory?
		 */
		@Override
		public boolean isUseableByPlayer(EntityPlayer var1) {
			return true;
		}

		/**
		 * Called when the inventory is opened
		 */
		@Override
		public void openInventory() {}

		/**
		 * Called when the inventory is closed
		 */
		@Override
		public void closeInventory() {}

		/**
		 * Is the stack valid for the slot
		 */
		@Override
		public boolean isItemValidForSlot(int slot, ItemStack stack) {
			if (stack.getItem() == WorldValues.itemBackpack) {
				return false;
			}
			return true;
		}
	}

	/**
	 * SlotBackpack
	 * 
	 * Allow for blacklisted items in the backpack
	 *
	 * @author Sparkst3r
	 * @since 30 Apr 2014
	 */
	private class SlotBackpack extends Slot {

		/**
		 * Constructor
		 * @param par1iInventory
		 * @param par2
		 * @param par3
		 * @param par4
		 */
		public SlotBackpack(IInventory iInventory, int slot, int x, int y) {
			super(iInventory, slot, x, y);
		}
		
		@Override
		public boolean isItemValid(ItemStack stack) {
			return this.inventory.isItemValidForSlot(this.getSlotIndex(), stack);
		}
	}
}
