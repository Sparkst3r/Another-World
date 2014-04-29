/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * IToolDismantleable
 *
 * Blocks that implement this can be instantly broken with a Tinkering Tool
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 24 Feb 2014
 */
public abstract interface IToolDismantleable {
	
	/**
	 * Can the block at this location be dismantled
	 * 
	 * @param player The player that used the item
	 * @param world The current world
	 * @param x The X location of the player(Location of activation)
	 * @param y The Y location of the player(Location of activation)
	 * @param z The Z location of the player(Location of activation)
	 * @return If the block can be dismantled
	 */
	public abstract boolean canDismantle(EntityPlayer player, World world, int x, int y, int z);

	/**
	 * 
	 * @param player The player that used the item
	 * @param world The current world
	 * @param x The X location of the player(Location of activation)
	 * @param y The Y location of the player(Location of activation)
	 * @param z The Z location of the player(Location of activation)
	 * @return The ItemStack of the block dismantled
	 */
	public abstract ItemStack dismantle(EntityPlayer player, World world, int x, int y, int z);

}
