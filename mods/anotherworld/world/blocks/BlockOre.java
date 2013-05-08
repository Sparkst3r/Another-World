package mods.anotherworld.world.blocks;

import mods.anotherworld.core.GlobalValues;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.common.MinecraftForge;
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
		this.setHardness(4F);
		GameRegistry.registerBlock(this, ItemBlockOre.class, "BlockOre");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 1);
		this.setCreativeTab(GlobalValues.AnotherTab);
	}
	
	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[ItemBlockOre.types.length];
		String id = GlobalValues.ModIDCore + ":"; 
		for (int icon = 0; icon < ItemBlockOre.types.length; icon++) {
			iconBuffer[icon] = ir.registerIcon(id + ItemBlockOre.types[icon]);
		}
	}
	// Drops the metadata block
	public int damageDropped(int metadata)
    {
        return metadata;
    }
    
	
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		//If the meta is less than 4, stops ArrayIndexOutOfBoundsExceptions
		return (meta < ItemBlockOre.types.length)? iconBuffer[meta] : iconBuffer[0];
	}
	
}
