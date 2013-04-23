package mods.anotherworld.api.dummy;

import mods.anotherworld.api.tool.IToolAction;
import mods.anotherworld.api.tool.IToolActionManager;
import mods.anotherworld.api.tool.IToolMode;
import mods.anotherworld.api.tool.IToolModeManager;

public class ToolManagerDummy implements IToolModeManager, IToolActionManager {

	@Override
	public boolean addMode(IToolMode mode) {
		return false;
	}

	@Override
	public boolean addAction(IToolAction action) {
		return false;
	}
	
}
