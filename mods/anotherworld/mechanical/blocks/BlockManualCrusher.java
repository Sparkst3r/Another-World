package mods.anotherworld.mechanical.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.anotherworld.mechanical.tileentity.TileManualGrinder;
import mods.anotherworld.util.basic.BasicBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockManualCrusher extends BasicBlock {

	/**
	 * Icon Buffer
	 */
	@SideOnly(Side.CLIENT)
	public static Icon[] iconBuffer;
	
	public String[] sides = new String[] {"","","","","",""};
	
	/**
	 * Constructor
	 * @param id
	 */
	public BlockManualCrusher(int id) {
		super(id, Material.rock, "Hand Cranked Crusher", "blockHandCrusher");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		
	}
	
	
	/** Is the meta block allowed to have a tile entity? */
	@Override
	public boolean hasTileEntity(int meta) {
		return true;
	}
    
	/** Will create a tile entity if hasTileEntity(meta) resolves as true for the metadata passed*/
	@Override
	public TileEntity createTileEntity(World world, int meta){
		return new TileManualGrinder();
	}
	
	
}
