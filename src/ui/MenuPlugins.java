package ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPlugins extends JMenuBar {
	private static final long serialVersionUID = 253926500820076375L;
	private JMenu file, tools, help;
	private JMenuItem add,remove;

	public MenuPlugins() {
		this.file = new JMenu("File");
		this.tools = new JMenu("Tools");
		
		this.help = new JMenu("Help");
		this.add(file);
		add = new JMenuItem("Add..");
		file.add(add);
		remove = new JMenuItem("Remove..");
		file.add(remove);
		this.add(tools);
		this.add(help);
	}

}
