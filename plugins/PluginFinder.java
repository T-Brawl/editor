package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.Timer;

public class PluginFinder /*extends Observable implements ActionListener*/ {

	private File directory;

	private PluginFilter filter;

	private Timer timer;

	private ArrayList<FileListener> fileListeners;

	public PluginFinder(File directory, PluginFilter filter) {
		this.directory = directory;
		this.filter = filter;
		this.fileListeners = new ArrayList<FileListener>();
		this.timer = new Timer(1000, null);
	}

	public synchronized void addFileListener(FileListener l) {
		if (fileListeners.contains(l)) {
			return;
		}
		fileListeners.add(l);
	}

	public synchronized void removeFileListener(FileListener l) {
		fileListeners.remove(l);
	}

	
	private void fireFileAdded(File file) {
		ArrayList<FileListener> list = (ArrayList<FileListener>) fileListeners.clone();
		for(FileListener fl : list) {
			FileEvent event = new FileEvent(file);
			fl.fileAdded(file);
		}
	}
	
	private void fireFileRemoved(File file) {
		ArrayList<FileListener> list = (ArrayList<FileListener>) fileListeners.clone();
		for(FileListener fl : list) {
			FileEvent event = new FileEvent(file);
			fl.fileRemoved(file);
		}
	}

	public void fileAdded(File file) { fireFileAdded(file); }
	
	public void fileRemoved(File file) { fireFileRemoved(file); }

}
