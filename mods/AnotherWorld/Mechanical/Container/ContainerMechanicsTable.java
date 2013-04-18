package mods.AnotherWorld.Mechanical.Container;


import cpw.mods.fml.common.FMLLog;
import mods.AnotherWorld.Mechanical.Crafting.MechTableCraftingManager;
import mods.AnotherWorld.Mechanical.TileEntity.TileMechanicsTable;
import mods.AnotherWorld.Util.SlotCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerMechanicsTable extends Container {
	private static int slots = 17;
	
	/** The world object associated with the TileEntity */
	private World world;
	
	/** The Tile Entity */
	private TileMechanicsTable tileEntity;
	
	/** The Crafting Matrix */
	private InventoryCrafting craftMatrix = new InventoryCrafting(this, 4, 4);
	
	/** The Crafting result */
	private IInventory craftResult = new InventoryCraftResult();

	public ContainerMechanicsTable (InventoryPlayer inventoryPlayer, TileMechanicsTable te){
		world = te.worldObj;
		tileEntity = te;
		int slot = 0;
		
		/** Crafting Matrix */
		for (int row = 0; row < 4; row ++) {
			for(int column = 0; column < 4; column++) {
				addSlotToContainer(new Slot(craftMatrix, slot, 13 + column * 18, 6 + (row * 18)));
				slot++;
			}
		}
		addSlotToContainer(new SlotCrafting(inventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 124, 35));
		
		
		/** The player's backpack inventory */
		for(int row = 0; row < 3; row++) {
			for(int column = 0; column < 9; column++) {
				addSlotToContainer(new Slot(inventoryPlayer, column + row * 9 + 9, 8 + column * 18, 84 + (row * 18)));
			}
		}
        		
		/** The player's hotbar inventory */
		for(int column = 0; column < 9; column++) {
			addSlotToContainer(new Slot(inventoryPlayer, column, 8 + column * 18, 142));
		}
        		
		for (int x = 0; x < 16; x++) {
			craftMatrix.setInventorySlotContents(x, tileEntity.getStackInSlot(x));
		}
        		
        		
		this.onCraftMatrixChanged(this.craftMatrix);
	}

	public void onCraftMatrixChanged(IInventory inv) {
		super.onCraftMatrixChanged(inv);
		for(int x = 0; x < 16; x++) {
			if(inv.getStackInSlot(x) != null) {
				tileEntity.setInventorySlotContents(x, inv.getStackInSlot(x));
			}
		}
		this.craftResult.setInventorySlotContents(0, MechTableCraftingManager.getOutput(this.craftMatrix, this.world));
	}

	/** Called when the GUI is closed by the player*/
	public void onCraftGuiClosed(EntityPlayer par1EntityPlayer) {
		for(int x = 0; x < 16; x++) {
			tileEntity.setInventorySlotContents(x, craftMatrix.getStackInSlot(x));
		}   
	}
        

	/** Can the player access the GUI */
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		//TODO Add some checking here.
		return true;
	}

        /** Handle shift clicking */
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