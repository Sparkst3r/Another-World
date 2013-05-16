package mods.anotherworld.world.blocks;

import mods.anotherworld.client.AnotherWorldTab;
import mods.anotherworld.core.GlobalValues;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStorage extends Block {
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private Icon[] iconBuffer;

	/**
	 * Constructor
	 * @param id
	 * @param material
	 */
	public BlockStorage(int id) {
		super(id, Material.rock);
		this.setHardness(6F);
		GameRegistry.registerBlock(this, ItemBlockStorage.class, "BlockStorage");
		this.setCreativeTab(AnotherWorldTab.TAB);
	}
	
	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[4];
    	
		String id = GlobalValues.MODIDCORE + ":"; 
		iconBuffer[0] = ir.registerIcon(id + ItemBlockStorage.types[0]);
		iconBuffer[1] = ir.registerIcon(id + ItemBlockStorage.types[1]);
		iconBuffer[2] = ir.registerIcon(id + ItemBlockStorage.types[2]);
		iconBuffer[3] = ir.registerIcon(id + ItemBlockStorage.types[3]);
	}
    
	
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		//If the meta is less than 4, stops ArrayIndexOutOfBoundsExceptions
		return (meta < 4)? iconBuffer[meta] : iconBuffer[0];
	}
	
}