package mods.AnotherWorld.Mechanical.Util;

import mods.AnotherWorld.Mechanical.MechanicalValues;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Used to switch tools from a list of tools
 * @author Sparkst3r
 *
 */
public class ItemToolSwitcherHelper {
	
	public static ItemStack getTypeFromNBT(ItemStack stack, EntityPlayer player) {
		
		/** Checks what the item was at craft time, prevents duping and obtaining free upgrades */
		if(stack.stackTagCompound.getShort("type") == 0) {
			return type0(stack, player);
		}
		if(stack.stackTagCompound.getShort("type") == 1) {
			return type1(stack, player);
		}
		else if(stack.stackTagCompound.getShort("type") == 2) {
			return type2(stack, player);
		}
		else if(stack.stackTagCompound.getShort("type") == 3) {
			return type3(stack, player);
		}
		else if(stack.stackTagCompound.getShort("type") == 4) {
			return type4(stack, player);
		}
		
		
		
		return stack;
	}
	
	
	
	
	
	
	public static ItemStack type0(ItemStack stack, EntityPlayer player) {
		int meta = stack.getItemDamage();
		if(meta == 0) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 1);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 0);
			return newStack;
		}
		return stack;
	}
	public static ItemStack type1(ItemStack stack, EntityPlayer player) {
		//Does nothing.
		return stack;
	}
	
	public static ItemStack type2(ItemStack stack, EntityPlayer player) {
		int meta = stack.getItemDamage();
		if(meta == 0) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 1);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 2);
			return newStack;
		}
		else if(meta == 1) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 2);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 2);
			return newStack;
		}
		else if(meta == 2) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 1);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 2);
			return newStack;
		}
		return stack;
	}
	
	
	public static ItemStack type3(ItemStack stack, EntityPlayer player) {
		int meta = stack.getItemDamage();
		if(meta == 0) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 1);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 3);
			return newStack;
		}
		else if(meta == 1) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 2);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 3);
			return newStack;
		}
		else if(meta == 2) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 3);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 3);
			return newStack;
		}
		else if(meta == 3) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 1);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 3);
			return newStack;
		}
		return stack;
	}
	
	
	public static ItemStack type4(ItemStack stack, EntityPlayer player) {
		int meta = stack.getItemDamage();
		if(meta == 0) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 1);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 4);
			return newStack;
		}
		else if(meta == 1) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 2);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 4);
			return newStack;
		}
		else if(meta == 2) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 3);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 4);
			return newStack;
		}
		else if(meta == 3) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 4);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 4);
			return newStack;
		}
		else if(meta == 4) {
			
			ItemStack newStack = new ItemStack(MechanicalValues.ItemToolField, 1, 1);
			if( newStack.stackTagCompound == null) {
				newStack.setTagCompound(new NBTTagCompound());
			}
			newStack.stackTagCompound.setShort("type", (short) 4);
			return newStack;
		}
		return stack;
	}
	
	
	
}
