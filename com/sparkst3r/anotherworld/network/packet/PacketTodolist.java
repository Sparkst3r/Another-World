/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.sparkst3r.anotherworld.mechanical.tileentity.TileManualCrusher;

import cpw.mods.fml.common.network.ByteBufUtils;

/** PacketManualCrusher
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 18 Feb 2014
 */
public class PacketTodolist extends AbstractPacket {

	    int x, y, z;
		private NBTTagCompound tag;

	    public PacketTodolist() {}

	    public PacketTodolist(int x, int y, int z, NBTTagCompound tag) {
	        this.x = x;
	        this.y = y;
	        this.z = z;
	        this.tag = tag;
	    }

	    @Override
	    public void encodeInto (ChannelHandlerContext ctx, ByteBuf buffer) {
	        buffer.writeInt(x);
	        buffer.writeInt(y);
	        buffer.writeInt(z);
	        ByteBufUtils.writeTag(buffer, this.tag);
	        
	    }

	    @Override
	    public void decodeInto (ChannelHandlerContext ctx, ByteBuf buffer) {
	        x = buffer.readInt();
	        y = buffer.readInt();
	        z = buffer.readInt();
	        ByteBufUtils.readTag(buffer);
	    }

	    @Override
	    public void handleClientSide (EntityPlayer player) {
	    }

	    @Override
	    public void handleServerSide (EntityPlayer player) {

	    }

	}