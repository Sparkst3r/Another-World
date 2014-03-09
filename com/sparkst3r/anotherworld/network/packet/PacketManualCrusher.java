/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.network.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.world.World;

import com.sparkst3r.anotherworld.mechanical.blocks.BlockManualCrusher;
import com.sparkst3r.anotherworld.mechanical.tileentity.TileManualCrusher;

/** PacketManualCrusher
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 18 Feb 2014
 */
public class PacketManualCrusher extends AbstractPacket {

	    int x, y, z;
		int clickState;

	    public PacketManualCrusher() {}

	    public PacketManualCrusher(int x, int y, int z, int clickState) {
	        this.x = x;
	        this.y = y;
	        this.z = z;
	        this.clickState = clickState;
	    }

	    @Override
	    public void encodeInto (ChannelHandlerContext ctx, ByteBuf buffer) {
	        buffer.writeInt(x);
	        buffer.writeInt(y);
	        buffer.writeInt(z);
	        buffer.writeInt(clickState);
	    }

	    @Override
	    public void decodeInto (ChannelHandlerContext ctx, ByteBuf buffer) {
	        x = buffer.readInt();
	        y = buffer.readInt();
	        z = buffer.readInt();
	        clickState = buffer.readInt();
	    }

	    @Override
	    public void handleClientSide (EntityPlayer player) {
	    //	//World world = player.worldObj;
	    	//System.out.println("Client  " +x+" "+y+" "+z);
	    //	if (world.getTileEntity(x, y, z) instanceof TileManualCrusher) {
	    //		TileManualCrusher tile = (TileManualCrusher)world.getTileEntity(x, y, z);
	    ///		if (tile.getDescriptionPacket() instanceof S35PacketUpdateTileEntity) {
	    //			tile.clickState = ((S35PacketUpdateTileEntity)tile.getDescriptionPacket()).func_148857_g().getInteger("clickState");
	    //		}
	    //	}
	    //	world.markBlockForUpdate(x, y, x);
	    //	System.out.println("Client");
	    }

	    @Override
	    public void handleServerSide (EntityPlayer player) {
	    	World world = player.worldObj;
	    	
	    	if (world.getTileEntity(x, y, z) instanceof TileManualCrusher) {
	    		TileManualCrusher tile = (TileManualCrusher)world.getTileEntity(x, y, z);
	    		tile.clickState = clickState;
	    	}
	    }

	}