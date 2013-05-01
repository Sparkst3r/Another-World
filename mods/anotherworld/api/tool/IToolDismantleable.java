package mods.anotherworld.api.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Blocks that implement this can be instantly broken with a Tinkering Tool
 * @author Sparkst3r
 *
 */
public abstract interface IToolDismantleable {
	
	/**
	 * 
	 * @param player The player that used the item
	 * @param world The current world
	 * @param x The X location of the player(Location of activation)
	 * @param y The Y location of the player(Location of activation)
	 * @param z The Z location of the player(Location of activation)
	 * @return
	 */
	public abstract boolean canDismantle(EntityPlayer player, World world, int x, int y, int z);

	/**
	 * 
	 * @param player
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return The ItemStack of the block dismantled
	 */
	public abstract ItemStack dismantle(EntityPlayer player, World world, int x, int y, int z);

}
