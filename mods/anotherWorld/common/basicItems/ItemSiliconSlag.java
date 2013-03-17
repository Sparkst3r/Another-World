package mods.anotherWorld.common.basicItems;

import net.minecraft.client.renderer.texture.IconRegister;

public class ItemSiliconSlag extends BasicItem{
	public ItemSiliconSlag(int id) {
		super(id, BasicItems.ItemSiliconSlagName, 20);
	}
	
	@Override
	public void func_94581_a(IconRegister iconRegister)
	{
		 iconIndex = iconRegister.func_94245_a("anotherWorld:siliconSlag");
	}
}

