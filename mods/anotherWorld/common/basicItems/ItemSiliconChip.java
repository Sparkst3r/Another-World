package mods.anotherWorld.common.basicItems;

import net.minecraft.client.renderer.texture.IconRegister;

public class ItemSiliconChip extends BasicItem{
	public ItemSiliconChip(int id) {
		super(id, BasicItems.ItemSiliconChipName, 21);
	}
	
	@Override
	public void func_94581_a(IconRegister iconRegister)
	{
		 iconIndex = iconRegister.func_94245_a("anotherWorld:chip");
	}
}
