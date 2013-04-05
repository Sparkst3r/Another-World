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

	/**
	 * Constructor
	 * @param id
	 */
	public ItemBlockMechanicsTableParts(int id) {
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
		
	
	public int getMetadata(int meta) {
		return meta;
	}
	
	public String getItemNameIS(ItemStack is) {
		String[] types = {"blockTable1","blockTable2","blockTable3","blockTable4"};
		return types[is.getItemDamage()];
	}

}
