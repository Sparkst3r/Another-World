package mods.anotherworld.api.info;

/**
 * IBlockInfoManager
 * 
 * Provides access to the list of pages for the help function of the tinkering tool
 * 
 * @author Sparkst3r
 *
 */
public interface IBlockInfoManager {
	
	/**
	 * Adds an info page for a standard block eg. Vanilla, non-machine/automating block, non-custom rendered.
	 * @param infoPage The page implementing IStandardBlockInfoPage to be added.
	 * @return
	 */
	public abstract boolean addStandardBlockInfo(IStandardBlockInfoPage infoPage);
}
