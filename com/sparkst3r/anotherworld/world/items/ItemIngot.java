package com.sparkst3r.anotherworld.world.items;


import java.util.List;

import com.sparkst3r.anotherworld.core.AnotherWorldTab;
import com.sparkst3r.anotherworld.core.GlobalValues;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * ItemIngot
 * 
 * <p>World Ingots<p>
 * 
 * Copper, Tin, Silver, Lead
 * 
 * <p>World dusts<p>
 * 
 * Copper, Tin, Silver, Lead, Iron, Gold
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 16 Feb 2014
 */
public class ItemIngot extends Item {
	
	/** Universal identifier */
	public static final String identifier = "worldIngots";
	
	/** Copper meta value */
	public static final int COPPER = 0;
	/** Tin meta value */
	public static final int TIN = 1;
	/** Silver meta value */
	public static final int SILVER = 2;
	/** Lead meta value */
	public static final int LEAD = 3;
	
	/** Copper dust meta value */
	public static final int COPPERDUST = 4;
	/** Tin dust meta value */
	public static final int TINDUST = 5;
	/** Silver dust meta value */
	public static final int SILVERDUST = 6;
	/** Lead dust meta value */
	public static final int LEADDUST = 7;
	/** Iron dust meta value */
	public static final int IRONDUST = 8;
	/** Gold dust meta value */
	public static final int GOLDDUST = 9;
	
	/** Unlocalised names */
	public static final String[] types = new String[] {"ingotCopper", "ingotTin", "ingotSilver", "ingotLead", "dustCopper", "dustTin", "dustSilver", "dustLead", "dustIron", "dustGold"};     
	
	/** Icon Array */
	@SideOnly(Side.CLIENT)
	private IIcon[] iconBuffer = new IIcon[types.length];

	/** Constructor */
	public ItemIngot() {
		super();
        this.setCreativeTab(AnotherWorldTab.TAB);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		GameRegistry.registerItem(this, identifier);
		this.addOreDictionarySupport();
	}
	
	/** Register OreDictionary names */
	private void addOreDictionarySupport() {
		for (int type = 0; type < types.length; type++) {
			OreDictionary.registerOre(types[type], new ItemStack(this, 1, type));
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
	
	/** Returns the unlocalised name of the itemstack */
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return "item." + identifier + "." + types[is.getItemDamage()];
	}

}
