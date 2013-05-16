package mods.anotherworld.api.tool;

/**
 * IToolModeManager
 * 
 * Provides access to add new modes to a tool.
 * 
 * @author Sparkst3r
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
