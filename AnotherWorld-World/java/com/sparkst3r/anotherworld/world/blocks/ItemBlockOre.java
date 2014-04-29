package com.sparkst3r.anotherworld.world.blocks;

import java.util.List;

import com.sparkst3r.anotherworld.world.WorldValues;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/** 
 * ItemBlockOre
 *
 * <p>World ItemBlock Ores</p>
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 8 Mar 2014
 */
public class ItemBlockOre extends ItemBlock {
	
	/** Universal identifier */
	public static final String identifier = "worldBlockOre";

	/** Copper Ore meta */
	public static final int COPPERORE = 0;
	/** Tin Ore meta */
	public static final int TINORE = 1;
	/** Silver Ore meta */
	public static final int SILVERORE = 2;
	/** Lead Ore meta */
	public static final int LEADORE = 3;
	
	/** Copper Storage meta */
	public static final int COPPERSTORE = 4;
	/** Tin Storage meta */
	public static final int TINSTORE = 5;
	/** Silver Storage meta */
	public static final int SILVERSTORE = 6;
	/** Lead Storage meta */
	public static final int LEADSTORE = 7;
	
	/** Unlocalised names */
	public static String[] types = {"oreCopper", "oreTin", "oreSilver", "oreLead", "blockCopper", "blockTin", "blockSilver", "blockLead"};
	
	/** Constructor 
	 * @param block The block that this ItemBlock represents
	 */
	public ItemBlockOre(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		
		//Add Ore Dictionary entries
		int oreMeta = 0;
		for (String identifier : types) {
			OreDictionary.registerOre(identifier, new ItemStack(WorldValues.blockOre, 1, oreMeta));
			oreMeta++;
		}
	}
	
	/** Returns the unlocalised name of the itemstack */
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return "tile." + identifier + "." + types[is.getItemDamage()];
	}
	
	/** Sub items of this ItemBlock */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int meta = 0; meta < types.length; meta++) {
			list.add(new ItemStack(item, 1, meta));
		}
	}
	
	/** Returns the metadata of the block which this Item (ItemBlock) can place */
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
}