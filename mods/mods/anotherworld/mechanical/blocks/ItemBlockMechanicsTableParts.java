package mods.anotherworld.mechanical.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Item-Block class for the meta data Table blocks.
 * @author Sparkst3r
 *
 */
public class ItemBlockMechanicsTableParts extends ItemBlock{
	String[] types = {"blockTableTL","blockTableTR","blockTableBL","blockTableBR"};
	/**
	 * Constructor
	 * @param id
	 */
	public ItemBlockMechanicsTableParts(int id) {
		super(id);
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
}
