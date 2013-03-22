package mods.anotherWorld.common.spaceship.items;

import net.minecraft.item.Item;

public class SpaceshipItems {
	public static Item CarbonPlating;
	public static String ItemCarbonPlatingName = "Carbon Plating";
	public static int ItemCarbonPlatingID = 8020;

	public static void addItems() {
		CarbonPlating = new ItemCarbonPlating(ItemCarbonPlatingID, ItemCarbonPlatingName ,"carbonUp");
	}
}
