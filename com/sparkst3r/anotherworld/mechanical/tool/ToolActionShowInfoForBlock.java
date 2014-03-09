package com.sparkst3r.anotherworld.mechanical.tool;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.sparkst3r.anotherworld.api.info.IStandardBlockInfoPage;
import com.sparkst3r.anotherworld.api.tool.IToolAction;
import com.sparkst3r.anotherworld.mechanical.blockinfo.BlockInfoManager;
import com.sparkst3r.anotherworld.util.MetaSensitiveBlock;


public class ToolActionShowInfoForBlock implements IToolAction{
	private IStandardBlockInfoPage info;

	public String[] blurbInfo = null; 
	
	public boolean startRendering = false;

	public String[] fullInfo = null;

	public ItemStack renderIcon = null;
	
	public ItemStack clickedBlock = null;
	
	@Override
	public String identifier() {
		return "tool.tinker.mode.help.action.showinfo";
	}


	@Override
	public boolean requiresClientRender() {
		return true;
	}

	@Override
	public void triggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		this.blurbInfo = info.blurbInfo();
		this.fullInfo  = info.fullInfo();
		this.renderIcon = info.displayBlock();
		this.clickedBlock = info.block();
		//RenderTick.timeSinceRenderRequest = 2000;
	}

	@Override
	public boolean canTriggerAction(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float locX, float locY, float locZ) {
		Block block = world.getBlock(x, y, z);
		int metadata = world.getBlockMetadata(x, y, z);
		IStandardBlockInfoPage infoPage = BlockInfoManager.standardInfo.get(block.getUnlocalizedName() + ":" + metadata);
		
		
		if (infoPage != null) {
			this.info = infoPage;
			return true;
		}
		
		return false;
	}
	
}
