package com.sparkst3r.anotherworld.mechanical.tool;

import com.sparkst3r.anotherworld.api.tool.IToolMode;

public class ToolModeSetting implements IToolMode {

	@Override
	public String identifier() {
		return "tool.tinker.mode.setting";
	}

	@Override
	public String texture() {
		return "anotherWorld:modeTinkerSetting";
	}

	@Override
	public String icon() {
		return "anotherWorld:modeTinkerSettingIcon";
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
