package mods.anotherWorld.common.machines.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import mods.anotherWorld.common.GlobalIDs;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class SeparatorRender implements ISimpleBlockRenderingHandler
{
public void renderInventoryBlock(Block var1, int var2, int var3, RenderBlocks var4)
{
         if (var3 == this.getRenderId())
         {
                 GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
                 GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                 ItemSeperatorHelper.instance.renderSeparator(var1, var2, 0.0F);
                 GL11.glEnable(GL12.GL_RESCALE_NORMAL);
         }
}
public boolean renderWorldBlock(IBlockAccess var1, int var2, int var3, int var4, Block var5, int var6, RenderBlocks var7)
{
         return false;
}
public boolean shouldRender3DInInventory()
{
         return true;
}
	@Override
	public int getRenderId() {
         return GlobalIDs.SeparatorRenderID;
	}
}