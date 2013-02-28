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



public class ItemGreenLED extends Item{
	public static String name = "Green LED";
	public ItemGreenLED(int id) {
		super(id);
		this.setCreativeTab(anotherWorld.common.AnotherWorld.TabAW);
		this.setItemName(name);
		this.setTextureFile(AnotherWorld.itemTex);
		this.setIconIndex(17);
		GameRegistry.registerItem(this, name);
		LanguageRegistry.addName(this, name);
	}
}