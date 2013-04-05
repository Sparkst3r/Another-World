package mods.AnotherWorld.Mechanical.Blocks;

import java.util.Random;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import mods.AnotherWorld.Core.AnotherWorld;
import mods.AnotherWorld.Core.GlobalValues;
import mods.AnotherWorld.Mechanical.AnotherWorldExpansionMechanical;
import mods.AnotherWorld.Mechanical.TileEntity.TileMechanicsTable;
import mods.AnotherWorld.Mechanical.Util.MechanicsTableValidation;
import mods.AnotherWorld.Util.BasicBlock;
import mods.AnotherWorld.Util.ContainerBlock;

/**
 * Block Class for the Mechanics Table. Single craftable block
 * 
 * @author Sparkst3r
 *
 */
public class BlockMechanicBlock extends BasicBlock{
	private String iconTex;
	
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param identifier
	 */
	public BlockMechanicBlock(int id, String name, String identifier) {
		super(id, Material.iron, name, identifier);
		this.iconTex = identifier;
		this.setHardness(4F);
	}
	
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par1, float par2, float par3, float par5) {
		//TODO Add Tinkering tool activation
		//	player.openGui(AnotherWorld.instance, 0, world, x, y, z);
		
		int block = MechanicsTableValidation.validateTable(world, x, y, z);
		MechanicsTableValidation.changeBlocks(world, x, y, z, block);
		
		return true;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister ir) {
    	this.blockIcon = ir.registerIcon(GlobalValues.ModIDCore + ":" + iconTex);
    }
    
    public int idDropped(int par1, Random par2Random, int par3){
    	return this.blockID;
    }
	
	
}
