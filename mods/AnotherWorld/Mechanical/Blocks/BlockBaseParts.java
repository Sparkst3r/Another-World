package mods.AnotherWorld.Mechanical.Blocks;

import java.util.Random;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.AnotherWorld.Core.AnotherWorld;
import mods.AnotherWorld.Core.GlobalValues;
import mods.AnotherWorld.Mechanical.TileEntity.TileMechanicsTable;
import mods.AnotherWorld.Mechanical.Util.MechanicsTableValidation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;


/**
 * Meta-based block for the sides of the Mechanics Table
 * 
 * @author Sparkst3r
 *
 */
public class BlockBaseParts extends Block{
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private Icon[] iconBuffer;

	/**
	 * Constructor
	 * @param id
	 */
	public BlockBaseParts(int id) {
		super(id, GlobalValues.immovable);
		this.setCreativeTab(GlobalValues.AnotherTab);
		this.setHardness(0.5F);
		GameRegistry.registerBlock(this, ItemBlockBaseParts.class, "MechanicalBaseBlocks");
	}

	
	
	
	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[2];
    	
		String id = GlobalValues.ModIDCore + ":"; 
		
		iconBuffer[0] = ir.registerIcon(id + ItemBlockBaseParts.types[0]);
		iconBuffer[1] = ir.registerIcon(id + ItemBlockBaseParts.types[1]);
	}
    
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int side, int meta) {
		//If the meta is less than 1, stops ArrayIndexOutOfBoundsExceptions
		return (meta < 2)? iconBuffer[meta] : iconBuffer[0];
	}
   
	/** Allows for metadata specific hardness values */
	public float getBlockHardness(World world, int x, int y, int z) {
		switch(world.getBlockMetadata(x, y, z)) {
			case 0:
				this.setHardness(2.0F);
			case 1:
				this.setHardness(4.0F);
		}
		return this.blockHardness;
    }
}