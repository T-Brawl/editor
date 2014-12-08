package plugins;

import java.io.File;
import java.io.FilenameFilter;

public class ClassFilter implements FilenameFilter {

	private String extension;

	public ClassFilter() {
		super();
		this.extension = ".class";
	}

	@Override
	public boolean accept(File directory, String file) {
		return file.endsWith(extension);
	}


}
