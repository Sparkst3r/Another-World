package mods.AnotherWorld.Util;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EntityUtils {
	
	public static boolean isEntityItem(EntityItem entityItem, Item item, int meta) {
		int entityID = entityItem.getEntityItem().itemID;
		int entityMeta = entityItem.getEntityItem().getItemDamage();
		int itemID = item.itemID;
		int itemMeta = new ItemStack(item, 1, meta).getItemDamage();
		
		if (entityID == itemID && entityMeta == itemMeta) {
			return true;
		}
		
		return false;
	}
}
