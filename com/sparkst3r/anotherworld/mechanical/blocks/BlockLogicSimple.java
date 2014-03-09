package com.sparkst3r.anotherworld.mechanical.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.sparkst3r.anotherworld.mechanical.AnotherWorldExpansionMechanical;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileLogicSimple;
import com.sparkst3r.anotherworld.util.basic.BasicBlock;


public class BlockLogicSimple extends BasicBlock {

	public BlockLogicSimple() {
		super(Material.iron, "logicSimple");
	}
	
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9) {
		player.openGui(AnotherWorldExpansionMechanical.instance, 4, world, x, y, z);
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new TileLogicSimple();
	}
	
	@Override
    public boolean hasTileEntity(int meta) {
		return true;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
		
	}
	

	
	
	
}
