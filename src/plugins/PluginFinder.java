package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.Timer;

public class PluginFinder implements ActionListener {

	private File directory;

	private PluginFilter filter;

	private Timer timer;

	private ArrayList<FileListener> fileListeners;
	
	private String[] oldFiles;

	public PluginFinder(File directory, PluginFilter filter) {
		this.directory = directory;
		this.filter = filter;
		this.fileListeners = new ArrayList<FileListener>();
		this.oldFiles = null;
		this.timer = new Timer(500, this);
		this.timer.start();
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
	
	public void actionPerformed(ActionEvent e) {
		String[] newFiles = this.directory.list(this.filter);
		if(oldFiles != null && !oldFiles.equals(newFiles)) for(String file : newFiles) {this.fileAdded(new File(file));}	
		oldFiles = newFiles;
	}

}
