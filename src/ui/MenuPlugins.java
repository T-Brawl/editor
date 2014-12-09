package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import plugins.FileListener;
import plugins.Plugin;

public class MenuPlugins extends JMenuBar implements FileListener {
	private static final long serialVersionUID = 253926500820076375L;
	private JMenu file, tools, help;
	private JMenuItem add,remove;
	protected List<Plugin> listTools;
	
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
		this.listTools = new ArrayList<Plugin>();
	}

	@Override
	public void fileAdded(File file) {
		String[] nameFile = new String[2];
		String name;
		Constructor<?> constructor;
		String interfaces;
		nameFile = file.toString().split("\\.", 2);
		name = nameFile[0];
		Class<?> c;
		try {
			c = Class.forName(Plugin.PACKAGE_NAME + "." + name);
			Plugin plugin = (Plugin) c.newInstance();
			JMenuItem pgTools = new JMenuItem (plugin.getLabel());
			JMenuItem pgHelp = new JMenuItem (plugin.getLabel());
			pgTools.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {}
				
				@Override
				public void mousePressed(MouseEvent e) {System.out.println("lol");}
				
				@Override
				public void mouseExited(MouseEvent e) {}
				
				@Override
				public void mouseEntered(MouseEvent e) {}
				
				@Override
				public void mouseClicked(MouseEvent e) {}
			});
			pgHelp.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {}
				
				@Override
				public void mousePressed(MouseEvent e) {System.out.println("lol"); new JOptionPane("lol");}
				
				@Override
				public void mouseExited(MouseEvent e) {}
				
				@Override
				public void mouseEntered(MouseEvent e) {}
				
				@Override
				public void mouseClicked(MouseEvent e) {}
			});
			this.tools.add(pgTools);			
			this.help.add(pgHelp);
			this.listTools.add(plugin);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void fileRemoved(File file) {
		// TODO Auto-generated method stub
		
	}

}
