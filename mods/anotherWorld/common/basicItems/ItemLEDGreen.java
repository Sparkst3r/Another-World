package mods.anotherWorld.common.basicItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.Base.BasicItem;
import net.minecraft.client.renderer.texture.IconRegister;

public class ItemLEDGreen extends BasicItem{
	private static String iconTex;
	public ItemLEDGreen(int id, String icon) {
		super(id, BasicItems.ItemLEDGreenName);
		iconTex = icon;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
        this.iconIndex = par1IconRegister.registerIcon(AnotherWorld.modID +":"+ iconTex);
    }
}