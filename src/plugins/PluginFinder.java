package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.swing.Timer;

public class PluginFinder implements ActionListener {

	private File directory;

	private PluginFilter filter;

	private Timer timer;

	private List<FileListener> fileListeners;

	private List<String> oldFiles;
	
	private Collection<Class> pluginList;

	public PluginFinder(File directory, PluginFilter filter) {
		this.directory = directory;
		this.filter = filter;
		this.fileListeners = new ArrayList<FileListener>();
		this.oldFiles = new ArrayList<String>();
		this.timer = new Timer(2000, this);
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
		List<FileListener> list =  fileListeners;
		for (FileListener fl : list) {
			fl.fileAdded(file);
		}
	}

	private void fireFileRemoved(File file) {
		List<FileListener> list = fileListeners;
		for (FileListener fl : list) {
			fl.fileRemoved(file);
		}
	}

	public void fileAdded(File file) {
		fireFileAdded(file);
	}

	public void fileRemoved(File file) {
		fireFileRemoved(file);
	}

	public void checkFileAdded(List<String> fileList) throws ClassNotFoundException {
		Class<?> plugins;
		String[] newClass = new String[2];
		for (String s : fileList) {
			if (!oldFiles.contains(s)) {
				/*newClass = s.split(".");
				plugins = Class.forName(newClass[0]);
				if(plugins.getInterfaces().getClass().getCanonicalName().equals("Plugin")) {
					
				}*/
				this.fileAdded(new File(s));
			}
		}

	}

	public void checkFileRemoved(List<String> fileList) {
		for (String s : oldFiles) {
			/*
			 * si la nouvelle liste de fichier ne contient pas des fichiers qui
			 * étaient dans l'ancienne liste (supprimés donc)
			 */
			if (!fileList.contains(s)) {
				this.fileRemoved(new File(s));
			}
		}

	}

	public void actionPerformed(ActionEvent e) {
		String[] newFiles = this.directory.list(this.filter);
		List<String> filesAsList = Arrays.asList(newFiles);
		try {
			checkFileAdded(filesAsList);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		checkFileRemoved(filesAsList);
		oldFiles = filesAsList;
	}

}
