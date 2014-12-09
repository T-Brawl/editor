package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import plugins.FileListener;

public class MenuPlugins extends JMenuBar implements FileListener {
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

	@Override
	public void fileAdded(File file) {
		if (this.tools.add(new JMenuItem(file.toString())) != null) System.out.println(file.toString());
	}
	
	@Override
	public void fileRemoved(File file) {
		// TODO Auto-generated method stub
		
	}

}
