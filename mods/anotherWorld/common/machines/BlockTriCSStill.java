package mods.anotherWorld.common.machines;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.anotherWorld.AnotherWorld;
import mods.anotherWorld.common.basicBlocks.BasicBlocks;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.liquids.ILiquid;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;

public class BlockTriCSStill extends BlockStationary implements ILiquid{
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
