package mods.anotherworld.machines.items;


import java.util.List;

import mods.anotherworld.core.GlobalValues;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * Meta-data item for the base parts.
 * 
 * @author Sparkst3r
 *
 */
public class ItemBaseParts extends Item {
	/** Texture file names + code name */
    public static String[] types = new String[] {"dustQuartz"};
    
    /** Human-Readable names */
    public static String[] names = new String[] {"Crushed Quartz"};
    
    /** Icon Array */
    @SideOnly(Side.CLIENT)
    private Icon[] iconBuffer;

    /**
     * Constructor
     * @param id Item ID
     */
	public ItemBaseParts(int id) {
		super(id);
        this.setCreativeTab(GlobalValues.AnotherTab);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		GameRegistry.registerItem(this, "ingots");
	}
	
	/** Returns the texture based on the damage value */
	@SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int damage){
    	return iconBuffer[damage];
    }
    
	/** Register the textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[types.length];
		String id = GlobalValues.ModIDCore + ":";
		for (int icon = 0; icon < types.length; icon++) {
			iconBuffer[icon] = ir.registerIcon(id + types[icon]);
		}
	}
    
	/** Adds the meta items to the tab */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < types.length; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	} 
	
	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return types[is.getItemDamage()];
	}

}