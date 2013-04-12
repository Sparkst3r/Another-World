package mods.AnotherWorld.Client;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.AnotherWorld.Mechanical.MechanicalValues;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * Creative Tab For AnotherWorld
 * 
 * @author Sparkst3r
 *
 */
public class AnotherWorldTab extends CreativeTabs {

	/**
	 * Creative Tab For AnotherWorld
	 * @author Sparkst3r
	 *
	 */
	public AnotherWorldTab(int tabId, String tabName) {
		super(tabId, tabName);
		LanguageRegistry.instance().addStringLocalization("itemGroup.AnotherWorld", "en_US", "Another World");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(MechanicalValues.ItemToolField, 1, 0);
	}

}