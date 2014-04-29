/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.info;

/**
 * IBlockInfoManager
 * 
 * Provides access to the list of pages for the help function of the tinkering tool
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 23 Feb 2014
 *
 */
public interface IBlockInfoManager {
	
	/**
	 * Adds an info page for a standard block eg. Vanilla, non-machine/automating block, non-custom rendered.
	 * @param infoPage The page implementing IStandardBlockInfoPage to be added.
	 * @return if the page was added to the page registry
	 */
	public abstract boolean addStandardBlockInfo(IStandardBlockInfoPage infoPage);
}
