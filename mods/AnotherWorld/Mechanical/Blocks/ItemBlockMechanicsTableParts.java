package mods.AnotherWorld.Mechanical.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.AnotherWorld.Mechanical.MechanicalValues;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

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
