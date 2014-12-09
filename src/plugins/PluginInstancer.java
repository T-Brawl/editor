package plugins;

public class PluginInstancer {
private Class<Plugin> cl;
private Plugin plugin;
	@SuppressWarnings("unchecked")
	public PluginInstancer(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		cl= ((Class<Plugin>) Class.forName(Plugin.PACKAGE_NAME + "." + name));
		plugin = (Plugin) cl.newInstance();
	}
	
	public Plugin getmyInstance() {
		return plugin;
	}
}
