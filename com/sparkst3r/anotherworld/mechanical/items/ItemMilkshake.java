/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.mechanical.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import com.sparkst3r.anotherworld.core.AnotherWorldTab;
import com.sparkst3r.anotherworld.core.GlobalValues;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/** ItemMilkshake
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 15 Mar 2014
 */
public class ItemMilkshake extends Item {
	/** Universal identifier */
	public static final String identifier = "milkshake";
	
	/** Copper meta value */
	public static final int WEAK = 0;
	/** Tin meta value */
	public static final int MEDIUM = 1;
	/** Silver meta value */
	public static final int STRONG = 2;
	
	/** Unlocalised names */
	public static final String[] types = new String[] {"weak"/*, "medium", "strong"*/};     
	
	/** Icon Array */
	@SideOnly(Side.CLIENT)
	private IIcon[] iconBuffer = new IIcon[types.length];

	/** Constructor */
	public ItemMilkshake() {
		super();
        this.setCreativeTab(AnotherWorldTab.TAB);
		//this.setHasSubtypes(true);
		//this.setMaxDamage(0);
		GameRegistry.registerItem(this, identifier);
	}


	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		
		if (!par3EntityPlayer.capabilities.isCreativeMode) {
			--par1ItemStack.stackSize;
		}

		if (!par2World.isRemote) {
			par3EntityPlayer.curePotionEffects(new ItemStack(Items.milk_bucket));
		}

        return par1ItemStack.stackSize <= 0 ? new ItemStack(Items.bucket) : par1ItemStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 42; //Meaning of.... milkshake?
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }

	/** Returns the texture based on the damage value */
	@SideOnly(Side.CLIENT)
	@Override
    public IIcon getIconFromDamage(int damage){
		return iconBuffer[damage];
	}
	
	/** Register the textures with the IconRegister */
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister ir) {
		for (int icon = 0; icon < types.length; icon++) {
			iconBuffer[icon] = ir.registerIcon(GlobalValues.MODIDCORE + ":" + types[icon]);
		}
	}

	///** Adds the meta items to the tab */
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	//@Override
	//public void getSubItems(Item item, CreativeTabs tab, List list) {
	//	for (int meta = 0; meta < types.length; meta++) {
	//		list.add(new ItemStack(item, 1, meta));
	//	}
	//} 
	
	/** Returns the unlocalised name of the itemstack */
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return "item." + identifier + "." + types[is.getItemDamage()];
	}
}
