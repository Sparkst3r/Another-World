package mods.anotherWorld.common.spaceship.render;


import mods.anotherWorld.common.spaceship.blocks.SpaceshipBlocks;
import mods.anotherWorld.common.spaceship.tile.TileEntityJet;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;

public class ItemJetHelper
{
	public static ItemJetHelper instance = new ItemJetHelper();
	private TileEntityJet itemRender = new TileEntityJet();
	public void renderJet(Block var1, int var2, float var3)
	{
         if (var1 == SpaceshipBlocks.JetBlock)
         {
                 TileEntityRenderer.instance.renderTileEntityAt(this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
         }
	}
}