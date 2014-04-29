/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.tool;

/**
 * IToolActionManager
 * 
 * Provides access to the tool action manager to add new actions for the tool to execute
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 24 Feb 2014
 *
 */
public interface IToolActionManager {
	
	/**
	 * Registers a tool action
	 * @param action
	 * @return if the action was added successfully.
	 */
	public boolean addAction(IToolAction action);
}
