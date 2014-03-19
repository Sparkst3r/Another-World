package com.sparkst3r.anotherworld.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.sparkst3r.anotherworld.mechanical.MechanicalValues;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * AnotherWorldTab
 * 
 * Creative tab for AnotherWorld
 * 
 * @author Sparkst3r
 *
 */
public class AnotherWorldTab extends CreativeTabs {

	/** Creative Tab instance */
	public static final CreativeTabs TAB = new AnotherWorldTab(CreativeTabs.getNextID(), "anotherworld");
	
	
	/**
	 * Creative Tab For AnotherWorld
	 * @author Sparkst3r
	 * @param tabId the ID of the tab
	 * @param tabName the unlocalised tab name
	 *
	 */
	public AnotherWorldTab(int tabId, String tabName) {
		super(tabId, tabName);
	}
	
	/**
	 * The icon to be rendered as the icon of the tab
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return MechanicalValues.itemTinkeringTool;
	}
}