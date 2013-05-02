package mods.anotherworld.mechanical.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import mods.anotherworld.mechanical.AnotherWorldExpansionMechanical;
import mods.anotherworld.mechanical.tileentity.TileLogicSimple;
import mods.anotherworld.util.basic.BasicBlock;


public class BlockLogicSimple extends BasicBlock {

	public BlockLogicSimple(int id) {
		super(id, Material.iron, "Basic Logic Housing", "logicSimple");
	}
	
	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new TileLogicSimple();
	}
	
	@Override
    public boolean hasTileEntity(int meta) {
		return true;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9) {
		player.openGui(AnotherWorldExpansionMechanical.instance, 4, world, x, y, z);
		return true;
	}
	
	
	
}
