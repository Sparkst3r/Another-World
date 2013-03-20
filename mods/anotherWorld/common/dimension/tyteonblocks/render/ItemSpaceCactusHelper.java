package mods.anotherWorld.common.dimension.tyteonblocks.render;

import mods.anotherWorld.common.basicBlocks.BasicBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;


public class ItemSpaceCactusHelper
{
	public static ItemSpaceCactusHelper instance = new ItemSpaceCactusHelper();
	private TileSpaceCactus itemRender = new TileSpaceCactus();
	public void renderSpaceCactus(Block var1, int var2, float var3)
	{
         if (var1 == BasicBlocks.SpaceCactus)
         {
                 TileEntityRenderer.instance.renderTileEntityAt(this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
         }
	}
}