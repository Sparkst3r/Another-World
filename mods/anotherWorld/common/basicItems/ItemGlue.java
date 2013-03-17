package mods.anotherWorld.common.basicItems;

import net.minecraft.client.renderer.texture.IconRegister;

public class ItemGlue extends BasicItem{
	public ItemGlue(int id) {
		super(id, BasicItems.ItemGlueName, 1);
	}
	
	@Override
	public void func_94581_a(IconRegister iconRegister)
	{
		 iconIndex = iconRegister.func_94245_a("anotherWorld:glue");
	}

}
