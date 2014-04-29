/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.tool;

/**
 * IToolModeManager
 * 
 * Provides access to add new modes to a tool.
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 24 Feb 2014
 *
 */
public interface IToolModeManager {
	
	/**
	 * Adds a mode to a tool 
	 * @param mode The mode to add.
	 * @return If it was added
	 */
	public boolean addMode(IToolMode mode);
	
}
