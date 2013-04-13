package mods.AnotherWorld.Mechanical.Blocks;

import java.util.Random;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.AnotherWorld.Core.AnotherWorld;
import mods.AnotherWorld.Core.GlobalValues;
import mods.AnotherWorld.Mechanical.AnotherWorldExpansionMechanical;
import mods.AnotherWorld.Mechanical.TileEntity.TileMechanicsTable;
import mods.AnotherWorld.Mechanical.Util.MechanicsTableValidation;
import mods.AnotherWorld.Util.BlockCoord;
import mods.AnotherWorld.Util.EntityUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;


/**
 * Meta-based block for the sides of the Mechanics Table
 * 
 * @author Sparkst3r
 *
 */
public class BlockMechanicsTableParts extends Block{
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private Icon[][] iconBuffer;
    
	/** Provides random values */ 
	private final Random random = new Random();
	
    
    /**
	 * Constructor
	 * @param id
	 */
	public BlockMechanicsTableParts(int id) {
		super(id, GlobalValues.immovable);
		this.setHardness(0.5F);
		GameRegistry.registerBlock(this, ItemBlockMechanicsTableParts.class, "MechanicsTable");
	}
	
	/** Called when the block is broken. Drops the contents of the TileEntity when a block is broken */
	public void breakBlock(World world, int x, int y, int z, int block, int meta) {
		if(meta == 0) {
			TileMechanicsTable tile = (TileMechanicsTable) world.getBlockTileEntity(x, y, z);
			if (tile != null) {
				for (int slot = 0; slot < tile.getSizeInventory(); slot++) {
					ItemStack stack = tile.getStackInSlot(slot);
					EntityUtils.dropItemInWorld(world, x, y, z, stack);
	            }
	        }
			
			try {
				tile.invalidate();
			}
			catch (NullPointerException e) {
				FMLLog.warning("A block is unable to invalidate a TileEntity");
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
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[4][6];
    	
		String id = GlobalValues.ModIDCore + ":"; 
		//Meta 1: Bottom, Top, North, South, East, West
		iconBuffer[0][0] = ir.registerIcon(id + "blockTableBottom1");
		iconBuffer[0][1] = ir.registerIcon(id + "blockTableTop1");
		iconBuffer[0][2] = ir.registerIcon(id + "blockTableSide2");
		iconBuffer[0][3] = ir.registerIcon(id + "blockTableSide2");
		iconBuffer[0][4] = ir.registerIcon(id + "blockTableSide1");
		iconBuffer[0][5] = ir.registerIcon(id + "blockTableSide1");
        
		//Meta 2: Bottom, Top, North, South, East, West
		iconBuffer[1][0] = ir.registerIcon(id + "blockTableBottom2");
		iconBuffer[1][1] = ir.registerIcon(id + "blockTableTop2");
		iconBuffer[1][2] = ir.registerIcon(id + "blockTableSide1");
		iconBuffer[1][3] = ir.registerIcon(id + "blockTableSide1");
		iconBuffer[1][4] = ir.registerIcon(id + "blockTableSide2");
		iconBuffer[1][5] = ir.registerIcon(id + "blockTableSide2");
		
		//Meta 2: Bottom, Top, North, South, East, West
		iconBuffer[2][0] = ir.registerIcon(id + "blockTableBottom3");
		iconBuffer[2][1] = ir.registerIcon(id + "blockTableTop3");
		iconBuffer[2][2] = ir.registerIcon(id + "blockTableSide1");
		iconBuffer[2][3] = ir.registerIcon(id + "blockTableSide1");
		iconBuffer[2][4] = ir.registerIcon(id + "blockTableSide2");
		iconBuffer[2][5] = ir.registerIcon(id + "blockTableSide2");
		
		//Meta 2: Bottom, Top, North, South, East, West
		iconBuffer[3][0] = ir.registerIcon(id + "blockTableBottom4");
		iconBuffer[3][1] = ir.registerIcon(id + "blockTableTop4");
		iconBuffer[3][2] = ir.registerIcon(id + "blockTableSide2");
		iconBuffer[3][3] = ir.registerIcon(id + "blockTableSide2");
		iconBuffer[3][4] = ir.registerIcon(id + "blockTableSide1");
		iconBuffer[3][5] = ir.registerIcon(id + "blockTableSide1");
	}
    
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int side, int meta) {
		//If the meta is less than 4, stops ArrayIndexOutOfBoundsExceptions
		return (meta < 4)? iconBuffer[meta][side] : iconBuffer[0][0];
	}

	/** Called when a neighbouring block is changed */
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		if(!MechanicsTableValidation.validateBlocksForCompleted(world, x, y, z, world.getBlockMetadata(x, y, z))) {
			MechanicsTableValidation.breakTable(world, x, y, z, world.getBlockMetadata(x, y, z));
		}		
	}

	/** Is the meta block allowed to have a tile entity? */
	public boolean hasTileEntity(int meta) {
		//Only meta block 0 has a tile entity
		return meta == 0? true : false;
	}
    
	/** Will create a tile entity if hasTileEntity(meta) resolves as true for the metadata passed*/
	public TileEntity createTileEntity(World world, int meta){
		return new TileMechanicsTable();
	}
	
	/** How many items are dropped when broken */
	public int quantityDropped(Random par1Random) {
		return 0;
	}
}