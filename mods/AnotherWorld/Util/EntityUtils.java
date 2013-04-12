package mods.AnotherWorld.Util;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Some simple entity related methods
 * @author Sparkst3r
 *
 */
public class EntityUtils {


	/**
	 * 
	 * @param entityItem The item to test
	 * @param item The item you wish to check for
	 * @param meta The meta data of the item
	 * @return If the entity is the item specified 
	 */
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
	

	public static void dropItemInWorld(World world, int x, int y, int z, ItemStack stack) {
		if (stack != null) {
			Random random = new Random();
			float xOffset = random.nextFloat() * 0.8F + 0.1F;
			float yOffset = random.nextFloat() * 0.8F + 0.1F;
			float zOffset = random.nextFloat() * 0.8F + 0.1F;
			EntityItem entityitem;
				int itemCount = stack.stackSize;
			
                entityitem = new EntityItem(world, (double)(x + xOffset), (double)(y + yOffset), (double)(z + zOffset), new ItemStack(stack.itemID, itemCount, stack.getItemDamage()));
                float motionOffset = 0.05F;
                
                entityitem.motionX = (double)(random.nextGaussian() * motionOffset);
                entityitem.motionY = (double)(random.nextGaussian() * motionOffset);
                entityitem.motionZ = (double)(random.nextGaussian() * motionOffset);

                if (stack.hasTagCompound()) {
                    entityitem.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
                }
                world.spawnEntityInWorld(entityitem);
        }
	}
}
