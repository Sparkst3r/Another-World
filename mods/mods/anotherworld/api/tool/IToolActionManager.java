package mods.anotherworld.api.tool;

/**
 * IToolActionManager
 * 
 * Provides access to the tool action manager to add new actions for the tool to execute
 * 
 * @author Sparkst3r
 *
 */
public interface IToolActionManager {
	
	/**
	 * Registers a tool action
	 * @param action
	 */
	public boolean addAction(IToolAction action);
}
