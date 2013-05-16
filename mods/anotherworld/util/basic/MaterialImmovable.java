package mods.anotherworld.util.basic;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialImmovable extends Material{
    public int mobilityFlag;
	public MaterialImmovable(MapColor colour) {
		super(colour);
		this.setImmovableMobility();
	}
}
