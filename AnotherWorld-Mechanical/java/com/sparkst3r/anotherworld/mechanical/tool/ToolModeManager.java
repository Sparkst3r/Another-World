package com.sparkst3r.anotherworld.mechanical.tool;

import java.util.ArrayList;
import java.util.List;

import com.sparkst3r.anotherworld.api.tool.IToolMode;
import com.sparkst3r.anotherworld.api.tool.IToolModeManager;




public class ToolModeManager implements IToolModeManager {
	public static List<IToolMode> modes = new ArrayList<IToolMode>();

	@Override
	public boolean addMode(IToolMode mode) {
		modes.add(mode);
		return true;
	}
	
	public static List<IToolMode> getModes() {
		return modes;
	}
	
	
}
