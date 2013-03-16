package anotherWorld.common.basicItems;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import anotherWorld.AnotherWorld;
import anotherWorld.common.Config;
import net.minecraft.item.Item;

public class BasicItem extends Item
{
	public BasicItem(int id, String name, int idInTexture)
	{
		super(AnotherWorld.configAW.getItem(name, id).getInt(id));
		this.setItemName(name);
		this.setCreativeTab(AnotherWorld.TabAW);
		this.setTextureFile(AnotherWorld.itemTex);
		this.setIconIndex(idInTexture);
		GameRegistry.registerItem(this, name);
		LanguageRegistry.addName(this, name);
	}
}
