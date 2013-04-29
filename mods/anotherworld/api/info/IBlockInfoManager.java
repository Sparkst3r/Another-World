package mods.anotherworld.api.info;

public interface IBlockInfoManager {
	
	/**
	 * Adds an info page for a standard block eg. Vanilla, non-machine/automating block, non-custom rendered.
	 * @param infoPage The page implementing IStandardBlockInfoPage to be added.
	 * @return
	 */
	public abstract boolean addStandardBlockInfo(IStandardBlockInfoPage infoPage);
	
	
	
	
}
