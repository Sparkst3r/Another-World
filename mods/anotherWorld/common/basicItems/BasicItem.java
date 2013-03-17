package mods.anotherWorld.common.basicItems;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.Config;
import net.minecraft.item.Item;

public class BasicItem extends Item
{
	public BasicItem(int id, String name, int idInTexture)
	{
		super(AnotherWorld.configAW.getItem(name, id).getInt(id));
		this.setUnlocalizedName(name);
		this.setCreativeTab(AnotherWorld.TabAW);
		GameRegistry.registerItem(this, name);
		LanguageRegistry.addName(this, name);
	}
}