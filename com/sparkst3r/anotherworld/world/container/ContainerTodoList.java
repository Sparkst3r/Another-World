/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.world.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

/** ContainerTodoList
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 5 Apr 2014
 */
public class ContainerTodoList extends Container {

	/**
	 * @param player
	 * @param stack
	 */
	public ContainerTodoList(EntityPlayer player, ItemStack stack) {
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

}
