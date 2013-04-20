package mods.anotherworld.mechanical.blocks;

import mods.anotherworld.core.GlobalValues;
import mods.anotherworld.mechanical.tileentity.TileMechanicsTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHandGrinder extends Block {

	public BlockHandGrinder(int id) {
		super(id, Material.rock);
		this.setCreativeTab(GlobalValues.AnotherTab);
		this.setHardness(5F);
		
		
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
	
	
}
