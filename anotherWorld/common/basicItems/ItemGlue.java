package anotherWorld.common.basicItems;

import anotherWorld.common.ModsExist;
import ic2.api.Items;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemGlue extends Item{
	public static String name = "Glue";
	public ItemGlue(int id) {
		super(id);
		this.setCreativeTab(anotherWorld.common.AnotherWorld.TabAW);
		this.setItemName(name);
		this.setIconIndex(1);
		addCrafting();
		GameRegistry.registerItem(this, name);
		LanguageRegistry.addName(this, name);
	}
	
	private void addCrafting() {
		if (ModsExist.ic2Exists) {
			GameRegistry.addRecipe(new ItemStack(this), new Object[]{
				"SRS", "RGR", "SRS", 
				'S', Item.slimeBall, 'R', Items.getItem("resin"), 'G', Item.glassBottle 
			});
		}

		
	}

	public String getTextureFile() {
		return "/anotherWorld/gfx/items.png"; 
	}

}
