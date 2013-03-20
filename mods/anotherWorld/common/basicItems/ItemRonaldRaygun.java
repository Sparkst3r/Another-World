package mods.anotherWorld.common.basicItems;

import mods.anotherWorld.AnotherWorld;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRonaldRaygun extends BasicItem {
	//Caden requested this item!
	private static String iconTex;
	public ItemRonaldRaygun(int id, String icon) {
		super(id, BasicItems.ItemRaygunName);
		iconTex = icon;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void func_94581_a(IconRegister iconRegister)
    {
        iconIndex = iconRegister.func_94245_a(AnotherWorld.modID +":"+ iconTex);
    }

}
