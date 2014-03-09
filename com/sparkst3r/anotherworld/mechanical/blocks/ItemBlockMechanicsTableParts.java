package com.sparkst3r.anotherworld.mechanical.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Item-Block class for the meta data Table blocks.
 * @author Sparkst3r
 *
 */
public class ItemBlockMechanicsTableParts extends ItemBlock{
	String[] types = {"blockTableTL", "blockTableTR", "blockTableBL", "blockTableBR"};
	/**
	 * Constructor
	 * @param id
	 */
	public ItemBlockMechanicsTableParts(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
		
	/** Returns the metadata  of the block*/
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	/** Returns the unlocalised name based on the itemstack passed */
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return types[is.getItemDamage()];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int meta = 0; meta < types.length; meta++) {
			list.add(new ItemStack(item, 1, meta));
		}
	} 
}
