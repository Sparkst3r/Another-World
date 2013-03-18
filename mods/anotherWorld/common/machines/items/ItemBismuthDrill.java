package mods.anotherWorld.common.machines.items;

import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.basicItems.BasicItem;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBismuthDrill extends BasicItem {
	private static String iconTex;
	public ItemBismuthDrill(int id, String icon) {
		super(id, MachineItems.ItemBismuthDrillName);
		iconTex = icon;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void func_94581_a(IconRegister iconRegister)
    {
        iconIndex = iconRegister.func_94245_a(AnotherWorld.modID +":"+ iconTex);
    }
}
