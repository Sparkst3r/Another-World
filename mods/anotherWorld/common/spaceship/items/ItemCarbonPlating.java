package mods.anotherWorld.common.spaceship.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.Base.BasicItem;
import mods.anotherWorld.common.spaceship.blocks.SpaceshipBlocks;

public class ItemCarbonPlating extends BasicItem {

	private String iconTex;

	public ItemCarbonPlating(int id, String name, String icon) {
		super(id, name);
		this.iconTex = icon;
	}
	
	
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int par7, float xFloat, float yFloat, float zFloat)
	{
		//Can the player alter this block?
		if (!player.canPlayerEdit(x, y, z, par7, item)) {
			return false;
		}
		//Was the block clicked on an iron block?
		if(world.getBlockId(x, y, z) == Block.blockSteel.blockID){
			//Set the block to a carbon block and take 1 from the stack size. 
			world.setBlock(x, y, z, SpaceshipBlocks.CarbonBlockID, 0, 2);
			item.stackSize = item.stackSize - 1;
			 return true;
		}
		 return false;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister)
    {
        this.iconIndex = par1IconRegister.registerIcon(AnotherWorld.modID +":"+ iconTex);
    }

}
