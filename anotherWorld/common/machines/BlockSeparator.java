package anotherWorld.common.machines;

import anotherWorld.common.AnotherWorld;
import anotherWorld.common.basicBlocks.BasicBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSeparator extends BlockContainer {

	protected BlockSeparator(int id, int idInTexture, Material mat) {
		super(id, idInTexture, mat);
		GameRegistry.registerBlock(this, "test");
		LanguageRegistry.addName(this, "test");
		this.setBlockName(Machines.testName);
        this.setCreativeTab(AnotherWorld.TabAW);
        
        this.setHardness(4.0F);
        this.setStepSound(Block.soundGlassFootstep);

	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	public int getRenderType()
	{
		return -1;
	}


	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntitySeparator();
	}
	public TileEntity getBlockEntity()
	{
		try{
			return (TileEntity)TileEntitySeparator.class.newInstance();
		}
		catch(Exception exception){
			throw new RuntimeException(exception);
		}
	}


}
