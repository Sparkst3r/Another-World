package com.sparkst3r.anotherworld.mechanical.tool;

import java.util.ArrayList;
import java.util.List;

import com.sparkst3r.anotherworld.api.tool.IToolAction;
import com.sparkst3r.anotherworld.api.tool.IToolActionManager;
import com.sparkst3r.anotherworld.api.tool.IToolMode;


import net.minecraft.item.ItemStack;


public class ToolActionManager implements IToolActionManager {
	public static List<IToolAction> actions = new ArrayList<IToolAction>();
	
	@Override
	public boolean addAction(IToolAction action) {
		actions.add(action);
		return true;
	}
	
	public static List<IToolAction> getActions(ItemStack stack) {
		List<IToolAction> validActions = new ArrayList<IToolAction>();
		
		IToolMode mode = ToolModeManager.getModes().get(stack.getItemDamage());
		for (int action = 0; action < actions.size(); action++) {
			if (actions.get(action).identifier().contains(mode.identifier())) {
				validActions.add(actions.get(action));
			}
		}
		return validActions;
	}
	
	public static IToolAction getAction(int index) {
		return actions.get(index);
	}
	
	
}
