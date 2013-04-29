package mods.anotherworld.core.blockinfo;

import java.util.ArrayList;
import java.util.List;

import mods.anotherworld.api.info.IBlockInfoManager;
import mods.anotherworld.api.info.IStandardBlockInfoPage;

public class BlockInfoManager implements IBlockInfoManager {
	public static List<IStandardBlockInfoPage> standardInfo = new ArrayList<IStandardBlockInfoPage>();
	@Override
	public boolean addStandardBlockInfo(IStandardBlockInfoPage infoPage) {
		standardInfo.add(infoPage);
		return true;
	}
	
}
