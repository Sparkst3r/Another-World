package mods.anotherworld.mechanical.tool;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.anotherworld.api.tool.IToolDismantleable;
import mods.anotherworld.api.tool.IToolAction;
import mods.anotherworld.util.EntityUtils;

public class ToolActionAWDismantle implements IToolAction{

	@Override
	public String identifier() {
		return "action.dismantleAW";
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
		ItemStack blockStack = ((IToolDismantleable)block).dismantle(player, world, x, y, z);
		world.setBlockToAir(x, y, z);
		EntityUtils.dropItemInWorld(world, x, y, z, blockStack);
	}

	@Override
	public boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		Block block = Block.blocksList[world.getBlockId(x, y, z)];
		if (block != null && block.blockID > 0 && block instanceof IToolDismantleable && ((IToolDismantleable)block).canDismantle(player, world, x, y, z)) {
			if(!world.isRemote) {
				return true;
			}
		}
		return false;
	}
	
}
