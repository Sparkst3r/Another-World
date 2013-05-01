package mods.anotherworld.mechanical.tool;

import mods.anotherworld.api.tool.IToolAction;
import mods.anotherworld.mechanical.crafting.WorldCraftingManager;
import mods.anotherworld.util.WorldUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToolActionAssemble implements IToolAction{
	ItemStack newBlock;
	
	
	@Override
	public String identifier() {
		return "action.activate";
	}

	@Override
	public String toolClass() {
		return "mode.tinker.activate";
	}

	@Override
	public boolean requiresClientRender() {
		return false;
	}

	@Override
	public void triggerAction(EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		WorldUtils.setBlockAt(world, x, y, z, Block.blocksList[this.newBlock.itemID], this.newBlock.getItemDamage(), false);
	}

	@Override
	public boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		
		newBlock = WorldCraftingManager.getOutput(world, x, y, z);
		if (this.newBlock != null) { 
			System.out.println("BLAOC");
			return true;
		}
		
		return false;
	}
	
}
