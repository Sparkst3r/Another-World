package mods.anotherWorld.common.machines.render;

import mods.anotherWorld.common.machines.Machines;
import mods.anotherWorld.common.machines.tile.TileEntitySeparator;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;

public class ItemSeperatorHelper
{
	public static ItemSeperatorHelper instance = new ItemSeperatorHelper();
	private TileEntitySeparator itemRender = new TileEntitySeparator();
	public void renderSeparator(Block var1, int var2, float var3)
	{
         if (var1 == Machines.Separator)
         {
                 TileEntityRenderer.instance.renderTileEntityAt(this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
         }
	}
}