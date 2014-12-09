package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import plugins.Plugin;
import plugins.PluginFilter;

public class MainFrame extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	protected GridBagLayout gbl;
	protected MenuPlugins menuPlugins;
	protected JTextArea textArea;
	protected PluginModel model;

	public MainFrame(PluginModel pm) {
		this.model = pm;
		gbl = new GridBagLayout();
		Container c = this.getContentPane();
		this.getContentPane().setLayout(gbl);
		this.setLocationRelativeTo(null);
		menuPlugins = new MenuPlugins();
		this.setJMenuBar(menuPlugins);
		textArea = new JTextArea();
		this.add(textArea);
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		model.addObserver(this);
		System.out.println(model.tools.size());
		for (Plugin p : model.tools) {
			System.out.println("Toto");
			menuPlugins.listTools.add(new JMenuItem(p.getLabel()));
		}
		this.setVisible(true);
		this.pack();
		repaint();
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("BEERRNNARRDDD");
		textArea.setText(model.getText());
		for (Plugin p : model.getTools()) {
			menuPlugins.listTools.add(new JMenuItem(arg0.getClass().getName()));
		}

	}

	public void addMenuItem(String s) {
		JMenuItem item = new JMenuItem(s);
		if (!menuPlugins.listTools.contains(item)) {
			menuPlugins.listTools.add(item);
			item.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("Cassoulet");

				}
			});
		}
	}
	public static void main(String[] args) {
		PluginFilter filter = new PluginFilter();
		PluginModel model = new PluginModel(
				"/home/l3/debue/workspace/Editor/bin/plugins", filter);
		MainFrame mf = new MainFrame(model);
	}
}
