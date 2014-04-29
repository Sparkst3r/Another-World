/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.dummy;

import com.sparkst3r.anotherworld.api.tool.IToolAction;
import com.sparkst3r.anotherworld.api.tool.IToolActionManager;
import com.sparkst3r.anotherworld.api.tool.IToolMode;
import com.sparkst3r.anotherworld.api.tool.IToolModeManager;

/**
 * ToolManagerDummy
 * 
 * Useless dummy class to prevent null pointers if the mod isn't installed or incorrectly mapped.
 * 
 * @author Sparkst3r(Josh Lockheed)
 * @since 23 Feb 2014
 *
 */
public class ToolManagerDummy implements IToolModeManager, IToolActionManager {


	/**
	 * @see com.sparkst3r.anotherworld.api.tool.IToolModeManager#addMode(com.sparkst3r.anotherworld.api.tool.IToolMode)
	 */
	@Override
	public boolean addMode(IToolMode mode) {
		return false;
	}


	/**
	 * @see com.sparkst3r.anotherworld.api.tool.IToolActionManager#addAction(com.sparkst3r.anotherworld.api.tool.IToolAction)
	 */
	@Override
	public boolean addAction(IToolAction action) {
		return false;
	}
	
}
