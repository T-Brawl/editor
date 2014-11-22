package plugins;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.List;

import javax.swing.filechooser.FileNameExtensionFilter;

public class PluginFinder {
	List<File> files;
	FilenameFilter filter;
	public PluginFinder(String path) {
	/*	File file = new File(path);
		filter = new FilenameFilter();
		if(file.isDirectory()) {
			files.add(file.listFiles(filter));
		}*/
	}
}
