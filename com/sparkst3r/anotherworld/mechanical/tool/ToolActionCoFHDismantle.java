package com.sparkst3r.anotherworld.mechanical.tool;

import src.main.java.com.sparkst3r.anotherworld.api.tool.IToolAction;
import src.main.java.com.sparkst3r.anotherworld.util.EntityUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ToolActionCoFHDismantle implements IToolAction{

	@Override
	public String identifier() {
		return "action.dismantleTE";
	}

	@Override
	public String toolClass() {
		return "mode.tinker.dismantle";
	}

	@Override
	public boolean requiresClientRender() {
		return false;
	}

	@Override
	public void triggerAction(EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		Block block = Block.blocksList[world.getBlockId(x, y, z)];
		ItemStack blockStack = ((IDismantleable)block).dismantleBlock(player, world, x, y, z, true);
		world.setBlockToAir(x, y, z);
		EntityUtils.dropItemInWorld(world, x, y, z, blockStack);
	}

	@Override
	public boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		Block block = Block.blocksList[world.getBlockId(x, y, z)];
		if (block != null && block.blockID > 0 && block instanceof IDismantleable && ((IDismantleable)block).canDismantle(player, world, x, y, z)) {
			if(!world.isRemote) {
				return true;
			}
		}
		return false;
	}
	
}
