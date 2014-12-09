package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plugins.Plugin;
import plugins.PluginInstancer;

public class MenuToolListener implements ActionListener {
	private PluginInstancer pi;
	private PluginModel pm;

	public MenuToolListener(PluginModel pm) {
		this.pm = pm;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Plugin plugin;
		try {
			pi = new PluginInstancer(arg0.getActionCommand());
			System.out.println(arg0.getActionCommand());
			plugin = pi.getmyInstance();
			pm.transform(plugin);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
