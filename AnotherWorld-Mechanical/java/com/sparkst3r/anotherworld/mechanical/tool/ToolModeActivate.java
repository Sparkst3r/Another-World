package com.sparkst3r.anotherworld.mechanical.tool;

import com.sparkst3r.anotherworld.api.tool.IToolMode;

public class ToolModeActivate implements IToolMode {

	@Override
	public String identifier() {
		return "tool.tinker.mode.activate";
	}

	@Override
	public String texture() {
		return "anotherWorld:modeTinkerActivate";
	}

	@Override
	public String icon() {
		return "anotherWorld:modeTinkerActivateIcon";
	}

	@Override
	public String[] infoLine() {
		return new String[]{"Right click certain blocks to activate", "their features"};
	}

	@Override
	public int nameColour() {
		return 0xFF0000;
	}
	
}
