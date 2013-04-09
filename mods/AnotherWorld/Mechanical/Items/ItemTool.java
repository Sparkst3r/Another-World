package mods.AnotherWorld.Mechanical.Items;

import java.util.List;
import java.util.Stack;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.AnotherWorld.Core.GlobalValues;
import mods.AnotherWorld.Mechanical.MechanicalValues;
import mods.AnotherWorld.Mechanical.Util.ItemToolSwitcherHelper;
import mods.AnotherWorld.Mechanical.Util.ItemToolUsedHelper;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;


/**
 * Tinkering tool(s) class. 
 * Meta data for multiple modes(Upgrades)
 * @author Sparkst3r
 *
 */
public class ItemTool extends Item {

	/** Texture file names + code name */
    public static String[] types = new String[] {"tinkerBase", "tinkerActivate", "tinkerRotate", "tinkerHelp", "tinkerSetting"};     
    
    /** Human-Readable names */
    public static String[] names = new String[] {"Tinkering Tools", "Activation Tinkering Tool", "Turny Tinkering Tool", "Helpful Tinkering Tool", "Altering Tinkering Tool"};
    
	/**Icon array for the textures */
	@SideOnly(Side.CLIENT)
	private Icon[] iconBuffer;
    
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
	
	/** Called on creation 
	 *  Assigns a "type" to the itemstack so the modes can be switched correctly
	 */
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		if( stack.stackTagCompound == null) {
			stack.setTagCompound(new NBTTagCompound());
		}
		
		for(int i = 0; i < 5; i++) {
			if(stack.getItemDamage() == i) {
				stack.stackTagCompound.setShort("type", (short) i);
			}
		}

	}
	
	/** Callback for item use(Right click)
	 * Switches between tools
	 */
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!player.isSneaking()) {
			
			/** Creates a new stackTagCompound for creative spawned items. */
			if( stack.stackTagCompound == null) {
				stack.setTagCompound(new NBTTagCompound());
				stack.stackTagCompound.setShort("type", (short) 4);
			}
			return ItemToolSwitcherHelper.getTypeFromNBT(stack, player);
		}
		return stack;
	}
	
	/** Called when the item is used on a block **/
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		if(stack.getItemDamage() == 1) {
				ItemToolUsedHelper.activationToolUsed(stack, player, world, x, y, z, side, locX, locY, locZ);
		}
		return false;
		
	}
	
	/** Provides access to add custom lines to the item description **/
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)  {
		switch(stack.getItemDamage()) {
			case 0:
				list.add("Right click in your hand to start using");
				break;
			case 1:
				list.add("Used to activate certain blocks");
				break;
			case 2:
				list.add("Rotates valid blocks when clicked");
				break;
			case 3:
				list.add("Right click on things to get information for it");
				break;
			case 4:
				list.add("Can change settings of blocks");
				break;
		}
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
		this.iconBuffer = new Icon[types.length];
		
		String id = GlobalValues.ModIDCore + ":";
		iconBuffer[0] = ir.registerIcon(id + types[0]);
		iconBuffer[1] = ir.registerIcon(id + types[1]);
		iconBuffer[2] = ir.registerIcon(id + types[2]);	
		iconBuffer[3] = ir.registerIcon(id + types[3]);
		iconBuffer[4] = ir.registerIcon(id + types[4]);
	}
	
	/** Adds the meta items to the tab */
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int meta = 0; meta < 5; meta++) {
			list.add(new ItemStack(id, 1, meta));
		}
	} 
	
	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return types[is.getItemDamage()];
	}

	
}
