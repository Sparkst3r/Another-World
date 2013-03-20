package mods.anotherWorld.common.basicItems;

import mods.anotherWorld.AnotherWorld;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemForkk extends BasicItem{
	private static String iconTex;
	public ItemForkk(int id, String icon) {
		super(id, BasicItems.ItemForkkName);
		iconTex = icon;
	}
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	par3EntityPlayer.sendChatToPlayer("Yup, Forkk is an arsehole!");
        return par1ItemStack;
    }
	
	
    @Override
    @SideOnly(Side.CLIENT)
    public void func_94581_a(IconRegister iconRegister)
    {
        iconIndex = iconRegister.func_94245_a(AnotherWorld.modID +":"+ iconTex);
    }
}