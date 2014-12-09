package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import plugins.PluginInstancer;
import plugins.Plugin;

public class MenuHelpListener implements ActionListener {
	private PluginInstancer pi;
	private PluginModel pm;

	public MenuHelpListener(PluginModel pm) {
		this.pm = pm;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Plugin plugin;
		try {
			pi = new PluginInstancer(arg0.getActionCommand());
			plugin = pi.getmyInstance();
			pm.transform(plugin);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
