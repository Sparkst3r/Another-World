package mods.anotherworld.api.dummy;

import mods.anotherworld.api.tool.IToolAction;
import mods.anotherworld.api.tool.IToolActionManager;
import mods.anotherworld.api.tool.IToolMode;
import mods.anotherworld.api.tool.IToolModeManager;

/**
 * ToolManagerDummy
 * 
 * Useless dummy class to prevent null pointers if the mod isn't installed or incorrectly mapped.
 * 
 * @author Sparkst3r
 *
 */
public class ToolManagerDummy implements IToolModeManager, IToolActionManager {

	/**
	 * (non-Javadoc)
	 * @see mods.anotherworld.api.tool.IToolModeManager#addMode(mods.anotherworld.api.tool.IToolMode)
	 */
	@Override
	public boolean addMode(IToolMode mode) {
		return false;
	}

	/**
	 * (non-Javadoc)
	 * @see mods.anotherworld.api.tool.IToolActionManager#addAction(mods.anotherworld.api.tool.IToolAction)
	 */
	@Override
	public boolean addAction(IToolAction action) {
		return false;
	}
	
}
