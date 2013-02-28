package anotherWorld.common.basicItems;

import java.util.List;

import anotherWorld.common.AnotherWorld;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;



public class ItemRedLED extends Item{
	public static String name = "Red LED";
	public ItemRedLED(int id) {
		super(id);
		this.setCreativeTab(anotherWorld.common.AnotherWorld.TabAW);
		this.setItemName(name);
		this.setTextureFile(AnotherWorld.itemTex);
		this.setIconIndex(16);
		GameRegistry.registerItem(this, name);
		LanguageRegistry.addName(this, name);
	}
}