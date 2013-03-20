package mods.anotherWorld.common.machines;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.GlobalIDs;
import mods.anotherWorld.common.machines.tile.TileEntitySeparator;
import mods.anotherWorld.common.machines.tile.TileEntitySpaceChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockSeparator extends BlockContainer {

        protected BlockSeparator (int id) {
                super(id, Material.wood);
                setHardness(2.0F);
                setResistance(5.0F);
                setUnlocalizedName("Separator");
                setCreativeTab(AnotherWorld.TabAW);
                GameRegistry.registerBlock(this, "Separator");
                LanguageRegistry.addName(this, "Separator");
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
                world.setBlockMetadataWithNotify(x, y, z, b0, 3);
        }

        
        public int getRenderType()
    	{
    		return GlobalIDs.SeparatorRenderID;
    	}
    	
    	public int idDropped(int i, Random random, int j)
    	{
    		return 0;
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
        public boolean onBlockActivated(World world, int x, int y, int z,
                        EntityPlayer player, int idk, float what, float these, float are) {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if (tileEntity == null || player.isSneaking()) {
                        return false;
                }
                
                if (TileEntitySeparator.liquid == false) {
                	TileEntitySeparator.liquid = true;
                }
                else {
                	TileEntitySeparator.liquid = false;
                }
                
                
                System.out.println(TileEntitySeparator.liquid);
                
        //code to open gui explained later
        player.openGui(AnotherWorld.instance, 0, world, x, y, z);
                return true;
        }

        @Override
        public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
                dropItems(world, x, y, z);
                super.breakBlock(world, x, y, z, par5, par6);
        }

        private void dropItems(World world, int x, int y, int z){
                Random rand = new Random();

                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if (!(tileEntity instanceof IInventory)) {
                        return;
                }
                
                IInventory inventory = (IInventory) tileEntity;

                for (int i = 0; i < inventory.getSizeInventory(); i++) {
                        ItemStack item = inventory.getStackInSlot(i);

                        if (item != null && item.stackSize > 0) {
                                float rx = rand.nextFloat() * 0.8F + 0.1F;
                                float ry = rand.nextFloat() * 0.8F + 0.1F;
                                float rz = rand.nextFloat() * 0.8F + 0.1F;

                                EntityItem entityItem = new EntityItem(world,
                                                x + rx, y + ry, z + rz,
                                                new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

                                float factor = 0.05F;
                                entityItem.motionX = rand.nextGaussian() * factor;
                                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                                entityItem.motionZ = rand.nextGaussian() * factor;
                                world.spawnEntityInWorld(entityItem);
                                item.stackSize = 0;
                        }
                }
        }

        @Override
        public TileEntity createNewTileEntity(World world) {
                return new TileEntitySeparator();
        }

}