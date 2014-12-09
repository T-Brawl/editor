package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import plugins.PluginFilter;

public class MainFrame extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	private GridBagLayout gbl;
	private MenuPlugins menuPlugins;
	private JTextArea textArea;
	private PluginModel model;
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
		this.setPreferredSize(new Dimension(800,600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		model.addObserver(this);
	}

	public static void main(String[] args) {
		PluginFilter filter = new PluginFilter();
		PluginModel model = new PluginModel("/home/l3/moevi/COO/editor/bin/plugins",filter);
		MainFrame mf = new MainFrame(model);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		textArea.setText(model.getText());
		
	}
}
