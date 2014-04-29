package com.sparkst3r.anotherworld.mechanical.tool;

import com.sparkst3r.anotherworld.api.tool.IToolMode;

public class ToolModeDismantle implements IToolMode {

	@Override
	public String identifier() {
		return "tool.tinker.mode.dismantle";
	}

	@Override
	public String texture() {
		return "anotherWorld:modeTinkerDismantle";
	}

	@Override
	public String icon() {
		return "anotherWorld:modeTinkerDismantleIcon";
	}

	@Override
	public String[] infoLine() {
		return new String[] {"Right click a machine or mechanical", "device to safely dismantle them"};
	}

	@Override
	public int nameColour() {
		return 0x00FF00;
	}
}
