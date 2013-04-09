package mods.AnotherWorld.Mechanical.Items;


import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import mods.AnotherWorld.Core.GlobalValues;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;


/**
 * Meta-data item for the base items
 * 
 * @author Sparkst3r
 *
 */
public class ItemBaseParts extends Item {
	/** Texture file names + code name */
    public static String[] types = new String[] {"gearTin"};     
    
    /** Human-Readable names */
    public static String[] names = new String[] {"Tin Gear"};
    
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
	public void updateIcons(IconRegister ir) {
		iconBuffer = new Icon[types.length];
		
		String id = GlobalValues.ModIDCore + ":";
		iconBuffer[0] = ir.registerIcon(id + types[0]);
		//iconBuffer[1] = ir.registerIcon(id + types[1]);
		//iconBuffer[2] = ir.registerIcon(id + types[2]);	
		//iconBuffer[3] = ir.registerIcon(id + types[3]);
	}
    
	/** Adds the meta items to the tab */
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < 1; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	} 
	
	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return types[is.getItemDamage()];
	}

}