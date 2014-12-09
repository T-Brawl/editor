package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import plugins.Plugin;
import plugins.PluginFilter;
import plugins.PluginFinder;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	protected GridBagLayout gbl;
	protected MenuPlugins menuPlugins;
	protected JTextArea textArea;
	protected PluginFinder plg;

	public MainFrame(PluginFinder pm) {
		this.plg = pm;
		gbl = new GridBagLayout();
		Container c = this.getContentPane();
		this.getContentPane().setLayout(gbl);
		this.setLocationRelativeTo(null);
		menuPlugins = new MenuPlugins();
		this.plg.addFileListener(this.menuPlugins);
		this.setJMenuBar(menuPlugins);
		textArea = new JTextArea("Maisouicestclair");
		this.add(textArea);
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}


	public static void main(String[] args) {
		PluginFilter filter = new PluginFilter();
		PluginFinder model = new PluginFinder(
				"C:\\Users\\Alexandre\\COO\\editor\\bin\\plugins", filter);
		MainFrame mf = new MainFrame(model);
	}

}
