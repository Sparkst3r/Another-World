package mods.anotherworld.world.blocks;

import mods.anotherworld.core.GlobalValues;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockQuartreSlab extends Block {

		
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private Icon[] iconBuffer;

	/**
	 * Constructor
	 * @param id
	 * @param material
	 */
	public BlockQuartreSlab(int id) {
		super(id, Material.rock);
		this.setHardness(4F);
		GameRegistry.registerBlock(this, ItemBlockQuartreSlab.class, "blockQuarterSlab");
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 1);
		this.setCreativeTab(GlobalValues.AnotherTab);

	}
	
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);

	}

	
    public boolean isOpaqueCube() {
    	return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }
    
	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[ItemBlockQuartreSlab.types.length];
		
		iconBuffer[0] = ir.registerIcon("stoneslab_top");
		iconBuffer[1] = ir.registerIcon("sandstone_top");
		iconBuffer[2] = ir.registerIcon("stonebrick");
		iconBuffer[3] = ir.registerIcon("brick");
		iconBuffer[4] = ir.registerIcon("stonebricksmooth");
		iconBuffer[5] = ir.registerIcon("netherBrick");
		iconBuffer[6] = ir.registerIcon("quartzblock_top");
		iconBuffer[7] = ir.registerIcon("wood");
		iconBuffer[8] = ir.registerIcon("wood_spruce");
		iconBuffer[9] = ir.registerIcon("wood_birch");
		iconBuffer[10] = ir.registerIcon("wood_jungle");
	}
    
	
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		//If the meta is less than 4, stops ArrayIndexOutOfBoundsExceptions
		return (meta < ItemBlockQuartreSlab.types.length) ? iconBuffer[meta] : iconBuffer[0];
	}
	
}
