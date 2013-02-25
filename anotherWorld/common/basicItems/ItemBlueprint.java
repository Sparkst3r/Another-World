package anotherWorld.common.basicItems;

import anotherWorld.common.ModsExist;
import ic2.api.Items;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBlueprint extends Item{
	public static String name = "Blueprint";
	public ItemBlueprint(int id) {
		super(id);
		this.setCreativeTab(anotherWorld.common.AnotherWorld.TabAW);
		this.setItemName(name);
		this.setIconIndex(0);
		addCrafting();
		GameRegistry.registerItem(this, name);
		LanguageRegistry.addName(this, name);
	}
	
	private void addCrafting() {
		if (ModsExist.ic2Exists) {
			GameRegistry.addRecipe(new ItemStack(this), new Object[]{
				"BGB", "G G", "BGB", 
				'B', BasicItems.BlueprintPart, 'G', BasicItems.Glue
			});
		}
	}

	public String getTextureFile() {
		return "/anotherWorld/gfx/items.png"; 
	}

}