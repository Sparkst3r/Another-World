package com.sparkst3r.anotherworld.mechanical.tool;

import com.sparkst3r.anotherworld.api.tool.IToolMode;

public class ToolModeHelp implements IToolMode {

	@Override
	public String identifier() {
		return "tool.tinker.mode.help";
	}

	@Override
	public String texture() {
		return "anotherWorld:modeTinkerHelp";
	}

	@Override
	public String icon() {
		return "anotherWorld:modeTinkerHelpIcon";
	}

	@Override
	public String[] infoLine() {
		return new String[]{"Right click any block to get information", "about that block"};
	}

	@Override
	public int nameColour() {
		return 0xFF0000;
	}
	
}
