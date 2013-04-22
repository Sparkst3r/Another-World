package mods.anotherworld.mechanical.tool;

import mods.anotherworld.api.tool.IToolAction;
import mods.anotherworld.mechanical.MechanicalValues;
import mods.anotherworld.mechanical.util.MechanicsTableValidation;
import mods.anotherworld.util.WorldUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToolActionAssemble implements IToolAction{

	@Override
	public String identifier() {
		return "action.assemble";
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
