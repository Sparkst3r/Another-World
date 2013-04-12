package mods.AnotherWorld.Util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotCrafting extends Slot{

    private EntityPlayer thePlayer;
	private IInventory craftMatrix;

	public SlotCrafting(EntityPlayer par1EntityPlayer, IInventory par2IInventory, IInventory par3IInventory, int par4, int par5, int par6) {
        super(par3IInventory, par4, par5, par6);
        this.thePlayer = par1EntityPlayer;
        this.craftMatrix = par2IInventory;
    }
	
}
