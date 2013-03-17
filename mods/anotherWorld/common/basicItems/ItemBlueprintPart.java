package mods.anotherWorld.common.basicItems;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.ModsExist;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBlueprintPart extends BasicItem{
	
	public ItemBlueprintPart(int id) {
		super(id, BasicItems.ItemBlueprintPartName, 2);
	}
}