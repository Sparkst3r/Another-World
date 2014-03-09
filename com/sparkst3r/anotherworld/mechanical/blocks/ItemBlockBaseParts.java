package com.sparkst3r.anotherworld.mechanical.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * ItemBlockBaseParts
 *
 * Item block for the Mechanics Expansion basic block based parts.
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 16 Feb 2014
 */
public class ItemBlockBaseParts extends ItemBlock{
	
	/** Internal unlocalised names used for registering the blocks and for their textures */
	public static String[] types = {"stoneSmooth", "blockMechanic", "blockMechanicAdv"};

	public static String identifier = "mechBaseBlocks";
	
	public ItemBlockBaseParts(Block block) {
		super(block);
		
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
	
	/**
	 * Returns the metadata of the block which this Item (ItemBlock) can place.
	 */
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	/** Returns the unlocalised name of the stack passed */
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return identifier + "." + types[stack.getItemDamage()];
	}
	
	/**
	 * Adds the items to the creative tab.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int meta = 0; meta < types.length; meta++) {
			list.add(new ItemStack(item, 1, meta));
		}
	}
}