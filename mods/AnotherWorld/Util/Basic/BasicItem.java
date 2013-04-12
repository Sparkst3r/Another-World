package mods.AnotherWorld.Util.Basic;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.AnotherWorld.Core.AnotherWorld;
import mods.AnotherWorld.Core.GlobalValues;
import net.minecraft.item.Item;

/**
 * Provides basic item functionality and registers the item with the Language 
 * and Game registry
 * Class needs to be extended by the new item
 * 
 * @author Sparkst3r
 *
 */
public class BasicItem extends Item {
	
	/**
	 * Extend this class to create a standard item
	 * @param id ItemID
	 * @param name Human-readable name of the item
	 * @param identifier Non human-readable name of the item. Used for texture file name.
	 */
	public BasicItem(int id, String name, String identifier) {
		super(id);
		this.setUnlocalizedName(name);
		this.setCreativeTab(GlobalValues.AnotherTab);
		GameRegistry.registerItem(this, identifier);
		LanguageRegistry.addName(this, name);
	}
}