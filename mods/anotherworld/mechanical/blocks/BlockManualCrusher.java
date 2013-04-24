package mods.anotherworld.mechanical.blocks;

import mods.anotherworld.mechanical.tileentity.TileManualCrusher;
import mods.anotherworld.util.EntityUtils;
import mods.anotherworld.util.ItemStackUtils;
import mods.anotherworld.util.basic.BasicBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockManualCrusher extends BasicBlock {

	/**
	 * Icon Buffer
	 */
	@SideOnly(Side.CLIENT)
	public static Icon[] iconBuffer;
	
	public String[] sides = new String[] {"","","","","",""};
	
	/**
	 * Constructor
	 * @param id
	 */
	public BlockManualCrusher(int id) {
		super(id, Material.rock, "Hand Cranked Crusher", "blockHandCrusher");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par5) {
		TileManualCrusher te = (TileManualCrusher) world.getBlockTileEntity(x, y, z); 
		
		if(!world.isRemote) {
			if (player.isSneaking() && te.inv[0] != null) {
				System.out.println(te.inv[0].getItemName());
				EntityUtils.dropItemInWorld(world, x, y, z, te.inv[0]);
				te.inv[0] = null;
			}
			else {
				if (te.inv[0] != null && player.getCurrentEquippedItem() != null && ItemStackUtils.areStacksOfSameType(te.inv[0], player.getCurrentEquippedItem())) {
					int spaceLeft = 4 - te.inv[0].stackSize;
					ItemStack tempStack = player.getCurrentEquippedItem().copy();

					
					if (tempStack.stackSize > 4) {
						tempStack.stackSize = 4;
					}
					tempStack.stackSize = tempStack.stackSize;
					
					
					te.inv[0].stackSize += tempStack.stackSize;
					
					player.getCurrentEquippedItem().stackSize -= spaceLeft;
				}
				else if (te.inv[0] == null) {
					if (player.getCurrentEquippedItem() != null){
						ItemStack stack = player.getCurrentEquippedItem().copy();
						if (stack.stackSize > 4) {
							stack.stackSize = 4;
						}
						System.out.println(stack.getItemName());
						te.inv[0] = stack;
						System.out.println(te.inv[0].getItemName());
						player.getCurrentEquippedItem().stackSize -= stack.stackSize;
						return true;
						}
					}

				}
			}
		return false;
		
	}
	
	/** Is the meta block allowed to have a tile entity? */
	@Override
	public boolean hasTileEntity(int meta) {
		return true;
	}
    
	/** Will create a tile entity if hasTileEntity(meta) resolves as true for the metadata passed*/
	@Override
	public TileEntity createTileEntity(World world, int meta){
		return new TileManualCrusher();
	}
	
	
}
