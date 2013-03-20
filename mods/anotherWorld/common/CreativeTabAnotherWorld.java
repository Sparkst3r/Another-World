package mods.anotherWorld.common;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.anotherWorld.common.machines.Machines;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabAnotherWorld extends CreativeTabs {

	public CreativeTabAnotherWorld(int tabId, String tabName) {
		super(tabId, tabName);
		LanguageRegistry.instance().addStringLocalization("itemGroup.Another World", "en_US", "Another World");
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
	    return Machines.Separator.blockID;
	}

}
