package mods.anotherworld.mechanical.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.anotherworld.api.tool.IToolAction;
import mods.anotherworld.mechanical.MechanicalValues;
import mods.anotherworld.mechanical.util.MechanicsTableValidation;
import mods.anotherworld.util.EntityUtils;

public class ToolActionDismantleMechTable implements IToolAction{

	private int orient = -1;


	@Override
	public String identifier() {
		return "action.dismantlemechtable";
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
