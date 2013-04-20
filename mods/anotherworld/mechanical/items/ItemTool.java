package mods.anotherworld.mechanical.items;

import java.util.List;

import mods.anotherworld.api.tool.IItemTool;
import mods.anotherworld.core.GlobalValues;
import mods.anotherworld.mechanical.util.ItemToolSwitcherHelper;
import mods.anotherworld.mechanical.util.ItemToolUsedHelper;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


/**
 * Tinkering tool(s) class. 
 * Meta data for multiple modes(Upgrades)
 * @author Sparkst3r
 *
 */
public class ItemTool extends Item implements IItemTool{

	public enum ItemToolEnum {
	    ACTIVATE, DISMANTLE, ROTATE, HELP, SETTINGS, MOVE;
	}
	
	/** Texture file names + code name */
	public static String[] types = new String[] {"tinkerActivate", "tinkerDismantle", "tinkerRotate", "tinkerHelp", "tinkerSetting", "tinkerMove"};
	
	/** Human-Readable names */
	public static String[] names = new String[] {"Tinkering Tools", "null", "null", "null", "null"};

	/** Information */
	public static String[] info1 = new String[] {
		"Right click certain blocks to activate",
		"Right click a machine or mechanical",
		"Right click a rotatable block to turn it",
		"Right click any block to get information",
		"Right click a machine or mechanical device",
		"Right click a valid block to pick it up"
	};
	public static String[] info2 = new String[] {
		"their features",
		"device to safely dismantle them",
		"",
		"about that block",
		"device to alter it's settings",
		"and place it again"
	};
	
	public static String[] info3 = new String[] {
		"HINT: Drop 4 copper ingots and 2 tin gears", "", "", "", "", ""
	};
	public static String[] info4 = new String[] {
		"on a smooth stone block and right click it.", "", "", "", "", ""
	};
    
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	public static Icon[] iconBuffer;
    
	/** 
	 * Constructor
	 * @param id
	 */
	public ItemTool(int id) {
		super(id);
        this.setCreativeTab(GlobalValues.AnotherTab);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		GameRegistry.registerItem(this, "tinkeringTools");
	}
	
	/** 
	 * Called on creation 
	 * Assigns a "type" to the itemstack so the modes can be switched correctly
	 */
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		if( stack.stackTagCompound == null) {
			stack.setTagCompound(new NBTTagCompound());
		}
		for(int i = 0; i < 6; i++) {
			if(stack.getItemDamage() == i) {
				stack.stackTagCompound.setShort("type", (short) i);
			}
		}

	}
	
	/** Callback for item use(Right click)
	 * Switches between tools
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!player.isSneaking()) {
			
			/** Creates a new stackTagCompound for creative spawned items. */
			if( stack.stackTagCompound == null) {
				stack.setTagCompound(new NBTTagCompound());
				stack.stackTagCompound.setShort("type", (short) 5);
			}
			return ItemToolSwitcherHelper.getTypeFromNBT(stack, player);
		}
		return stack;
	}
	
	/** Called when the item is used on a block **/
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		if(stack.getItemDamage() == 0) {
			ItemToolUsedHelper.instance.activationToolUsed(stack, player, world, x, y, z, side, locX, locY, locZ);
		}
		if(stack.getItemDamage() == 1) {
			ItemToolUsedHelper.instance.dismantleToolUsed(stack, player, world, x, y, z, side, locX, locY, locZ);
		}
		else if(stack.getItemDamage() == 5) {
			ItemToolUsedHelper.instance.moveToolUsed(stack, player, world, x, y, z, side, locX, locY, locZ);
		}
		
		
		
		
		return true;
	}
	
	/** Provides access to add custom lines to the item description **/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)  {
		int meta = stack.getItemDamage();
		
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
        	list.add(info1[meta]);
        	list.add(info2[meta]);
        	list.add(info3[meta]);
        	list.add(info4[meta]);
        }
        else {list.add("Hold SHIFT for more info");}
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
		iconBuffer = new Icon[types.length + 7];
		
		String id = GlobalValues.ModIDCore + ":";
		for (int icon = 0; icon < types.length; icon++) {
			iconBuffer[icon] = ir.registerIcon(id + types[icon]);
		}
		
		iconBuffer[types.length + 1] = ir.registerIcon(id + "iconTinkerActivate");
		iconBuffer[types.length + 2] = ir.registerIcon(id + "iconTinkerDismantle");
		iconBuffer[types.length + 3] = ir.registerIcon(id + "iconTinkerRotate");
		iconBuffer[types.length + 4] = ir.registerIcon(id + "iconTinkerHelp");
		iconBuffer[types.length + 5] = ir.registerIcon(id + "iconTinkerSetting");
		iconBuffer[types.length + 6] = ir.registerIcon(id + "iconTinkerMove");
	}
	
	/** Adds the meta items to the tab */
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		list.add(new ItemStack(id, 1, 0));
	} 
	
	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return types[is.getItemDamage()];
	}

	
}
