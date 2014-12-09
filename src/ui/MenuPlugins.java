package ui;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import plugins.FileListener;
import plugins.Plugin;
import plugins.PluginInstancer;

public class MenuPlugins extends JMenuBar implements FileListener {
	private static final long serialVersionUID = 253926500820076375L;
	private JMenu file, tools, help;
	private JMenuItem add, remove, item;
	private PluginInstancer instancer;
	private List<JMenuItem> pgTools, pgHelp;
	protected Map<String, Plugin> listTools;
	protected Plugin plugin;
	private PluginModel model;
	public MenuPlugins(PluginModel model) {
		this.file = new JMenu("File");
		this.tools = new JMenu("Tools");
		this.help = new JMenu("Help");
		pgTools = new ArrayList<JMenuItem>();
		pgHelp = new ArrayList<JMenuItem>();
		this.add(file);
		this.model = model;
		add = new JMenuItem("Add..");
		remove = new JMenuItem("Remove..");
		file.add(add);
		file.add(remove);
		this.add(tools);
		this.add(help);
		this.listTools = new HashMap<String, Plugin>();
	}

	@Override
	public void fileAdded(File file) {
		String[] nameFile = new String[2];
		JMenuItem menuItemTools,menuItemHelp;
		String name;
		String pluginName;
		Constructor<?> constructor;
		String interfaces;
		nameFile = file.toString().split("\\.", 2);
		name = nameFile[0];
		try {
			instancer = new PluginInstancer(name);
			plugin = instancer.getmyInstance();
			pluginName = this.getRealPluginName(plugin);
			System.out.println(pluginName);
			menuItemTools = new JMenuItem(pluginName);
			menuItemHelp = new JMenuItem(pluginName);
			pgHelp.add(menuItemHelp);
			pgTools.add(menuItemTools);
			for (int i = 0; i < pgTools.size(); i++) {
				item = pgTools.get(i);
				tools.add(item);
				
			}
			item.addActionListener(new MenuToolListener(model));
			for(int i = 0 ; i < pgHelp.size(); i++) {
				help.add(pgHelp.get(i));
			}
			
			this.listTools.put(pluginName, plugin);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void fileRemoved(File file) {
		// TODO Auto-generated method stub

	}

	public String getRealPluginName(Plugin plugin) {
		String pluginName;
		pluginName = plugin.getClass().getName();
		pluginName = pluginName.split("\\.")[1];
		return pluginName;
	}

}
