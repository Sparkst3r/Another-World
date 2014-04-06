/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.mechanical.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.sparkst3r.anotherworld.core.AnotherWorldTab;
import com.sparkst3r.anotherworld.mechanical.MechanicalValues;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileDisappearDoor;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileManualCrusher;
import com.sparkst3r.anotherworld.util.WorldUtils;

import cpw.mods.fml.common.registry.GameRegistry;

/** 
 * BlockDisappearDoor
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 27 Mar 2014
 */
public class BlockDisappearDoor extends Block {
	
	/** Constructor */
	public BlockDisappearDoor() {
		super(Material.cloth);
        this.setCreativeTab(AnotherWorldTab.TAB);
		GameRegistry.registerBlock(this, "blockDisappearDoor");
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float xLoc, float yLoc, float zLoc) {
		world.setBlock(x, y, z, MechanicalValues.blockDisappearDoor, 1, 2);
		if(WorldUtils.isBlockAt(world, x + 1, y, z, MechanicalValues.blockDisappearDoor, 0)) {
			world.getBlock(x, y, z).onBlockActivated(world, x + 1, y, z, player, side, xLoc, yLoc, zLoc);
		}
		if(WorldUtils.isBlockAt(world, x - 1, y, z, MechanicalValues.blockDisappearDoor, 0)) {
			world.getBlock(x, y, z).onBlockActivated(world, x - 1, y, z, player, side, xLoc, yLoc, zLoc);
		}
		if(WorldUtils.isBlockAt(world, x, y + 1, z, MechanicalValues.blockDisappearDoor, 0)) {
			world.getBlock(x, y, z).onBlockActivated(world, x, y + 1, z, player, side, xLoc, yLoc, zLoc);
		}
		if(WorldUtils.isBlockAt(world, x, y - 1, z, MechanicalValues.blockDisappearDoor, 0)) {
			world.getBlock(x, y, z).onBlockActivated(world, x, y - 1, z, player, side, xLoc, yLoc, zLoc);
		}
		if(WorldUtils.isBlockAt(world, x, y, z + 1, MechanicalValues.blockDisappearDoor, 0)) {
			world.getBlock(x, y, z).onBlockActivated(world, x, y, z + 1, player, side, xLoc, yLoc, zLoc);
		}
		if(WorldUtils.isBlockAt(world, x, y, z - 1, MechanicalValues.blockDisappearDoor, 0)) {
			world.getBlock(x, y, z).onBlockActivated(world, x, y, z - 1, player, side, xLoc, yLoc, zLoc);
		}
		
		
		world.markBlockForUpdate(x, y, z);
		return true;
	}
	
	
	
	
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    /*public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
        int type = 3; /* world.getBlockMetadata(x, y, z); 
    	
        AxisAlignedBB box = null;
        
        if (type == 0) {
        	box = AxisAlignedBB.getAABBPool().getAABB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        }
        else if (type == 1) {
        	box = AxisAlignedBB.getAABBPool().getAABB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
        }
        else {
        	box = AxisAlignedBB.getAABBPool().getAABB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
        }
        
        return box;
    }
    */
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
    int type = 3;
	
    AxisAlignedBB box = AxisAlignedBB.getAABBPool().getAABB(0, 0, 0, 16, 16, 1);
    
    return box;
}
	
    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        this.setBounds(world.getBlockMetadata(x, y, z));
    }

    protected void setBounds(int type) {
        if (type == 0) {
        	this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        else if (type == 1) {
        	float offset = 0.4F;
        	this.setBlockBounds(0.0F + offset, 0.0F + offset, 0.0F + offset, 1.0F - offset, 1.0F - offset, 1.0F  - offset);
        }
    }
    
    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender() {
        this.setBounds(0);
    }
    
	
	/**
	 * Is this block a full cube or transparent?
	 */
    public boolean isOpaqueCube() {
        return false;
    }
	
    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock() {
        return false;
    }
    
	/** Is the meta block allowed to have a tile entity? */
	@Override
	public boolean hasTileEntity(int meta) {
		if(meta == 1) {
			return true;
		}
		return false;
	}
    
	/** Will create a tile entity if hasTileEntity(meta) resolves as true for the metadata passed*/
	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new TileDisappearDoor();
	}
	
	
}
