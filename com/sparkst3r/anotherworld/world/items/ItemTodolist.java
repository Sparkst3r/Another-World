/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.world.items;

import com.sparkst3r.anotherworld.core.AnotherWorldTab;
import com.sparkst3r.anotherworld.core.GlobalValues;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/** 
 * ItemTodolist
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 14 Mar 2014
 */
public class ItemTodolist extends Item {

	/** Universal identifier */
	public static final String identifier = "todolist";
	
	
	/** Constructor */
	public ItemTodolist() {
		super();
        this.setCreativeTab(AnotherWorldTab.TAB);
        this.setMaxStackSize(1);
		GameRegistry.registerItem(this, identifier);
	}
	
	
	/**
	 * Called when the item is right clicked in the hand
	 * Opens the todolist GUI
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		
		
		return stack;
	}
	
	
	
	/** Register the textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister ir) {
		this.itemIcon = ir.registerIcon(GlobalValues.MODIDCORE + ":" + identifier);
	}
	
	/** Returns the unlocalised name of the itemstack */
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return "item." + identifier;
	}
}
