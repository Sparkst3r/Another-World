package com.sparkst3r.anotherworld.mechanical.tool;

import com.sparkst3r.anotherworld.api.tool.IToolMode;

public class ToolModeRotate implements IToolMode {

	@Override
	public String identifier() {
		return "tool.tinker.mode.rotate";
	}

	@Override
	public String texture() {
		return "anotherWorld:modeTinkerRotate";
	}

	@Override
	public String icon() {
		return "anotherWorld:modeTinkerRotateIcon";
	}

	@Override
	public String[] infoLine() {
		return new String[] {"Right click a rotatable block to turn it", null, null, null};
	}

	@Override
	public int nameColour() {
		return 0x0000FF;
	}
}
