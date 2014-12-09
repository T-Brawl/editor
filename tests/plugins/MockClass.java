package plugins;

import plugins.Plugin;

public class MockClass implements Plugin {

	@Override
	public String transform(String s) {
		return s;
	}

	@Override
	public String getLabel() {
		return "label";
	}

	@Override
	public String helpMessage() {
		return "help! i need somebody, help!";
	}

}
