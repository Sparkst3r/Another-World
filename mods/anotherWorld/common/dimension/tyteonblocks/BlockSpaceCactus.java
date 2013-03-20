package mods.anotherWorld.common.dimension.tyteonblocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import mods.anotherWorld.common.GlobalIDs;
import mods.anotherWorld.common.basicBlocks.BasicBlock;
import mods.anotherWorld.common.basicBlocks.BasicBlocks;
import mods.anotherWorld.common.dimension.tyteonblocks.render.TileSpaceCactus;
import mods.anotherWorld.common.machines.tile.TileEntitySeparator;

public class BlockSpaceCactus extends ContainerBlock{

	public BlockSpaceCactus(int id, String name) {
		super(id, name, Material.cactus);
		this.blockHardness = 0.5F;
        this.setStepSound(Block.soundSnowFootstep);
        this.setTickRandomly(true);
	
		this.setBlockBounds(0.025F, 0.025F, 0.0F, 0.975F, 1.5F, 0.975F);
		
	}
	//Called when the block has been successfully placed
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity, ItemStack itemStack) {
    	//Create a new placeholder block above the cactus
    	world.setBlockAndMetadataWithNotify(x, y + 1, z, BasicBlocks.plhoID, 0, 0);
    }
    
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        boolean canPlace = true;

        //Is the block above anything other than air? If it isn't, stop the block from being placed.
        if (!(world.getBlockId(x, y + 1, z) == 0))
        {
            canPlace = false;
        }
        return canPlace;
    }
    
    //Called when the block is broken.
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int par5) {
    	//Delete the placeholder block
    	world.setBlockAndMetadataWithNotify(x, y + 1, z, 0, 0, 0);
    }
    

    public int getRenderType()
	{
		return GlobalIDs.SpaceCactusRenderID;
	}
	
	public int idDropped(int i, Random random, int j)
	{
		return this.blockID;
	}
	
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
	
	public boolean isOpaqueCube()
	{
		return false;
	}

    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
            return new TileSpaceCactus();
    }

}
