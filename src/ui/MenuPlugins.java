package ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuPlugins extends JMenuBar {
	private static final long serialVersionUID = 253926500820076375L;
	private JMenu file, tools, help;

	public MenuPlugins() {
		this.file = new JMenu("File");
		this.tools = new JMenu("Tools");
		this.help = new JMenu("Help");
		this.add(file);
		this.add(tools);
		this.add(help);
	}

}
