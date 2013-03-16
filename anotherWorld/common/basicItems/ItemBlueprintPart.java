package anotherWorld.common.basicItems;

import anotherWorld.AnotherWorld;
import anotherWorld.common.ModsExist;
import ic2.api.Items;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBlueprintPart extends BasicItem{
	
	public ItemBlueprintPart(int id) {
		super(id, BasicItems.ItemBlueprintPartName, 2);
	}
}