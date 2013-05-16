package mods.anotherworld.mechanical.tool;

import mods.anotherworld.api.tool.IToolMode;

public class ToolModeHelp implements IToolMode {

	@Override
	public String identifier() {
		return "mode.tinker.help";
	}

	@Override
	public String texture() {
		return "modeTinkerHelp";
	}

	@Override
	public String icon() {
		return "modeTinkerHelpIcon";
	}

	@Override
	public String name() {
		return "Help";
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
