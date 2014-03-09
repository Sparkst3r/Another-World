package com.sparkst3r.anotherworld.mechanical.tool;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.sparkst3r.anotherworld.api.tool.IToolAction;
import com.sparkst3r.anotherworld.mechanical.crafting.WorldCraftingManager;
import com.sparkst3r.anotherworld.util.WorldUtils;


public class ToolActionAssemble implements IToolAction{
	ItemStack newBlock;
	
	
	@Override
	public String identifier() {
		return "tool.tinker.mode.activate.action.assemble";
	}

	@Override
	public boolean requiresClientRender() {
		return false;
	}

	@Override
	public void triggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		WorldUtils.setBlockAt(world, x, y, z, Block.getBlockFromItem(newBlock.getItem()), this.newBlock.getItemDamage(), false);
	}

	@Override
	public boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		newBlock = WorldCraftingManager.getOutput(world, x, y, z);
		if (this.newBlock != null) {
			return true;
		}
		
		return false;
	}
	
}
