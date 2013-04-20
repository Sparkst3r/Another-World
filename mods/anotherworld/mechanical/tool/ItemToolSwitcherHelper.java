package mods.anotherworld.mechanical.tool;

import mods.anotherworld.mechanical.MechanicalValues;
import mods.anotherworld.mechanical.items.ItemTool;
import mods.anotherworld.util.ItemStackUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Used to switch tools from a list of tools
 * @author Sparkst3r
 *
 */
public class ItemToolSwitcherHelper {

	
	/**
	 * Checks what the tool was at craft time, prevents duping and obtaining free upgrades
	 * 
	 * @param stack
	 * @param player
	 * @return
	 */
	public static ItemStack getTypeFromNBT(ItemStack stack, EntityPlayer player) {
		if(stack.stackTagCompound.getShort("type") == ItemTool.ItemToolEnum.ACTIVATE.ordinal()) {
			return switchForTypeActivate(stack, player);
		}
		if(stack.stackTagCompound.getShort("type") == ItemTool.ItemToolEnum.DISMANTLE.ordinal()) {
			return switchForTypeDismantle(stack, player);
		}
		else if(stack.stackTagCompound.getShort("type") == ItemTool.ItemToolEnum.ROTATE.ordinal()) {
			return switchForTypeRotate(stack, player);
		}
		else if(stack.stackTagCompound.getShort("type") == ItemTool.ItemToolEnum.HELP.ordinal()) {
			return switchForTypeHelp(stack, player);
		}
		else if(stack.stackTagCompound.getShort("type") == ItemTool.ItemToolEnum.SETTINGS.ordinal()) {
			return switchForTypeSettings(stack, player);
		}
		else if(stack.stackTagCompound.getShort("type") == ItemTool.ItemToolEnum.MOVE.ordinal()) {
			return switchForTypeMove(stack, player);
		}
		return stack;
	}

	/**
	 * Will iterate through valid tools for type activate
	 * @param stack
	 * @param player
	 * @return
	 */
	public static ItemStack switchForTypeActivate(ItemStack stack, EntityPlayer player) {
		return stack;
	}
	
	/**
	 * Will iterate through valid tools for type dismantle
	 * @param stack
	 * @param player
	 * @return
	 */
	public static ItemStack switchForTypeDismantle(ItemStack stack, EntityPlayer player) {
		int meta = stack.getItemDamage();
		if(meta == ItemTool.ItemToolEnum.ACTIVATE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.DISMANTLE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.DISMANTLE.ordinal());
			return s;
		}
		if(meta == ItemTool.ItemToolEnum.DISMANTLE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.ACTIVATE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.DISMANTLE.ordinal());
			s.stackTagCompound.setString("identifier", "dismantle");
			return s;
		}
		
		return stack;
	}
	/**
	 * Will iterate through valid tools for type rotate
	 * @param stack
	 * @param player
	 * @return
	 */
	public static ItemStack switchForTypeRotate(ItemStack stack, EntityPlayer player) {
		int meta = stack.getItemDamage();
		if(meta == ItemTool.ItemToolEnum.ACTIVATE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.DISMANTLE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.ROTATE.ordinal());
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.DISMANTLE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.ROTATE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.ROTATE.ordinal());
			s.stackTagCompound.setString("identifier", "dismantle");
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.ROTATE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.ACTIVATE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.ROTATE.ordinal());
			return s;
		}
		return stack;
	}
	/**
	 * Will iterate through valid tools for type help
	 * @param stack
	 * @param player
	 * @return
	 */
	public static ItemStack switchForTypeHelp(ItemStack stack, EntityPlayer player) {
		int meta = stack.getItemDamage();
		
		
		if(meta == ItemTool.ItemToolEnum.ACTIVATE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.DISMANTLE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.HELP.ordinal());
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.DISMANTLE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.ROTATE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.HELP.ordinal());
			s.stackTagCompound.setString("identifier", "dismantle");
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.ROTATE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.HELP.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.HELP.ordinal());
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.HELP.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.ACTIVATE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.HELP.ordinal());
			return s;
		}
		return stack;
	}
	
	/**
	 * Will iterate through valid tools for type settings
	 * @param stack
	 * @param player
	 * @return
	 */
	public static ItemStack switchForTypeSettings(ItemStack stack, EntityPlayer player) {
		int meta = stack.getItemDamage();
		
		
		if(meta == ItemTool.ItemToolEnum.ACTIVATE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.DISMANTLE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.SETTINGS.ordinal());
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.DISMANTLE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.ROTATE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.SETTINGS.ordinal());
			s.stackTagCompound.setString("identifier", "dismantle");
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.ROTATE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.HELP.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.SETTINGS.ordinal());
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.HELP.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.SETTINGS.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.SETTINGS.ordinal());
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.SETTINGS.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.ACTIVATE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.SETTINGS.ordinal());
			return s;
		}
		return stack;
	}
	
	/**
	 * Will iterate through valid tools for type move
	 * @param stack
	 * @param player
	 * @return
	 */
	public static ItemStack switchForTypeMove(ItemStack stack, EntityPlayer player) {
		int meta = stack.getItemDamage();
		
		
		if(meta == ItemTool.ItemToolEnum.ACTIVATE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.DISMANTLE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.MOVE.ordinal());
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.DISMANTLE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.ROTATE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.MOVE.ordinal());
			s.stackTagCompound.setString("identifier", "dismantle");
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.ROTATE.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.HELP.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.MOVE.ordinal());
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.HELP.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.SETTINGS.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.MOVE.ordinal());
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.SETTINGS.ordinal()) {
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.MOVE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.MOVE.ordinal());
			return s;
		}
		else if(meta == ItemTool.ItemToolEnum.MOVE.ordinal()) {
			
			if(stack.stackTagCompound.getBoolean("hasBlock") && stack.stackTagCompound.hasKey("block") && !player.worldObj.isRemote) {
				ItemStack dropstack = new ItemStack(stack.stackTagCompound.getInteger("block"), 1, stack.stackTagCompound.getInteger("metadata"));
				player.dropPlayerItem(dropstack);
				stack.stackTagCompound.setBoolean("hasBlock", false);
			}
			ItemStack s = ItemStackUtils.makeStackWithCompound(MechanicalValues.ItemToolField, ItemTool.ItemToolEnum.ACTIVATE.ordinal());
			s.stackTagCompound.setShort("type", (short) ItemTool.ItemToolEnum.MOVE.ordinal());
			
			return s;
		}
		return stack;
	}
}
