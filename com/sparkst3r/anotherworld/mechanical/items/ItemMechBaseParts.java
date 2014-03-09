package com.sparkst3r.anotherworld.mechanical.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.sparkst3r.anotherworld.core.AnotherWorldTab;
import com.sparkst3r.anotherworld.core.GlobalValues;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Meta-data item for the base parts.
 * 
 * @author Sparkst3r
 * 
 */
public class ItemMechBaseParts extends Item {
	
	/** Universal identifier */
	public String identifier = "mechItemBaseParts";
	
	/** Basic Gear meta value */
	public static final int GEARBASIC = 0;
	/** Copper Gear meta value */
	public static final int GEARCOPPER = 1;
	/** Tin Gear meta value */
	public static final int GEARTIN = 2;
	/** Tinkering tool head meta value */
	public static final int TINKERHEAD = 3;
	/** Tinkering tool rod meta value */
	public static final int TINKERROD = 4;
	/** Tinkering tool grip meta value */
	public static final int TINKERGRIP = 5;
	/** Tinkering tool head meta value */
	public static final int COARSEQUARTZDUST = 6;
	/** Tinkering tool head meta value */
	public static final int FINEQUARTZDUST = 7;
	
	/** Texture file names + code name */
	public static String[] types = new String[] {"gearBasic", "gearCopper", "gearTin", "tinkerHead", "tinkerRod", "tinkerGrip", "dustQuartzCoarse", "dustQuartzFine"};     
	
	/** Icon Array */
	@SideOnly(Side.CLIENT)
	private IIcon[] iconBuffer = new IIcon[types.length];;

	/** Constructor */
	public ItemMechBaseParts() {
		super();
        this.setCreativeTab(AnotherWorldTab.TAB);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		GameRegistry.registerItem(this, identifier);
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
		for (int icon = 0; icon < types.length; icon++) {
			iconBuffer[icon] = ir.registerIcon(GlobalValues.MODIDCORE + ":" + types[icon]);
		}
	}

	/** Adds the meta items to the tab */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int meta = 0; meta < types.length; meta++) {
			list.add(new ItemStack(item, 1, meta));
		}
	} 
	
	/** Returns the unlocalised name of the item */
	@Override
	public String getUnlocalizedName(ItemStack is) {
		//Returns in the format eg. "item.worldIngots.ingotCopper"
		return "item." + identifier + "." + types[is.getItemDamage()];
	}

}