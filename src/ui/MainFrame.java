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
	private JTextArea textArea;

	public MainFrame() {
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
	}

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
	}
}
