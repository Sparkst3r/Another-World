package com.sparkst3r.anotherworld.core;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * ItemIconAnotherWorld
 *
 * Icon for AnotherWorld tab
 *
 * @author Sparkst3r
 * @since 26 Apr 2014
 */
public class ItemIconAnotherWorld extends Item {

	/** Universal identifier */
	public static final String identifier = "tabicon";
	
	/** Constructor */
	public ItemIconAnotherWorld() {
		super();
		GameRegistry.registerItem(this, identifier);
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
