package anotherWorld.common.basicBlocks;

import thermalexpansion.api.crafting.ISmelterManager;
import thermalexpansion.api.crafting.IFurnaceManager;
import thermalexpansion.api.crafting.ISmelterRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import anotherWorld.common.AnotherWorld;
import anotherWorld.common.basicItems.BasicItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockEngineeringGlass extends Block{

	public static String name = "Engineering Glass";
    public BlockEngineeringGlass(int id, int texture, Material material) {
        super(id, texture, material);
       
        setHardness(4.0F);
        setStepSound(Block.soundGlassFootstep);
        setBlockName(name);
        setCreativeTab(AnotherWorld.TabAW);
        LanguageRegistry.addName(this, name);
        GameRegistry.registerBlock(this, name);
}
    
    
	public String getTextureFile() {
		return AnotherWorld.blockTex;
	}
	public boolean renderAsNormalBlock() {
		return false;
	}
	public boolean isOpaqueCube() {
		return false;
	}	
}
