package mods.anotherworld.mechanical.tool;

import java.util.ArrayList;
import java.util.List;

import mods.anotherworld.api.tool.IToolAction;
import mods.anotherworld.api.tool.IToolActionManager;
import net.minecraft.item.ItemStack;

public class ToolActionManager implements IToolActionManager {
	public static List<IToolAction> actions = new ArrayList<IToolAction>();
	
	@Override
	public boolean addAction(IToolAction action) {
		actions.add(action);
		return true;
	}
	
	public static List<IToolAction> getActions(ItemStack stack) {
		
		
		
		for(int x = 0; x < actions.size(); x++) {
			if(true){//stack.getTagCompound().hasKey("identifier") && actions.iterator().next().toolClass().equals("tool." + stack.getTagCompound().getString("identifier"))){
		//		list.add(actions.get(x));
			}
		}
		
		return actions;
	}
	
	
}
