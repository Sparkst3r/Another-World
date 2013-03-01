package anotherWorld.common.basicBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import anotherWorld.common.AnotherWorld;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraftforge.liquids.ILiquid;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;

public class BlockTriCSStill extends BlockStationary { //implements ILiquid{
	public static String name = "Trichlorosilane Still"; 
	protected BlockTriCSStill(int ID) {
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
	/*@Override
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
