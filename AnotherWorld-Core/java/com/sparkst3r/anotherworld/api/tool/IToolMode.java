/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api.tool;

/**
 * IToolMode
 *
 *	Defines a tool mode
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 24 Feb 2014
 */
public interface IToolMode {
	
	/**
	 * The identifier of the mode. Provide as: "tool.~unlocalisedToolIdentifier~.mode.~ModeIdentifier~"
	 * <p>To localise the item name please append "item." to the identifier in your locale .lang file</p>
	 * @return the identifier of the mode
	 */
	public abstract String identifier();
	
	/**
	 * The texture file for the mode. Place in your mod's items texture folder Provide as "~modName~:textureName~"
	 * @return Texture location
	 */
	public abstract String texture();
	
	/**
	 * The mode icon to be displayed on the info panel. Place in your mod's items texture folder Provide as "~modName~:textureName~"
	 * @return Texture location
	 */
	public abstract String icon();
	
	/**
	 * Hex colour code of the mode name displayed on the model
	 * @return The hex code eg. "0xFF7733"
	 */
	public abstract int nameColour();
	
	/**
	 * The info lines in the tool tip of the item
	 * @return the info lines
	 */
	public abstract String[] infoLine();
	

}
