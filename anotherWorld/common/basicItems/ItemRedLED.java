package anotherWorld.common.basicItems;

import anotherWorld.common.AnotherWorld;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;



public class ItemRedLED extends Item{
	public static String name = "Red LED";
	public ItemRedLED(int id) {
		super(id);
		this.setCreativeTab(anotherWorld.common.AnotherWorld.TabAW);
		this.setItemName(name);
		this.setIconIndex(1);
		GameRegistry.registerItem(this, name);
		LanguageRegistry.addName(this, name);
	}
	public String getTextureFile() {
		return AnotherWorld.itemTex;
	}


}
