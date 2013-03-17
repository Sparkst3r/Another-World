package mods.anotherWorld.common.basicItems;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.ModsExist;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBlueprintPart extends BasicItem{
	private static String iconTex;
	public ItemBlueprintPart(int id, String icon) {
		super(id, BasicItems.ItemBlueprintPartName);
		iconTex = icon;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void func_94581_a(IconRegister iconRegister)
    {
            iconIndex = iconRegister.func_94245_a(AnotherWorld.modID +":"+ iconTex);
    }
}