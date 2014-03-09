package com.sparkst3r.anotherworld.mechanical.blockinfo;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;

import com.sparkst3r.anotherworld.api.info.IBlockInfoManager;
import com.sparkst3r.anotherworld.api.info.IStandardBlockInfoPage;


public class BlockInfoManager implements IBlockInfoManager {
	public static Map<String, IStandardBlockInfoPage> standardInfo = new HashMap<String, IStandardBlockInfoPage>();
	
	
	/**
	 * Adds a standard info page
	 */
	@Override
	public boolean addStandardBlockInfo(IStandardBlockInfoPage infoPage) {
		
		if (infoPage != null && infoPage.block().getItem() != null) {
			ItemStack block = infoPage.block();
			String key = block.getUnlocalizedName() + ":" + block.getItemDamage();
			standardInfo.put(key, infoPage);
			
			if (standardInfo.get(key).equals(infoPage)) {
				return true;
			}
		}
		return false;
	}
	
}
