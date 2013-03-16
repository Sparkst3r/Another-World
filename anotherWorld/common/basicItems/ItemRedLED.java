package anotherWorld.common.basicItems;

import java.util.List;

import anotherWorld.AnotherWorld;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;



public class ItemRedLED extends BasicItem{
	public ItemRedLED(int id) {
		super(id, BasicItems.ItemRedLEDName, 16);
		
	}
}