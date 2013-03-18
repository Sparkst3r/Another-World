package mods.anotherWorld.common.machines.tile;

import mods.anotherWorld.common.machines.Machines;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;


public class ItemSpaceChestHelper
{
	public static ItemSpaceChestHelper instance = new ItemSpaceChestHelper();
	private TileEntitySpaceChest itemRender = new TileEntitySpaceChest();
	public void renderChest(Block var1, int var2, float var3)
	{
         if (var1 == Machines.SpaceChest)
         {
                 TileEntityRenderer.instance.renderTileEntityAt(this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
         }
	}
}