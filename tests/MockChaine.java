package tests;

import plugin.Plugin;
import plugins.CesarCode;
import plugins.ToUpperCase;

public class MockChaine {
	private String chaine;
	
	private Plugin plugin;
	
	public MockChaine(String s, Plugin plugin) {
		this.chaine = s;
		this.plugin = plugin;
	}
	
	public String getChaine() {
		return this.chaine;
	}

	public String transform(String s) {
		return plugin.transform(chaine);
	}

	public String getLabel() {
		return plugin.getLabel();
	}

	public String helpMessage() {
		return plugin.helpMessage();
	}
}
