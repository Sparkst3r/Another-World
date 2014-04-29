package com.sparkst3r.anotherworld.mechanical.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.sparkst3r.anotherworld.api.tool.IToolDismantleable;
import com.sparkst3r.anotherworld.core.AnotherWorldTab;
import com.sparkst3r.anotherworld.core.GlobalValues;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * Meta-based block for the sides of the Mechanics Table
 * 
 * @author Sparkst3r
 *
 */
public class BlockMechBaseParts extends Block implements IToolDismantleable {
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private IIcon[] iconBuffer;

	/**
	 * Constructor
	 * @param id
	 */
	public BlockMechBaseParts() {
		super(GlobalValues.IMMOVABLE);
		GameRegistry.registerBlock(this, ItemBlockMechBaseParts.class, ItemBlockMechBaseParts.identifier);
		this.setCreativeTab(AnotherWorldTab.TAB);
		this.setHardness(0.5F);
		
	}

	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister ir) {
		iconBuffer = new IIcon[ItemBlockMechBaseParts.types.length];
		for (int icon = 0; icon < ItemBlockMechBaseParts.types.length; icon++) {
			iconBuffer[icon] = ir.registerIcon(GlobalValues.TEXTURE + ItemBlockMechBaseParts.types[icon]);
		}
	}
    
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		return (meta < 3) ? iconBuffer[meta] : iconBuffer[0];
	}
   
	/** Allows for metadata specific hardness values */
	@Override
	public float getBlockHardness(World world, int x, int y, int z) {
		switch(world.getBlockMetadata(x, y, z)) {
			case 0:
				return 3.0F;
			case 1:
				return 4.0F;
			case 2:
				return 1000F;
			default:
				return this.blockHardness;
		}
    }
	
	@Override
	public int damageDropped(int meta) {
		switch(meta) {
			case 0:
				return 0;
			case 1:
				return 0;
			default:
				return meta;
		}
	}
	
	
	/** Can this block be dismantled */
	@Override
	public boolean canDismantle(EntityPlayer player, World world, int x, int y, int z) {
		switch(world.getBlockMetadata(x, y, z)) {
			case 0 :
				return false;
			case 1 : 
				return true;
			case 2 : 
				return true;
		}
		return false;
	}

	/** On dismantled by a Tinkering tool*/
	@Override
	public ItemStack dismantle(EntityPlayer player, World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		return new ItemStack(world.getBlock(x, y, z), 1, meta);
	}

	//TODO Install and fix CoFH references 
	///** On dismantled by a CoFH Crescent Hammer */
	//@Override
	//public ItemStack dismantleBlock(EntityPlayer thePlayer, World world, int x, int y, int z, boolean returnBlock) {
	//	return this.dismantle(thePlayer, world, x, y, z);
	//}
}