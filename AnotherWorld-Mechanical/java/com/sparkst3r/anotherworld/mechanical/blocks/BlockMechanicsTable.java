package com.sparkst3r.anotherworld.mechanical.blocks;

import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.mechanical.AnotherWorldExpansionMechanical;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileMechanicsTable;
import com.sparkst3r.anotherworld.util.EntityUtils;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * Meta-based block for the sides of the Mechanics Table
 * 
 * @author Sparkst3r
 *
 */
public class BlockMechanicsTable extends Block{
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private IIcon[][] iconBuffer;
    
	/**
	 * Constructor
	 * @param id
	 */
	public BlockMechanicsTable() {
		super(GlobalValues.IMMOVABLE);
		this.setBlockUnbreakable();
		GameRegistry.registerBlock(this, ItemBlockMechanicsTableParts.class, "MechanicsTable");
	}
	
	/** Called when the block is broken. Drops the contents of the TileEntity when a block is broken */
	public void breakBlock(World world, int x, int y, int z, int block, int meta) {
		if(meta == 0) {
			TileMechanicsTable tile = (TileMechanicsTable) world.getTileEntity(x, y, z);
			if (tile != null) {
				for (int slot = 0; slot < tile.getSizeInventory(); slot++) {
					ItemStack stack = tile.getStackInSlot(slot);
					EntityUtils.dropItemInWorld(world, x, y, z, stack);
	            }
	        }
		}
	}
	
	
	/** Called on right click of the block Opens GUI relative to the meta data of the block*/
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par5) {
		player.openGui(AnotherWorldExpansionMechanical.instance, world.getBlockMetadata(x, y, z), world, x, y, z);
		return false;
    	
    }
	
	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister ir) {
		iconBuffer = new IIcon[4][6];
    	 
		//Meta 1: Bottom, Top, North, South, West, East
		iconBuffer[0][0] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableBottom1");
		iconBuffer[0][1] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableTop1");
		iconBuffer[0][2] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide1");
		iconBuffer[0][3] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide1");
		iconBuffer[0][4] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide1");
		iconBuffer[0][5] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide1");
        
		//Meta 2: Bottom, Top, North, South, West, East
		iconBuffer[1][0] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableBottom2");
		iconBuffer[1][1] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableTop2");
		iconBuffer[1][2] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide2");
		iconBuffer[1][3] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide2");
		iconBuffer[1][4] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide1");
		iconBuffer[1][5] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide1");
		
		//Meta 3: Bottom, Top, North, South, East, West
		iconBuffer[2][0] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableBottom3");
		iconBuffer[2][1] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableTop3");
		iconBuffer[2][2] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide1");
		iconBuffer[2][3] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide2");
		iconBuffer[2][4] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide1");
		iconBuffer[2][5] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide1");
		
		//Meta 4: Bottom, Top, North, South, East, West
		iconBuffer[3][0] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableBottom4");
		iconBuffer[3][1] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableTop4");
		iconBuffer[3][2] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide2");
		iconBuffer[3][3] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide2");
		iconBuffer[3][4] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide2");
		iconBuffer[3][5] = ir.registerIcon(GlobalValues.TEXTURE + "blockTableSide1");
	}
    
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		//If the meta is less than 4, stops ArrayIndexOutOfBoundsExceptions
		return (meta < 4)? iconBuffer[meta][side] : iconBuffer[0][0];
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	

	/** Is the meta block allowed to have a tile entity? */
	@Override
	public boolean hasTileEntity(int meta) {
		//Only meta block 0 has a tile entity
		return meta == 0? true : false;
	}
    
	/** Will create a tile entity if hasTileEntity(meta) resolves as true for the metadata passed*/
	@Override
	public TileEntity createTileEntity(World world, int meta){
		return new TileMechanicsTable();
	}
	
	/** How many items are dropped when broken */
	@Override
	public int quantityDropped(Random par1Random) {
		return 0;
	}
	
}