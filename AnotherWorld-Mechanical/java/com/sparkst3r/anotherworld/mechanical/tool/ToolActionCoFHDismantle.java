package com.sparkst3r.anotherworld.mechanical.tool;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cofh.api.block.IDismantleable;

import com.sparkst3r.anotherworld.api.tool.IToolAction;
import com.sparkst3r.anotherworld.util.EntityUtils;


public class ToolActionCoFHDismantle implements IToolAction{

	@Override
	public String identifier() {
		return "tool.tinker.mode.dismantle.action.dismantleCoFH";
	}

	@Override
	public boolean requiresClientRender() {
		return false;
	}

	@Override
	public void triggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		Block block = world.getBlock(x, y, z);
		ItemStack blockStack = ((IDismantleable)block).dismantleBlock(player, world, x, y, z, true);
		world.setBlockToAir(x, y, z);
		EntityUtils.dropItemInWorld(world, x, y, z, blockStack);
	}

	@Override
	public boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		Block block = world.getBlock(x, y, z);
		if (block != null && !block.equals(Block.getBlockFromName("air")) && block instanceof IDismantleable && ((IDismantleable)block).canDismantle(player, world, x, y, z)) {
			if(!world.isRemote) {
				return true;
			}
		}
		return false;
	}
	
}
