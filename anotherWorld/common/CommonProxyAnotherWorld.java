package anotherWorld.common;

import cpw.mods.fml.common.SidedProxy;
import net.minecraft.item.ItemStack;

public class CommonProxyAnotherWorld {
	@SidedProxy(clientSide = "anotherWorld.client.ClientProxyAnotherWorld", serverSide = "anotherWorld.common.CommonProxyAnotherWorld")
	public static CommonProxyAnotherWorld proxy;
	//Register Renders, does nothing as the server doesn't render anything.
	public void registerRenders() {
		
	}
	
	public void addName(Object obj, String s) {
	}

	public void addLocalization(String s1, String string) {
	}

	public String getItemDisplayName(ItemStack newStack) {
		return "";
	}
	public String getCurrentLanguage() {
		return null;
	}
}