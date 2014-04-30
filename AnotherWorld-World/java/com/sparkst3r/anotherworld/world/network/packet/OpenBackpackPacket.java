/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.world.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import com.sparkst3r.anotherworld.network.packet.AbstractPacket;
import com.sparkst3r.anotherworld.world.AnotherWorldExpansionWorld;
import com.sparkst3r.anotherworld.world.GuiHandlerWorld;

/**OpenBackpackPacket
 *
 * @author Sparkst3r
 * @since 29 Apr 2014
 */
public class OpenBackpackPacket extends AbstractPacket {

	/** This packet has no data */
	public OpenBackpackPacket() {}
	
	/** This packet has no data */
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {}

	/** This packet has no data */
	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {}

	/** This packet is never sent to the client */
	@Override
	public void handleClientSide(EntityPlayer player) {}

	/**
	 * Opens the backpack contents gui on the server
	 */
	@Override
	public void handleServerSide(EntityPlayer player) {
		player.openGui(AnotherWorldExpansionWorld.instance, GuiHandlerWorld.BACKPACK, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posY);
	}

}
