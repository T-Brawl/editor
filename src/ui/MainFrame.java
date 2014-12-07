package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private GridBagLayout gbl;
	private MenuPlugins menuPlugins;

	public MainFrame() {
		gbl = new GridBagLayout();
		this.getContentPane().setLayout(gbl);
		this.setLocationRelativeTo(null);
		menuPlugins = new MenuPlugins();
		this.setJMenuBar(menuPlugins);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		Container c = mf.getContentPane();
		mf.setSize(new Dimension(800, 600));
		c.add(new JTextArea());
	}
}
