package ui;

import java.util.List;
import java.util.Observable;

import plugins.PluginFinder;


public class PluginModel extends Observable {
	PluginFinder finder;
	List<String> tools;
	
	public PluginModel() {
		//finder = new PluginFinder(directory, filter)
	}
}
