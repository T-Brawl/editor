package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import plugins.Plugin;
import plugins.PluginFilter;
import plugins.PluginFinder;

public class PluginModel extends Observable {
	protected PluginFinder finder;
	protected PluginFilter filter;
	protected List<Plugin> tools;
	protected String text;

	public PluginModel(String directory, PluginFilter filter) {
		finder = new PluginFinder(directory, filter);
		tools = new ArrayList<Plugin>();
		tools.addAll(finder.pluginList);
	}

	public PluginFilter getFilter() {
		return this.filter;
	}

	public void transform(Plugin p) {
		this.text = p.transform(this.text);
		tools.addAll(finder.getInstances());
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

	public List<Plugin> getTools() {
		return this.tools;
	}

}
