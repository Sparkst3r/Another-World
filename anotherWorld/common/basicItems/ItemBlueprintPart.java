package anotherWorld.common.basicItems;

import anotherWorld.common.ModsExist;
import ic2.api.Items;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBlueprintPart extends Item{
	public static String name = "Blueprint Part";
	public ItemBlueprintPart(int id) {
		super(id);
		this.setCreativeTab(anotherWorld.common.AnotherWorld.TabAW);
		this.setItemName(name);
		this.setIconIndex(2);
		GameRegistry.registerItem(this, name);
		LanguageRegistry.addName(this, name);
	}

	public String getTextureFile() {
		return "/anotherWorld/gfx/items.png"; 
	}

}