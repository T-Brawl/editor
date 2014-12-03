package plugins;

import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter {

	private String extension;
	
	public PluginFilter() {
		super();
		this.extension = ".class";
	}
	
	@Override
	public boolean accept(File directory, String file) {
		return file.endsWith(this.extension);
	}
	
	public boolean accept(File name) {
		return name.getName().endsWith(this.extension);
	}

}
