package mods.anotherworld.mechanical.blocks;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * ItemBlockBaseParts
 * 
 * Item block for the Mechanics Expansion basic block based parts.
 * 
 * @author Sparkst3r
 *
 */
public class ItemBlockBaseParts extends ItemBlock{
	
	/** Internal unlocalised names used for registering the blocks and for their textures */
	public static String[] types = {"stoneSmooth", "blockMechanic", "blockMechanicAdv"};
	
	/** Human readable names */
	public static String[] names = {"Smooth Stone", "Mechanical Block", "Advanced Mechanics Block"};
	
	public ItemBlockBaseParts(int id) {
		super(id);
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
		return types[stack.getItemDamage()];
	}
	
	/**
	 * Adds the items to the creative tab.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < types.length; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	}
}