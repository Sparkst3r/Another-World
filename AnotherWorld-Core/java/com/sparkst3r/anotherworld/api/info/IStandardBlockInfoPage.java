/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.info;

import net.minecraft.item.ItemStack;

/**
 * IStandardBlockInfoPage
 * 
 * Creates a new info "page" for a standard block. Designed for vanilla blocks and the like. 
 * Excluding custom rendered and "machine like" blocks 
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 24 Feb 2014
 *
 */
public abstract interface IStandardBlockInfoPage {
	
	/**
	 * The block, when clicked with the tool, opens this info panel. Meta-data specific
	 * @return the block which will trigger this page once clicked
	 */
	public abstract ItemStack block();
	
	/**
	 * The Block to render in the info panel can be different to the block clicked. Meta-data specific
	 * @return the block to render on the page
	 */
	public abstract ItemStack displayBlock();
	
	/**
	 * Quick overview of the block. A new array entry for each line. Max 6 lines.
	 * @return brief overview of the block eg. Short description(One line) Tool Type, Tool Level 
	 */
	public abstract String[] blurbInfo();
	
	/**
	 * Full info of the block. A new array entry per line. Max 30 lines.
	 * @return A full description of the function of the block
	 */
	public abstract String[] fullInfo();
	
	/**
	 * If anything else requires drawing. This is a callback for the rendering stage.
	 * @return null
	 */
	public abstract boolean callback();
	
}
