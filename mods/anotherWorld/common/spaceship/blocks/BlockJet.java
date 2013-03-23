package mods.anotherWorld.common.spaceship.blocks;

import java.util.Random;

import cpw.mods.fml.common.FMLLog;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.Base.ContainerBlock;
import mods.anotherWorld.common.Base.GlobalIDs;
import mods.anotherWorld.common.machines.tile.TileEntitySpaceChest;
import mods.anotherWorld.common.renderBase.EntityFXPlasma;
import mods.anotherWorld.common.spaceship.tile.TileEntityJet;

public class BlockJet extends ContainerBlock {
	public static String iconTex;
	public BlockJet(int id, String name, String icon) {
		super(id, name, Material.iron);
		this.iconTex = icon;
	}
    public int getRenderType()
	{
		return GlobalIDs.JetRenderID;
	}
    @Override
    public void registerIcons(IconRegister ir) {
    	this.blockIcon = ir.registerIcon("anotherworld:" + iconTex);
    }
    @Override
    public TileEntity createNewTileEntity(World world) {
            return new TileEntityJet();
    }
	public boolean isOpaqueCube()
	{
		return false;
	}

    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    public void randomDisplayTick(World world, int x, int y, int z, Random par5Random)
    {

    	for (int i = 0; i < 100; i++) {
    		double xStart = 0;
    		double yStart = 0;
    		double zStart = 0;
    		float red = 0F;
    		float green = (float) (0.1 + (Math.random() * 0.5));
    		float blue = (float) (0.1 + (Math.random() * 0.9));
        	float[] colour = {red, green, blue};
        	double xVel = 0.0D;
        	double zVel = 0.0D;
        	
        	if (world.getBlockMetadata(x, y, z) == 1) {
        		xVel = 0.0D;
        		zVel = -0.5D;
        		xStart = (x + 0.1) + (Math.random() * 0.9);
        		yStart = (y + 0.1) + (Math.random() * 0.9);
        		zStart = (z + 0.1) + (Math.random() * -6);
        	}
        	if (world.getBlockMetadata(x, y, z) == 2) {
        		xVel = 0.5D;
        		zVel = 0.0D;
        		xStart = (x + 0.1) + (Math.random() * 6);
        		yStart = (y + 0.1) + (Math.random() * 0.9);
        		zStart = (z + 0.1) + (Math.random() * 0.9);
        	}
        	if (world.getBlockMetadata(x, y, z) == 3) {
        		xVel = 0.0D;
        		zVel = 0.5D;
        		xStart = (x + 0.1) + (Math.random() * 0.9);
        		yStart = (y + 0.1) + (Math.random() * 0.9);
        		zStart = (z + 0.1) + (Math.random() * 6);
        	}
        	if (world.getBlockMetadata(x, y, z) == 4) {
        		xVel = -0.5D;
        		zVel = 0.0D;
        		xStart = (x + 0.1) + (Math.random() * -6);
        		yStart = (y + 0.1) + (Math.random() * 0.9);
        		zStart = (z + 0.1) + (Math.random() * 0.9);
        	}
        	
    		plasma(world, xStart, yStart, zStart, xVel, 0.0D, zVel, colour);
    		
    
    	}
    }
    public static void plasma(World world, double x, double y, double z, double xVel, double yVel, double zVel, float[] colour) {
    	EntityFXPlasma fx = new EntityFXPlasma(world, x, y, z, xVel, yVel, zVel, colour);
    		Minecraft.getMinecraft().effectRenderer.addEffect(fx);

    }
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity, ItemStack itemStack)
    {
        byte b0 = 0;
        
        int direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (direction == 0)
        {
            b0 = 1; //2
        }

        if (direction == 1)
        {
            b0 = 2; //5
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

    
}
