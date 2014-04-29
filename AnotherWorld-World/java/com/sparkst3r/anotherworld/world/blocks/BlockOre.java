package com.sparkst3r.anotherworld.world.blocks;

import com.sparkst3r.anotherworld.core.AnotherWorldTab;
import com.sparkst3r.anotherworld.core.GlobalValues;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * BlockOre
 * 
 * <p>World Ores</p>
 * 
 * Copper, Tin, Silver, Lead
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 8 Mar 2014
 */
public class BlockOre extends Block {

		
	/**
	 * Icon array of textures
	 */
	@SideOnly(Side.CLIENT)
	private IIcon[] iconBuffer;

	/** 
	 * Constructor 
	 */
	public BlockOre() {
		super(Material.rock);
		GameRegistry.registerBlock(this, ItemBlockOre.class, ItemBlockOre.identifier);
		this.setCreativeTab(AnotherWorldTab.TAB);
		
		this.setHardness(4F);
		this.setHarvestLevel("pickaxe", 1, ItemBlockOre.COPPERORE);
		this.setHarvestLevel("pickaxe", 1, ItemBlockOre.TINORE);
		this.setHarvestLevel("pickaxe", 2, ItemBlockOre.SILVERORE);
		this.setHarvestLevel("pickaxe", 2, ItemBlockOre.LEADORE);
	}
	
	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister ir) {
		iconBuffer = new IIcon[ItemBlockOre.types.length];
		for (int icon = 0; icon < ItemBlockOre.types.length; icon++) {
			iconBuffer[icon] = ir.registerIcon(GlobalValues.MODIDWORLD + ":" + ItemBlockOre.types[icon]);
		}
	}
    
	
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		return (meta < ItemBlockOre.types.length) ? iconBuffer[meta] : iconBuffer[0];
	}
	
	/** The damage value of the ItemStack dropped. */
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
}