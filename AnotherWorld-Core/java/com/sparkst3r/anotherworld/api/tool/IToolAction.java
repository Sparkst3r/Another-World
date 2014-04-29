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
 * IToolAction
 * 
 * Basic action for a tool to execute
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 24 Feb 2014
 *
 */
public abstract interface IToolAction {
	
	/**
	 * The identifier of the action. Provide as: "action.tinker.~ModeIdentifier~.~ActionIdentifier~"
	 * @return the identifier of the action
	 */
	public abstract String identifier();
	
	/**
	 * If the action triggers any client only rendering.
	 * @return unused
	 */
	public abstract boolean requiresClientRender();
	
	/**
	 * What happens when the action is triggered.
	 * 
	 * @param stack the itemstack of the tool
	 * @param player The player who triggered the action
	 * @param world The world
	 * @param x X coord of block clicked
	 * @param y Y coord of block clicked
	 * @param z Z coord of block clicked
	 * @param side The side of the block clicked
	 * @param locX The local X coord of block clicked
	 * @param locY The local Y coord of block clicked
	 * @param locZ The local Z coord of block clicked
	 */
	public abstract void triggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ);
	
	/**
	 * Can this action be triggered.
	 * 
	 * @param stack the itemstack of the tool
	 * @param player The player who triggered the action
	 * @param world The world
	 * @param x X coord of block clicked
	 * @param y Y coord of block clicked
	 * @param z Z coord of block clicked
	 * @param side The side of the block clicked
	 * @param locX The local X coord of block clicked
	 * @param locY The local Y coord of block clicked
	 * @param locZ The local Z coord of block clicked
	 * @return if the action can be triggered
	 */
	public abstract boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ);
	
}
