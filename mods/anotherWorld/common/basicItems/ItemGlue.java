package mods.anotherWorld.common.basicItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.anotherWorld.AnotherWorld;
import net.minecraft.client.renderer.texture.IconRegister;

public class ItemGlue extends BasicItem{
	private static String iconTex;
	public ItemGlue(int id, String icon) {
		super(id, BasicItems.ItemGlueName);
		iconTex = icon;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void func_94581_a(IconRegister iconRegister)
    {
        iconIndex = iconRegister.func_94245_a(AnotherWorld.modID +":"+ iconTex);
    }
}