package mods.AnotherWorld.Mechanical.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.AnotherWorld.Core.GlobalValues;
import mods.AnotherWorld.Util.BasicItem;

public class ItemWormhole extends BasicItem {
	private static String iconTex;
	private boolean isFull = false;
	private TileEntity tempNBT;
	
	public ItemWormhole(int id, String name, String identifier) {
		super(id, name, identifier);
		iconTex = identifier;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister ir) {
        this.iconIndex = ir.registerIcon(GlobalValues.ModIDCore +":"+ iconTex);
    }
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		if( stack.stackTagCompound == null) {
			stack.setTagCompound(new NBTTagCompound());
		}
		
		
		if (isFull) {
		}
		else {
			tempNBT = world.getBlockTileEntity(x, y, z);
		
		}
		
		return false;
		
	}
	
}
