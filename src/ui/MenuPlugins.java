package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPlugins extends JMenuBar implements Observer {
	private static final long serialVersionUID = 253926500820076375L;
	private JMenu file, tools, help;
	private JMenuItem add,remove;
	protected List<JMenuItem> listTools;
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
		listTools = new ArrayList<JMenuItem>();
		tools.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Jean Pierre JAJA");
				
			}
		});
		for(JMenuItem jmi : listTools) {
			jmi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Jean Pierre");
					
				}
			});
		}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("COUCOU");
	}

}
