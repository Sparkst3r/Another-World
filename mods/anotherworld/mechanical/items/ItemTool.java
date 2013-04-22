package mods.anotherworld.mechanical.items;

import java.util.List;

import mods.anotherworld.api.tool.IItemTool;
import mods.anotherworld.api.tool.IToolAction;
import mods.anotherworld.core.GlobalValues;
import mods.anotherworld.mechanical.tool.ToolActionManager;
import mods.anotherworld.mechanical.tool.ToolModeManager;
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
	 * Assigns a "type" to the ItemStack so the modes can be switched correctly
	 */
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			stack.setTagCompound(new NBTTagCompound());
			stack.stackTagCompound.setString("type", ToolModeManager.getModes().get(stack.getItemDamage()).identifier().substring(12));
		}

	}
	
	/** Callback for item use(Right click)
	 * Switches between tools
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote && Keyboard.isKeyDown(Keyboard.KEY_R)) {
			if(stack.getTagCompound() == null) {
				stack.setTagCompound(new NBTTagCompound());
				stack.getTagCompound().setString("type", ToolModeManager.getModes().get(ToolModeManager.getModes().size() - 1).identifier().substring(12));
			}
			
			ItemStack newStack = new ItemStack(stack.itemID, 1, 0);
			newStack.setTagCompound(new NBTTagCompound());
			newStack.getTagCompound().setString("type", stack.getTagCompound().getString("type"));
			


			if (stack.getTagCompound().getString("type").equals(ToolModeManager.getModes().get(stack.getItemDamage()).identifier().substring(12))) {
				newStack.setItemDamage(0);
			}
			
			else {
				newStack.setItemDamage(stack.getItemDamage() + 1);
				newStack.getTagCompound().setString("type", stack.getTagCompound().getString("type"));
			}
			return newStack;
		}
		return stack;
	}
	
	/** Called when the item is used on a block **/
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		if(!world.isRemote && player.isSneaking()) {
			List<IToolAction> list = ToolActionManager.getActions(stack);
			if (list != null) {
				for(int action = 0; action < list.size(); action++){
					if (list.get(action).canTriggerAction(stack, player, world, x, y, z, side, locX, locY, locZ)) {
						list.get(action).triggerAction(player, world, x, y, z, side, locX, locY, locZ);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/** Provides access to add custom lines to the item description **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)  {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
			for (int line = 0; line < ToolModeManager.getModes().get(stack.getItemDamage()).infoLine().length; line++) {
				if(ToolModeManager.getModes().get(stack.getItemDamage()).infoLine()[line] != null) {
					list.add(ToolModeManager.getModes().get(stack.getItemDamage()).infoLine()[line]);
				}
			}
		}
		else {
			list.add("Press SHIFT for more info");
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
	public void registerIcons(IconRegister ir) {
		iconBuffer = new Icon[(ToolModeManager.getModes().size() * 2) + 1];		
		String id = GlobalValues.ModIDCore + ":";
		for (int icon = 0; icon < ToolModeManager.getModes().size(); icon++) {
			iconBuffer[icon] = ir.registerIcon(id + ToolModeManager.getModes().get(icon).texture());
			iconBuffer[ToolModeManager.getModes().size() + icon] = ir.registerIcon(id + ToolModeManager.getModes().get(icon).icon());
		}
	}
	
	/** Adds the meta items to the tab */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) {
			list.add(new ItemStack(id, 1, 0));
	} 
	
	/** Returns the unlocalised name of the block*/
	@Override
	public String getUnlocalizedName(ItemStack is) {
		return 	ToolModeManager.getModes().get(is.getItemDamage()).identifier().substring(5);
	}
}
