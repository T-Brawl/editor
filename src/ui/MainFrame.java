package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import plugins.PluginFilter;
import plugins.PluginFinder;

public class MainFrame extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	protected GridBagLayout gbl;
	protected MenuPlugins menuPlugins;
	protected JTextArea textArea;
	protected PluginFinder plg;
	private final PluginModel pluginModel;

	public MainFrame(PluginFinder pm,final PluginModel pluginModel) {
		this.plg = pm;
		this.pluginModel = pluginModel;
		gbl = new GridBagLayout();
		Container c = this.getContentPane();
		this.getContentPane().setLayout(gbl);
		this.setLocationRelativeTo(null);
		menuPlugins = new MenuPlugins(pluginModel);
		this.plg.addFileListener(this.menuPlugins);
		this.setJMenuBar(menuPlugins);
		pluginModel.addObserver(this);
		textArea = new JTextArea("Maisouicestclair");
		pluginModel.setText(this.textArea.getText());
		textArea.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				pluginModel.setText(textArea.getText());	
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.add(textArea);
		this.setPreferredSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}


	public static void main(String[] args) {
		PluginFilter filter = new PluginFilter();
		/* /home/l3/debue/workspace/Editor/bin/plugins */
		/*/home/rems/workspace/Editor/bin/plugins*/
		/* C:\\Users\\Alexandre\\COO\\editor\\bin\\plugins */
		String title = "/home/rems/workspace/Editor/bin/plugins";
		PluginFinder finder = new PluginFinder(title, filter);
		PluginModel model = new PluginModel(title, filter);
		MainFrame mf = new MainFrame(finder,model);

	}


	@Override
	public void update(Observable arg0, Object arg1) {
		this.textArea.setText(pluginModel.getText());
		
	}

}
