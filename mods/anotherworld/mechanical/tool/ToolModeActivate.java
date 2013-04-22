package mods.anotherworld.mechanical.tool;

import mods.anotherworld.api.tool.IToolMode;

public class ToolModeActivate implements IToolMode {

	@Override
	public String identifier() {
		return "mode.tinker.activate";
	}

	@Override
	public String texture() {
		return "modeTinkerActivate";
	}

	@Override
	public String icon() {
		return "modeTinkerActivateIcon";
	}

	@Override
	public String name() {
		return "Activate";
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
