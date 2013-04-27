package mods.anotherworld.world.blocks;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockQuartreSlab extends ItemBlock {
	public static String[] types = {"blockPaverStone", "blockPaverSandStone", "blockPaverCobble", "blockPaverBrick", "blockPaverStoneBrick", "blockPaverNetherBrick", "blockPaverQuartz", "blockPaverWood1","blockPaverWood2", "blockPaverWood3", "blockPaverWood4"};
	public static String[] names = {"Quartz Paving stone", "Quartz Paving stone","Quartz Paving stone","Quartz Paving stone","Quartz Paving stone","Quartz Paving stone","Quartz Paving stone","Quartz Paving stone","Quartz Paving stone","Quartz Paving stone","Quartz Paving stone"};
	public ItemBlockQuartreSlab(int id) {
		super(id);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);

	}
		
	
	public int getMetadata(int meta) {
		return meta;
	}
	
	public String getUnlocalizedName(ItemStack is) {
		
		return types[is.getItemDamage()];
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < types.length; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	} 
}