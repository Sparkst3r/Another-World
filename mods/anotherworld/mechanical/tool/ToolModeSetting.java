package mods.anotherworld.mechanical.tool;

import mods.anotherworld.api.tool.IToolMode;

public class ToolModeSetting implements IToolMode {

	@Override
	public String identifier() {
		return "mode.tinker.setting";
	}

	@Override
	public String texture() {
		return "modeTinkerSetting";
	}

	@Override
	public String icon() {
		return "modeTinkerSettingIcon";
	}

	@Override
	public String name() {
		return "Setting";
	}
	@Override
	public String[] infoLine() {
		return new String[]{"Right click a machine or mechanical device", "device to alter it's setting"};
	}

	@Override
	public int nameColour() {
		return 0xFF0000;
	}
	
}
