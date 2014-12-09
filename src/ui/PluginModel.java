package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import plugins.Plugin;
import plugins.PluginFilter;
import plugins.PluginFinder;

public class PluginModel extends Observable {
	private PluginFinder finder;
	private PluginFilter filter;
	private List<Plugin> tools;
	private String text;

	public PluginModel(String directory, PluginFilter filter) {
		finder = new PluginFinder(directory, filter);
		tools = new ArrayList<Plugin>();
		if (finder.getInstances() != null) {
			tools.addAll(finder.getInstances());
		}
	}

	public PluginFilter getFilter() {
		return this.filter;
	}

	public void tranform(Plugin p) {
		this.text = p.transform(this.text);
		this.setChanged();
		this.notifyObservers();
	}

	public void setText(String s) {
		this.text = s;
		this.setChanged();
		this.notifyObservers();
	}

	public String getText() {
		return this.text;
	}

}
