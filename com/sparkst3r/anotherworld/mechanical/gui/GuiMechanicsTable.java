package com.sparkst3r.anotherworld.mechanical.gui;


import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.sparkst3r.anotherworld.core.GlobalValues;
import com.sparkst3r.anotherworld.mechanical.MechanicalValues;
import com.sparkst3r.anotherworld.mechanical.container.ContainerMechanicsTable;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileMechanicsTable;


public class GuiMechanicsTable extends GuiContainer {
	/** The tile entity associated with the GUI*/
	public TileMechanicsTable tileEntity;
	
	/** The player viewing the GUI */
	public EntityPlayer player;
	
	public GuiMechanicsTable (InventoryPlayer inventoryPlayer, TileMechanicsTable tileEntity) {
		super(new ContainerMechanicsTable(inventoryPlayer, tileEntity));
		this.tileEntity = tileEntity;
		this.player = inventoryPlayer.player;
	}

	/** 
	 * Draws everything above the slots
	 */
	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		fontRendererObj.drawString(StatCollector.translateToLocal("inventory.mechTable"), 88, 1, 0xFFFFFF, true);
		fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 95, 69, 0xFFFFFF, true);
	}

	/** 
	 * Draws everything behind the slots
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(new ResourceLocation(GlobalValues.MODIDCORE, "textures/gui/MechanicsTable.png"));
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
	/**
	 * Called from the main game loop to update the screen.
	 */
	@Override
	public void updateScreen() {
		int x = this.tileEntity.xCoord;
		int y = this.tileEntity.yCoord;
		int z = this.tileEntity.zCoord;
		World world = this.tileEntity.getWorldObj();
		
		if(!world.getBlock(x, y, z).equals(MechanicalValues.blockMechTable) && world.getBlockMetadata(x, y, z) != 0) {
			//player.closeScreen();
		}
		
	}

}