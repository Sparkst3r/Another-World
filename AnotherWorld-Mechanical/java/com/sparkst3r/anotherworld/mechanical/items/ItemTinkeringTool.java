package com.sparkst3r.anotherworld.mechanical.items;

import java.util.List;

import javax.swing.Icon;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.sparkst3r.anotherworld.api.tool.IToolAction;
import com.sparkst3r.anotherworld.core.AnotherWorldTab;
import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.mechanical.tool.ToolActionManager;
import com.sparkst3r.anotherworld.mechanical.tool.ToolModeManager;
import com.sparkst3r.anotherworld.util.WorldUtils;



import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * Tinkering tool(s) class. 
 * Meta data for multiple modes(Upgrades)
 * @author Sparkst3r
 *
 */
public class ItemTinkeringTool extends Item {
    
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	public static IIcon[] iconBuffer;
    
	public String currentModeIdentifier = "";
	
	public IToolAction currentAction = null;
	
	public static final String identifierBase = "item.tool.tinker";
	
	/** 
	 * Constructor
	 * @param id
	 */
	public ItemTinkeringTool() {
		super();
        this.setCreativeTab(AnotherWorldTab.TAB);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		GameRegistry.registerItem(this, "tinkeringTools");
	}
	
	/** 
	 * Called on creation 
	 * Assigns a "type" to the ItemStack so the modes can be switched correctly
	 */
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		//if (WorldUtils.isServerSide(world)) {
		//	stack.setTagCompound(new NBTTagCompound());
		//	stack.stackTagCompound.setString("type", ToolModeManager.getModes().get(stack.getItemDamage()).identifier());
		//	//this.currentModeIdentifier = ToolModeManager.getModes().get(stack.getItemDamage()).identifier();
		//}

	}
	
	
	/** 
	 * Callback for item use(Right click)
	 * Switches between tools
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!player.isSneaking() && WorldUtils.isServerSide(world)) {
			if(stack.getTagCompound() == null) {
				stack.setTagCompound(new NBTTagCompound());
				stack.getTagCompound().setString("type", ToolModeManager.getModes().get(ToolModeManager.getModes().size() - 1).identifier());
			}
			
			ItemStack newStack = new ItemStack(stack.getItem(), 1, 0);
			newStack.setTagCompound(new NBTTagCompound());
			newStack.getTagCompound().setString("type", stack.getTagCompound().getString("type"));
			


			if (stack.getTagCompound().getString("type").equals(ToolModeManager.getModes().get(stack.getItemDamage()).identifier())) {
				newStack.setItemDamage(0);
			}
			
			else {
				newStack.setItemDamage(stack.getItemDamage() + 1);
				newStack.getTagCompound().setString("type", stack.getTagCompound().getString("type"));
			}
			
			((ItemTinkeringTool)newStack.getItem()).currentModeIdentifier = ToolModeManager.getModes().get(newStack.getItemDamage()).identifier();
			return newStack;
		}
		return stack;
	}
	
	/** Called when the item is used on a block **/
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		if(!world.isRemote && player.isSneaking()) {
			List<IToolAction> list = ToolActionManager.getActions(stack);
			if (list != null) {
				for(int action = 0; action < list.size(); action++){
					IToolAction thisAction = list.get(action);
					currentAction = thisAction;
					if (thisAction.canTriggerAction(stack, player, world, x, y, z, side, locX, locY, locZ)) {
						thisAction.triggerAction(stack, player, world, x, y, z, side, locX, locY, locZ);
						return true;
					}
				}
			}
		}
		return true;
	}
	
	/** Provides access to add custom lines to the item description **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)  {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			for (int line = 0; line < ToolModeManager.getModes().get(stack.getItemDamage()).infoLine().length; line++) {
				if(ToolModeManager.getModes().get(stack.getItemDamage()).infoLine()[line] != null) {
					list.add(ToolModeManager.getModes().get(stack.getItemDamage()).infoLine()[line]);
				}
			}
		}
		else {
			list.add("Press SHIFT for more info");
		}
	}
	
	
	/** Returns the texture based on the damage value */
	@SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int damage){
    	return iconBuffer[damage];
    }
	
	/** Register the textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister ir) {
		iconBuffer = new IIcon[(ToolModeManager.getModes().size() * 2) + 1];
		for (int icon = 0; icon < ToolModeManager.getModes().size(); icon++) {
			iconBuffer[icon] = ir.registerIcon(ToolModeManager.getModes().get(icon).texture());
			iconBuffer[ToolModeManager.getModes().size() + icon] = ir.registerIcon(ToolModeManager.getModes().get(icon).icon());
		}
	}
	
	/** Adds the meta items to the tab */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0));
	}
	
	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return "item." + ToolModeManager.getModes().get(is.getItemDamage()).identifier();
	}
}
