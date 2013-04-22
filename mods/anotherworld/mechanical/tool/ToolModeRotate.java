package mods.anotherworld.mechanical.tool;

import mods.anotherworld.api.tool.IToolMode;

public class ToolModeRotate implements IToolMode {

	@Override
	public String identifier() {
		return "mode.tinker.rotate";
	}

	@Override
	public String texture() {
		return "modeTinkerRotate";
	}

	@Override
	public String icon() {
		return "modeTinkerRotateIcon";
	}

	@Override
	public String name() {
		return "Rotate";
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
