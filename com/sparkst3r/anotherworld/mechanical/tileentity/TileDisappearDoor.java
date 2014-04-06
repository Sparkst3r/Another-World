/**
 * Released as WTFPL(Do What The Fuck You Want To Public License)
 * See assets/Licence.txt
 * A link to the github (https://github.com/Sparkst3r/Another-World) would be nice, but not compulsory.
 */
package com.sparkst3r.anotherworld.mechanical.tileentity;

import com.sparkst3r.anotherworld.mechanical.MechanicalValues;
import com.sparkst3r.anotherworld.util.WorldUtils;

import net.minecraft.tileentity.TileEntity;

/** TileDisappearDoor
 *
 * @author Sparkst3r(Josh Lockheed)
 * @since 27 Mar 2014
 */
public class TileDisappearDoor extends TileEntity {
	
	private int ticks = 40;
	
	/** 
	 * Update entity
	 */
	@Override
	public void updateEntity() {
		if (ticks == 0) {
			this.invalidate();
			this.getWorldObj().setBlock(xCoord, yCoord, zCoord, MechanicalValues.blockDisappearDoor, 0, 2);
		}
		else {
			ticks--;
		}


	}
}
