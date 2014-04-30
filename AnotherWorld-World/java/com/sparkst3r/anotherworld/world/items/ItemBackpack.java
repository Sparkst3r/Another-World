/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.world.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.sparkst3r.anotherworld.core.AnotherWorldTab;
import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.world.AnotherWorldExpansionWorld;
import com.sparkst3r.anotherworld.world.GuiHandlerWorld;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * ItemBackpack
 *
 * Extra player inventory space with storage upgrades
 *
 * @author Sparkst3r
 * @since 29 Apr 2014
 */
public class ItemBackpack extends Item {

	/** Universal identifier */
	public static final String identifier = "backpack";
	
	/**
	 * Constructor
	 */
	public ItemBackpack() {
		super();
        this.setCreativeTab(AnotherWorldTab.TAB);
        this.setMaxStackSize(1);
		GameRegistry.registerItem(this, identifier);
		
	}
	
	/**
	 * Called when the item is right clicked in the hand
	 * Opens the backpack GUI
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

		player.openGui(AnotherWorldExpansionWorld.instance, GuiHandlerWorld.BACKPACKUPG, world, (int)player.posX, (int)player.posY, (int)player.posZ);
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
