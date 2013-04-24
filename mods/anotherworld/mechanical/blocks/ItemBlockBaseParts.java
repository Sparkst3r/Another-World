package mods.anotherworld.mechanical.blocks;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBaseParts extends ItemBlock{
	public static String[] types = {"stoneSmooth", "blockMechanic", "blockMechanicAdv"};
	public static String[] names = {"Smooth Stone", "Mechanical Block", "Advanced Mechanics Block"};
	
	public ItemBlockBaseParts(int id) {
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}
		
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack is) {
		
		return types[is.getItemDamage()];
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < 3; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	}
}