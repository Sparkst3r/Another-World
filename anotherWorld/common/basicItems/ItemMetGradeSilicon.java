package anotherWorld.common.basicItems;

import anotherWorld.AnotherWorld;
import anotherWorld.common.ModsExist;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemMetGradeSilicon extends BasicItem{
	public static String name = "Metallurgical silicon";
	public ItemMetGradeSilicon(int id) {
		super(id, BasicItems.ItemMetGradeSiliconName, 22);
	}
}