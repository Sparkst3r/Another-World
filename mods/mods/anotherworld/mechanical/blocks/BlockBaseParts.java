package mods.anotherworld.mechanical.blocks;

import cofh.api.block.IDismantleable;
import mods.anotherworld.api.tool.IToolDismantleable;
import mods.anotherworld.client.AnotherWorldTab;
import mods.anotherworld.core.GlobalValues;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * Meta-based block for the sides of the Mechanics Table
 * 
 * @author Sparkst3r
 *
 */
public class BlockBaseParts extends Block implements IToolDismantleable, IDismantleable {
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private Icon[] iconBuffer;

	/**
	 * Constructor
	 * @param id
	 */
	public BlockBaseParts(int id) {
		super(id, GlobalValues.IMMOVABLE);
		this.setCreativeTab(AnotherWorldTab.TAB);
		this.setHardness(0.5F);
		MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 1);
		GameRegistry.registerBlock(this, ItemBlockBaseParts.class, "MechanicalBaseBlocks");
	}

	/** Registers the block's textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[3];
		
		iconBuffer[0] = ir.registerIcon(GlobalValues.TEXTURE + ItemBlockBaseParts.types[0]);
		iconBuffer[1] = ir.registerIcon(GlobalValues.TEXTURE + ItemBlockBaseParts.types[1]);
		iconBuffer[2] = ir.registerIcon(GlobalValues.TEXTURE + ItemBlockBaseParts.types[2]);
	}
    
    /** Returns the texture for the meta and side */
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int side, int meta) {
		return (meta < 3)? iconBuffer[meta] : iconBuffer[0];
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
		switch(world.getBlockMetadata(x, y, z)) {
			case 0 :
				return null;
			case 1 : 
				return new ItemStack(Block.blocksList[world.getBlockId(x, y, z)], 1, 1);
			case 2 : 
				return new ItemStack(Block.blocksList[world.getBlockId(x, y, z)], 1, 2);
			default : 
				return null;
		}
	}

	/** On dismantled by a CoFH Crescent Hammer */
	@Override
	public ItemStack dismantleBlock(EntityPlayer thePlayer, World world, int x, int y, int z, boolean returnBlock) {
		return this.dismantle(thePlayer, world, x, y, z);
	}
}