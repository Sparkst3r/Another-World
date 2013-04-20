package mods.anotherworld.world.blocks;

import mods.anotherworld.core.GlobalValues;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOre extends Block {
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private Icon[] iconBuffer;

	/**
	 * Constructor
	 * @param id
	 * @param material
	 */
	public BlockOre(int id) {
		super(id, Material.rock);
		this.setHardness(6F);
		GameRegistry.registerBlock(this, ItemBlockOre.class, "BlockOre");
		this.setCreativeTab(GlobalValues.AnotherTab);
	}
	
	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[4];
    	
		String id = GlobalValues.ModIDCore + ":"; 
		iconBuffer[0] = ir.registerIcon(id + "oreCopper");
		iconBuffer[1] = ir.registerIcon(id + "oreTin");
		iconBuffer[2] = ir.registerIcon(id + "oreSilver");
		iconBuffer[3] = ir.registerIcon(id + "oreLead");
	}
    
	
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		//If the meta is less than 4, stops ArrayIndexOutOfBoundsExceptions
		return (meta < 4)? iconBuffer[meta] : iconBuffer[0];
	}
	
}
