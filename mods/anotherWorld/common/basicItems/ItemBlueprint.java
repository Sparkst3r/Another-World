package mods.anotherWorld.common.basicItems;

import net.minecraft.client.renderer.texture.IconRegister;

public class ItemBlueprint extends BasicItem{
	public ItemBlueprint(int id) {
		super(id, BasicItems.ItemBlueprintName, 0);
		this.setMaxStackSize(1);
	}
	
	@Override
	public void func_94581_a(IconRegister iconRegister)
	{
		 iconIndex = iconRegister.func_94245_a("anotherWorld:blueprint");
	}
}