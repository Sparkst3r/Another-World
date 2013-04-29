package mods.anotherworld.mechanical.tool;

import mods.anotherworld.api.info.IStandardBlockInfoPage;
import mods.anotherworld.api.tool.IToolAction;
import mods.anotherworld.core.blockinfo.BlockInfoManager;
import mods.anotherworld.mechanical.tick.RenderTick;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ToolActionShowInfoForBlock implements IToolAction{
	private IStandardBlockInfoPage info;

	public String[] blurbInfo = null; 
	
	public boolean startRendering = false;

	public String[] fullInfo = null;

	public ItemStack renderIcon = null;
	
	public ItemStack clickedBlock = null;
	
	@Override
	public String identifier() {
		return "action.showinfoblock";
	}

	@Override
	public String toolClass() {
		return "mode.tinker.help";
	}

	@Override
	public boolean requiresClientRender() {
		return true;
	}

	@Override
	public void triggerAction(EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		this.blurbInfo = info.blurbInfo();
		this.fullInfo  = info.fullInfo();
		this.renderIcon = info.displayBlock();
		this.clickedBlock = info.block();
		RenderTick.timeSinceRenderRequest = 2000;
	}

	@Override
	public boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		Block block = Block.blocksList[world.getBlockId(x, y, z)];
		int metadata = world.getBlockMetadata(x, y, z);
		for (IStandardBlockInfoPage info : BlockInfoManager.standardInfo) {
			if (info.block().itemID == block.blockID && info.block().getItemDamage() == metadata) {
				this.info = info;
				return true;
			}
		}
		return false;
	}
	
}
