package anotherWorld.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabAnotherWorld extends CreativeTabs {

	public CreativeTabAnotherWorld(int tabId, String tabName) {
		super(tabId, tabName);
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() {
	    return Block.dragonEgg.blockID;
	}

}
