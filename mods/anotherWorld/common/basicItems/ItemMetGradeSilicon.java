package mods.anotherWorld.common.basicItems;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.ModsExist;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMetGradeSilicon extends BasicItem{
	public static String name = "Metallurgical silicon";
	public ItemMetGradeSilicon(int id) {
		super(id, BasicItems.ItemMetGradeSiliconName, 22);
	}
	
	@Override
	public void func_94581_a(IconRegister iconRegister)
	{
		 iconIndex = iconRegister.func_94245_a("anotherWorld:siliconMet");
	}
}