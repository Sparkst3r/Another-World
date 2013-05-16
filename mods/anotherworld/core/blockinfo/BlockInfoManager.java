package mods.anotherworld.core.blockinfo;

import java.util.HashMap;
import java.util.Map;

import mods.anotherworld.api.info.IBlockInfoManager;
import mods.anotherworld.api.info.IStandardBlockInfoPage;
import mods.anotherworld.util.MetaSensitiveBlock;
import net.minecraft.block.Block;

public class BlockInfoManager implements IBlockInfoManager {
	public static Map<MetaSensitiveBlock, IStandardBlockInfoPage> standardInfo = new HashMap<MetaSensitiveBlock, IStandardBlockInfoPage>();
	
	
	/**
	 * Adds a standard info page
	 */
	@Override
	public boolean addStandardBlockInfo(IStandardBlockInfoPage infoPage) {
		
		if (infoPage != null && Block.blocksList[infoPage.block().itemID] != null) {
			
			MetaSensitiveBlock key = new MetaSensitiveBlock(Block.blocksList[infoPage.block().itemID], infoPage.block().getItemDamage());
			standardInfo.put(key, infoPage);
			
			if (standardInfo.get(key).equals(infoPage)) {
				return true;
			}
		}
		return false;
	}
	
}
