package mods.anotherWorld.common.basicItems;

import net.minecraft.client.renderer.texture.IconRegister;

public class ItemSiliconBoule extends BasicItem {

	public ItemSiliconBoule(int id) {
		super(id, BasicItems.ItemSiliconBouleName, 24);
	}
	
	@Override
	public void func_94581_a(IconRegister iconRegister)
	{
		 iconIndex = iconRegister.func_94245_a("anotherWorld:siliconBoule");
	}

}
