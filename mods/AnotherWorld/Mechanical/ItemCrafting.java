package mods.AnotherWorld.Mechanical;

import mods.AnotherWorld.World.WorldValues;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemCrafting {
	
	public static void initialise() {
		ItemStack temp = new ItemStack(WorldValues.BlockOreField, 1, 0);
		//ItemStack temp = new ItemStack(WorldValues.BlockOreField, 1, 0);
		//ItemStack temp = new ItemStack(WorldValues.BlockOreField, 1, 0);
		//ItemStack temp = new ItemStack(WorldValues.BlockOreField, 1, 0);
		//ItemStack temp = new ItemStack(WorldValues.BlockOreField, 1, 0);
		
		
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemToolField, 1 , 0), "x",
		        'x', temp);
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemToolField, 1 , 1), "xx",
		        'x', temp);
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemToolField, 1 , 2), "xxx",
		        'x', temp);
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemToolField, 1 , 3), "xxx", "x  ",
		        'x', temp);
		GameRegistry.addRecipe(new ItemStack(MechanicalValues.ItemToolField, 1 , 4), "xxx", "xx ",
		        'x', temp);
	}
}
