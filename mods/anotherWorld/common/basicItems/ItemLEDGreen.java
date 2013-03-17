package mods.anotherWorld.common.basicItems;

import net.minecraft.client.renderer.texture.IconRegister;

public class ItemLEDGreen extends BasicItem{
	public ItemLEDGreen(int id) {
		super(id, BasicItems.ItemGreenLEDName, 17);
		
	}
	
	@Override
	public void func_94581_a(IconRegister iconRegister)
	{
		 iconIndex = iconRegister.func_94245_a("anotherWorld:ledGreen");
	}
}