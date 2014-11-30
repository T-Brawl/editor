package plugins;

import java.util.EventListener;

public class PluginAddedLogger implements EventListener {

	public PluginAddedLogger() {}
	
	public void fireFileAdded(FileEvent e) {
		System.out.println(e.getSource().toString()+" added");
	}
	
	/*public void fireFileRemoved(FileAddedEvent e) {
		System.out.println(e.getSource().toString()+" removed");
	}*/
	
}
