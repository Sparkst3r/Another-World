package com.sparkst3r.anotherworld.mechanical.tool;

import com.sparkst3r.anotherworld.api.tool.IToolAction;
import com.sparkst3r.anotherworld.mechanical.MechanicalValues;
import com.sparkst3r.anotherworld.mechanical.util.MechanicsTableValidation;
import com.sparkst3r.anotherworld.util.EntityUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ToolActionDismantleMechTable implements IToolAction{

	private int orient = -1;


	@Override
	public String identifier() {
		return "action.dismantlemechtable";
	}
	
	@Override
	public boolean requiresClientRender() {
		return false;
	}

	@Override
	public void triggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		MechanicsTableValidation.breakTableCompletely(world, x, y, z, orient);
		EntityUtils.dropItemInWorld(world, x, y, z, new ItemStack(MechanicalValues.BlockBasePartsField, 4, 1));
	}

	@Override
	public boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		for (int orientation = 0; orientation < 4; orientation++) {
			if (MechanicsTableValidation.validateBlocksForCompleted(world, x, y, z, orientation)) {
				orient = orientation;
			}
		}
		if (orient != -1) {
			return true;
		}
		return false;
	}
	
}
