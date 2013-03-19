package mods.anotherWorld.common.machines;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import java.util.Random;

import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.machines.tile.TileEntitySpaceChest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import static net.minecraftforge.common.ForgeDirection.*;

public class BlockSpaceChest extends BlockContainer
{
    private final Random random = new Random();
    public final int field_94443_a;

    protected BlockSpaceChest(int par1, int par2)
    {
        super(par1, Material.iron);
        this.field_94443_a = par2;
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        setHardness(2.0F);
        setResistance(5.0F);
        setUnlocalizedName("Test");
        setCreativeTab(AnotherWorld.TabAW);
        GameRegistry.registerBlock(this, "Test");
        LanguageRegistry.addName(this, "Test");
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * RenderType is a chest
     */
    public int getRenderType()
    {
        return 22;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity, ItemStack itemStack)
    {
    	
        int l = world.getBlockId(x, y, z - 1);
        int i1 = world.getBlockId(x, y, z + 1);
        int j1 = world.getBlockId(x - 1, y, z);
        int k1 = world.getBlockId(x + 1, y, z);
        byte b0 = 0;
        
        int direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (direction == 0)
        {
            b0 = 2;
        }

        if (direction == 1)
        {
            b0 = 5;
        }

        if (direction == 2)
        {
            b0 = 3;
        }

        if (direction == 3)
        {
            b0 = 4;
        }

        if (l != this.blockID && i1 != this.blockID && j1 != this.blockID && k1 != this.blockID)
        {
            world.setBlockMetadataWithNotify(x, y, z, b0, 3);
        }
        else
        {
        }

        if (itemStack.hasDisplayName())
        {
            ((TileEntitySpaceChest)world.getBlockTileEntity(x, y, z)).func_94043_a(itemStack.getDisplayName());
        }
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
    	
        int l = 0;

        if (world.getBlockId(x - 1, y, z) == this.blockID)
        {
            ++l;
        }

        if (world.getBlockId(x + 1, y, z) == this.blockID)
        {
            ++l;
        }

        if (world.getBlockId(x, y, z - 1) == this.blockID)
        {
            ++l;
        }

        if (world.getBlockId(x, y, z + 1) == this.blockID)
        {
            ++l;
        }
        

        boolean canPlace = true;
        
        //Is there another Space Box next to it on the x axis
        if (this.isThereANeighborChest(world, x + 1, y, z) ||
        	this.isThereANeighborChest(world, x - 1, y, z)
        		) {
        	canPlace = false;
        }
        //Is there another Space Box next to it on the z axis
        if (this.isThereANeighborChest(world, x, y, z + 1) ||
            this.isThereANeighborChest(world, x, y, z - 1)
            	) {
        	
            canPlace = false;
            }
        
        if (l>0) {
        	canPlace = false;
        }
        
        return canPlace;
    }

    /**
     * Checks the neighbour blocks to see if there is a chest there. Args: world, x, y, z
     */
    private boolean isThereANeighborChest(World world, int x, int y, int z)
    {
        return world.getBlockId(x, y, z) != this.blockID ? false : (world.getBlockId(x - 1, y, z) == this.blockID ? true : (world.getBlockId(x + 1, y, z) == this.blockID ? true : (world.getBlockId(x, y, z - 1) == this.blockID ? true : world.getBlockId(x, y, z + 1) == this.blockID)));
    }

    
    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World par1World, int x, int y, int z, int par5, int par6) {
        super.breakBlock(par1World, x, y, z, par5, par6);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int idk, float what, float these, float are) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if (tileEntity == null || player.isSneaking()) {
                    return false;
            }
            player.openGui(AnotherWorld.instance, 4, world, x, y, z);
            System.out.println("Hi");
    	return true;
    }

    public IInventory func_94442_h_(World par1World, int par2, int par3, int par4)
    {
        Object object = (TileEntitySpaceChest)par1World.getBlockTileEntity(par2, par3, par4);

        if (object == null)
        {
            return null;
        }
        else if (par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN))
        {
            return null;
        }
        else if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID && (par1World.isBlockSolidOnSide(par2 - 1, par3 + 1, par4, DOWN)))
        {
            return null;
        }
        else if (par1World.getBlockId(par2 + 1, par3, par4) == this.blockID && (par1World.isBlockSolidOnSide(par2 + 1, par3 + 1, par4, DOWN)))
        {
            return null;
        }
        else if (par1World.getBlockId(par2, par3, par4 - 1) == this.blockID && (par1World.isBlockSolidOnSide(par2, par3 + 1, par4 - 1, DOWN)))
        {
            return null;
        }
        else if (par1World.getBlockId(par2, par3, par4 + 1) == this.blockID && (par1World.isBlockSolidOnSide(par2, par3 + 1, par4 + 1, DOWN)))
        {
            return null;
        }
        else
        {
            if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID)
            {
                object = new InventoryLargeChest("container.chestDouble", (TileEntitySpaceChest)par1World.getBlockTileEntity(par2 - 1, par3, par4), (IInventory)object);
            }

            if (par1World.getBlockId(par2 + 1, par3, par4) == this.blockID)
            {
                object = new InventoryLargeChest("container.chestDouble", (IInventory)object, (TileEntitySpaceChest)par1World.getBlockTileEntity(par2 + 1, par3, par4));
            }

            if (par1World.getBlockId(par2, par3, par4 - 1) == this.blockID)
            {
                object = new InventoryLargeChest("container.chestDouble", (TileEntitySpaceChest)par1World.getBlockTileEntity(par2, par3, par4 - 1), (IInventory)object);
            }

            if (par1World.getBlockId(par2, par3, par4 + 1) == this.blockID)
            {
                object = new InventoryLargeChest("container.chestDouble", (IInventory)object, (TileEntitySpaceChest)par1World.getBlockTileEntity(par2, par3, par4 + 1));
            }

            return (IInventory)object;
        }
    }

    
    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World par1World)
    {
        TileEntitySpaceChest tileentitychest = new TileEntitySpaceChest();
        return tileentitychest;
    }

    




    public boolean func_96468_q_()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void func_94332_a(IconRegister par1IconRegister)
    {
        this.field_94336_cN = par1IconRegister.func_94245_a("wood");
    }
}
