package mods.anotherworld.world.entity;

import mods.anotherworld.core.GlobalValues;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityBee extends EntityMob {
	
	public EntityBee(World par1World) {
		super(par1World);
		texture = GlobalValues.entityDir + "bee.png";
		this.setSize(0.5F, 0.5F);
		this.getNavigator().setAvoidsWater(true);
		

		
	}
	
	@Override
	public int getMaxHealth() {
		return 2;
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
    public void onLivingUpdate() {
    	//this.posX += 1;
    }
	
}
