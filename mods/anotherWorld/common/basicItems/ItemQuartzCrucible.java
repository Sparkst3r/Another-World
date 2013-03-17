package mods.anotherWorld.common.basicItems;

import net.minecraft.client.renderer.texture.IconRegister;

public class ItemQuartzCrucible extends BasicItem {

	public ItemQuartzCrucible(int id) {
		super(id, BasicItems.ItemQuartzCrucibleName, 23);
	}
	
	@Override
	public void func_94581_a(IconRegister iconRegister)
	{
		 iconIndex = iconRegister.func_94245_a("anotherWorld:crucibleQuartz");
	}

}
