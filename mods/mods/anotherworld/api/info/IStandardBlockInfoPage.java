package mods.anotherworld.api.info;

import net.minecraft.item.ItemStack;

/**
 * IStandardBlockInfoPage
 * 
 * Creates a new info "page" for a standard block. Designed for vanilla blocks and the like. 
 * Excluding custom rendered and "machine like" blocks 
 * 
 * @author Sparkst3r
 *
 */
public abstract interface IStandardBlockInfoPage {
	
	/**
	 * The block, when clicked with the tool, opens this info panel. Meta-data specific
	 * @return
	 */
	public abstract ItemStack block();
	
	/**
	 * The Block to render in the info panel can be different to the block clicked. Meta-data specific
	 * @return
	 */
	public abstract ItemStack displayBlock();
	
	/**
	 * Quick overview of the block. A new array entry for each line. Max 6 lines.
	 * @return
	 */
	public abstract String[] blurbInfo();
	
	/**
	 * Full info of the block. A new array entry per line. Max 30 lines.
	 * @return
	 */
	public abstract String[] fullInfo();
	
	/**
	 * If anything else requires drawing. This is a callback for the rendering stage.
	 * @return
	 */
	public abstract boolean callback();
	
}
