/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */

package com.sparkst3r.anotherworld.api;

import com.sparkst3r.anotherworld.api.crafting.IManualCrusherManager;
import com.sparkst3r.anotherworld.api.crafting.IMechanicsTableManager;
import com.sparkst3r.anotherworld.api.crafting.IWorldCraftingManager;
import com.sparkst3r.anotherworld.api.info.IBlockInfoManager;
import com.sparkst3r.anotherworld.api.tool.IToolActionManager;
import com.sparkst3r.anotherworld.api.tool.IToolModeManager;


/**
 * Managers
 * 
 * Access to various managers to add custom functionality to existing handlers.
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 16 Feb 2014
 */
public class Managers {
	
	/**
	 * Mechanics Table Crafting manager
	 */
	public static IMechanicsTableManager mechanicsTableCrafting;
	
	/**
	 * In-World Crafting manager
	 */
	public static IWorldCraftingManager worldCrafting;
	
	/**
	 * Manual Crusher manager
	 */
	public static IManualCrusherManager manualCrusher;
	
	/**
	 * Tinkering tool action manager
	 */
	public static IToolActionManager toolActionManager;
	
	/**
	 * Tinkering tool mode manager
	 */
	public static IToolModeManager toolModeManager;
	
	/**
	 * Info page manager
	 */
	public static IBlockInfoManager pageManager;
	
}
