package mods.anotherWorld.common.basicItems;

import net.minecraft.client.renderer.texture.IconRegister;

public class ItemSiliconSlice extends BasicItem {

	public ItemSiliconSlice(int id) {
		super(id, BasicItems.ItemSiliconSliceName, 24);
	}
	
	@Override
	public void func_94581_a(IconRegister iconRegister)
	{
		 iconIndex = iconRegister.func_94245_a("anotherWorld:siliconSlice");
	}

}