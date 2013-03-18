package mods.anotherWorld.common.machines;

import static cpw.mods.fml.relauncher.Side.CLIENT;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.basicBlocks.BasicBlocks;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.liquids.ILiquid;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;

public class BlockTriCSStill extends BlockStationary implements ILiquid{
	private Icon[] field_94425_a;

	public BlockTriCSStill(int ID) {
		super(ID, Material.water);
		this.setCreativeTab(AnotherWorld.TabAW);
	    this.setUnlocalizedName(Machines.BlockTriCSStillName);
		this.blockHardness = 100F;
		this.setLightOpacity(1);
		this.setTickRandomly(true);
	
		GameRegistry.registerBlock(this, Machines.BlockTriCSStillName);
		LanguageRegistry.addName(this, Machines.BlockTriCSStillName);
	}
	@Override
    @SideOnly(Side.CLIENT)
	public void func_94332_a(IconRegister iconRegister){
		this.field_94425_a = new Icon[] {iconRegister.func_94245_a("anotherWorld:triCSStill"), iconRegister.func_94245_a("anotherWorld:triCSFlow")};
}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return par1 != 0 && par1 != 1 ? this.field_94425_a[1] : this.field_94425_a[0];
	}
	
	@Override
	public int getRenderType() {
		return 4;
	}

	@Override
	public int stillLiquidId() {
		return Machines.TriCSStill.blockID;
	}

	@Override
	public boolean isMetaSensitive() {
		return false;
	}

	@Override
	public int stillLiquidMeta() {
		return 0;
	}

	@Override
	public boolean isBlockReplaceable(World world, int i, int j, int k) {
		return true;
	}

}
