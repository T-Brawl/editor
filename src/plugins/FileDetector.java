package plugins;

import java.io.File;

public class FileDetector implements FileListener {

	/**
	 * Print a message when a new file appeared
	 * @param file 
	 */
	public void fileAdded(File file) {
		System.out.println("New file added : "+file.toString());
		
	}

	/**
	 * Print a message when a file is removed
	 * @param file 
	 */
	public void fileRemoved(File file) {
		System.out.println("New file removed : "+file.toString());
	}

}
