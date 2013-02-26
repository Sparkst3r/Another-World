package anotherWorld.common.basicItems;

import thermalexpansion.api.crafting.ISmelterManager;
import thermalexpansion.api.crafting.ISmelterRecipe;
import anotherWorld.common.AnotherWorld;
import anotherWorld.common.ModsExist;
import ic2.api.Items;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSiliconChip extends Item{
	public static int energyToSmelt = 80;
	public static String name = "Silicon Chip";
	public ItemSiliconChip(int id) {
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
