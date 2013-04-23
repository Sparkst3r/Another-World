package mods.anotherworld.api.tool;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Create new actions for the Tinkering Tool or other tools
 * @author Sparkst3r
 *
 */
public abstract interface IToolAction {
	
	/**
	 * The identifier of the action. Provide as: "action.tinker.~ModeIdentifier~.~ActionIdentifier~"
	 * TODO Requires merge toolClass() into this
	 */
	public abstract String identifier();
	
	/**
	 * The identifier of the tool the action will be triggered by. Provide as: "tool.~ToolIdentifier~"
	 */
	public abstract String toolClass();
	
	/**
	 * If the action triggers any client only rendering.
	 */
	public abstract boolean requiresClientRender();
	
	/**
	 * What happens when the action is triggered.
	 * 
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
	public abstract void triggerAction(EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ);
	
	/**
	 * Can this action be triggered.
	 * 
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
	public abstract boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ);
	
}
