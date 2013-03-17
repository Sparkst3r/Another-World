package mods.anotherWorld.common.basicItems;

import net.minecraft.client.renderer.texture.IconRegister;

public class ItemLEDBlue extends BasicItem{
	public ItemLEDBlue(int id) {
		super(id, BasicItems.ItemBlueLEDName, 18);
	}
	
	@Override
	public void func_94581_a(IconRegister iconRegister)
	{
		 iconIndex = iconRegister.func_94245_a("anotherWorld:ledBlue");
	}
}