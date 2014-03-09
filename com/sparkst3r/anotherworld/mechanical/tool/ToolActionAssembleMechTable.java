package com.sparkst3r.anotherworld.mechanical.tool;

import com.sparkst3r.anotherworld.api.tool.IToolAction;
import com.sparkst3r.anotherworld.mechanical.MechanicalValues;
import com.sparkst3r.anotherworld.mechanical.util.MechanicsTableValidation;
import com.sparkst3r.anotherworld.util.WorldUtils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ToolActionAssembleMechTable implements IToolAction{

	@Override
	public String identifier() {
		return "tool.tinker.mode.activate.action.assemblemechtable";
	}


	@Override
	public boolean requiresClientRender() {
		return false;
	}

	@Override
	public void triggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		MechanicsTableValidation.placeTable(world, x, y, z, MechanicsTableValidation.validateBlocks(world, x, y, z));
	}

	@Override
	public boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		if(WorldUtils.isBlockAt(world, x, y, z, MechanicalValues.BlockBasePartsField, 1)) {
			return true;
		}
		return false;
	}
	
}
