package mods.anotherworld.mechanical.gui;


import mods.anotherworld.core.GlobalValues;
import mods.anotherworld.mechanical.MechanicalValues;
import mods.anotherworld.mechanical.container.ContainerMechanicsTable;
import mods.anotherworld.mechanical.tileentity.TileMechanicsTable;
import mods.anotherworld.util.GUIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;


public class GuiMechanicsTable extends GUIBase {
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
		fontRenderer.drawString("Mechanics Table", 88, 1, 0xFFFFFF, true);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 95, 69, 0xFFFFFF, true);
	}

	/** 
	 * Draws everything behind the slots
	 */
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(GlobalValues.guiDir + "MechanicsTable.png");
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
		World world = this.tileEntity.worldObj;
		
		if(world.getBlockId(x, y, z) != MechanicalValues.BlockMechTablePartsField.blockID && world.getBlockMetadata(x, y, z) != 0) {
			player.closeScreen();
		}
		
	}

}