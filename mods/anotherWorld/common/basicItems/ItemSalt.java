package mods.anotherWorld.common.basicItems;

import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.Base.BasicItem;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSalt extends BasicItem{
	private static String iconTex;
	public ItemSalt(int id, String icon) {
		super(id, BasicItems.ItemSaltName);
		iconTex = icon;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
        this.iconIndex = par1IconRegister.registerIcon(AnotherWorld.modID +":"+ iconTex);
    }

}
