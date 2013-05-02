package mods.anotherworld.api.tool;

/**
 * Used to add new modes to the tinkering tool
 * @author Sparkst3r
 *
 */
public interface IToolModeManager {
	
	/**
	 * Adds a mode to the tinkering tool 
	 * @param mode The mode to add.
	 * @return If it was added
	 */
	public boolean addMode(IToolMode mode);
	
}
