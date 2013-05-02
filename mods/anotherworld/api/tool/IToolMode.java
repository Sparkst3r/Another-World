package mods.anotherworld.api.tool;

/**
 * A tool mode
 * @author Sparkst3r
 *
 */
public interface IToolMode {
	
	/**
	 * The identifier of the mode. Provide as: "mode.~ModeIdentifier~"
	 */
	public abstract String identifier();
	
	/**
	 * The texture file for the mode. Provide texture in "mods/anotherworld/textures/items"
	 */
	public abstract String texture();
	
	/**
	 * The mode icon to be displayed on the info panel. Provide texture in "mods/anotherworld/textures/items"
	 * @return
	 */
	public abstract String icon();
	
	/**
	 * Hex colour code of the text to be used for the info panel.
	 */
	public abstract int nameColour();
	
	/**
	 * Human readable name of the mode
	 */
	public abstract String name();
	
	/**
	 * The info lines in the tool tip of the item
	 */
	public abstract String[] infoLine();
	

}
