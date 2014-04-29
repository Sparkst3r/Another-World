package com.sparkst3r.anotherworld.mechanical.tool;

import com.sparkst3r.anotherworld.api.tool.IToolAction;
import com.sparkst3r.anotherworld.api.tool.IToolDismantleable;
import com.sparkst3r.anotherworld.util.EntityUtils;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ToolActionAWDismantle implements IToolAction{

	@Override
	public String identifier() {
		return "tool.tinker.mode.dismantle.action.dismantleAW";
	}

	@Override
	public boolean requiresClientRender() {
		return false;
	}

	@Override
	public void triggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		Block block = world.getBlock(x, y, z);
		ItemStack blockStack = ((IToolDismantleable)block).dismantle(player, world, x, y, z);
		world.setBlockToAir(x, y, z);
		EntityUtils.dropItemInWorld(world, x, y, z, blockStack);
	}

	@Override
	public boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		Block block = world.getBlock(x, y, z);
		if (block != null && !block.equals(Block.getBlockFromName("air")) && block instanceof IToolDismantleable && ((IToolDismantleable)block).canDismantle(player, world, x, y, z)) {
			if(!world.isRemote) {
				return true;
			}
		}
		return false;
	}
	
}
