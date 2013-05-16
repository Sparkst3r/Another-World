package mods.anotherworld.mechanical.tool;

import mods.anotherworld.api.tool.IToolMode;

public class ToolModeDismantle implements IToolMode {

	@Override
	public String identifier() {
		return "mode.tinker.dismantle";
	}

	@Override
	public String texture() {
		return "modeTinkerDismantle";
	}

	@Override
	public String icon() {
		return "modeTinkerDismantleIcon";
	}

	@Override
	public String name() {
		return "Dismantle";
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
