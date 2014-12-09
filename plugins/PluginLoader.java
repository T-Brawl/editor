package plugins;

import java.io.File;
import java.io.FilenameFilter;

public class PluginLoader implements FilenameFilter{
	private String extension;
	
	public PluginLoader() {
		super();
		this.extension = ".class";
	}
	@Override
	public boolean accept(File directory, String pathname) {
		
		if(!pathname.endsWith(this.extension)) {
			return false;
		} else {
			try {
				Class.forName(pathname);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
