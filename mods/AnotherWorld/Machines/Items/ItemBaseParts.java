package mods.AnotherWorld.Machines.Items;


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
 * Meta-data item for the basic machine parts
 * 
 * @author Sparkst3r
 *
 */
public class ItemBaseParts extends Item {
	//Texture file names
    public static String[] texturenames = new String[] {"partWire", "partTinGear", "partCopperGear"};     
    
    //Icon Array for the textures
    @SideOnly(Side.CLIENT)
    private Icon[] texture;

    /**
     * Constructor
     * @param id Item ID
     */
	public ItemBaseParts(int id) {
		super(id);
        this.setCreativeTab(GlobalValues.AnotherTab);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		GameRegistry.registerItem(this, "parts");
	}
	
	//Returns the texture based on the damage value
	@SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int damage){
    	return texture[damage];
    }
    
	//Update the textures
	@SideOnly(Side.CLIENT)
	@Override
	public void updateIcons(IconRegister iconReg) {
		this.texture = new Icon[texturenames.length];
		for (int damage = 0; damage < texturenames.length; damage++) {
			this.texture[damage] = iconReg.registerIcon(GlobalValues.ModIDCore + ":" + texturenames[damage]);
		}
	}
    
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < 4; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	}
}