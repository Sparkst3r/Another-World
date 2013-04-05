package mods.AnotherWorld.Mechanical.Items;

import mods.AnotherWorld.Mechanical.MechanicalValues;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ToolChanger {
	
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
