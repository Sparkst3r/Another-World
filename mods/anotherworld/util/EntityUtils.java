package mods.anotherworld.util;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
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
	static int startEntityId = 300;

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
	
	/**
	 * Drops an EntityItem from an item stack with a random velocity
	 * 
	 * @param world The world to drop in
	 * @param x X value to drop at
	 * @param y Y value to drop at
	 * @param z Z value to drop at
	 * @param stack Stack to drop
	 */
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
	
	/**
	 * Returns the ItemStack from an EntityItem
	 * @param item The EntityItem
	 * @return The ItemStack of the EntityItem
	 */
	public static ItemStack getStackFromEntity(EntityItem item) {
		return item.getEntityItem();
	}
	
	/**
	 * Gets all EntityItems in a radius
	 * 
	 * @param world The world
	 * @param x The centre x coordinate
	 * @param y The centre y coordinate
	 * @param z The centre z coordinate
	 * @param xRadius The radius to check in the x axis
	 * @param yRadius The radius to check in the y axis
	 * @param zRadius The radius to check in the z axis
	 * @return An ItemStack array of the items found
	 */
	public static ItemStack[] getItemsInRadius(World world, int x, int y, int z, int xRadius, int yRadius, int zRadius) {
		List<EntityItem> itemList = WorldUtils.getItemsInAABB(world, x - xRadius, y - yRadius, z - zRadius, x + xRadius, y + yRadius, z + zRadius);
		ItemStack[] itemStackArray;
		itemStackArray = new ItemStack[itemList.size()];
		
		for (int item = 0; item <itemList.size(); item++) {
			EntityItem tempItem = itemList.get(item);
			itemStackArray[item] = EntityUtils.getStackFromEntity(tempItem);
		}
		
		return itemStackArray;
	}
	
	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		}
		while (EntityList.getStringFromID(startEntityId) != null);
			return startEntityId;
	}
	
	@SuppressWarnings("unchecked")
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	}
}
