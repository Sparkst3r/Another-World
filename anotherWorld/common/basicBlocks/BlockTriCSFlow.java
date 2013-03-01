package anotherWorld.common.basicBlocks;

import anotherWorld.common.AnotherWorld;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraftforge.liquids.ILiquid;

public class BlockTriCSFlow extends BlockFluid { //implements ILiquid {

	public static String name = "Trichlorosilane Flowing"; 
	protected BlockTriCSFlow(int ID) {
		super(ID, Material.water);
		this.setCreativeTab(AnotherWorld.TabAW);
		this.blockHardness = 100F;
		this.setLightOpacity(1);
		this.setRequiresSelfNotify();
		this.setTextureFile(AnotherWorld.blockTex);
		this.blockIndexInTexture = 100;
		
		GameRegistry.registerBlock(this, name);
		LanguageRegistry.addName(this, name);

	}
	
	/* @Override
	public int getRenderType() {
		return BasicBlocks.TriCSRenderID;
	}
	@Override
	public String getTextureFile() {
		return AnotherWorld.blockTex;
	}
	
	@Override
	public int stillLiquidId() {
		return BasicBlocks.TriCSStill.blockID;
	}
	@Override
	public boolean isMetaSensitive() {
		return false;
	}
	
	@Override
	public int stillLiquidMeta() {
		return 0;
	}
	*/
}