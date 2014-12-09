package plugins;

import java.io.File;
/**
 * 
 * @author debue,moevi
 *
 *Interface which represent a FileListener
 */
public interface FileListener {
	/**
	 * Handle the method when a file is added
	 * @param file
	 */
	public void fileAdded(File file);
	/**
	 * Handle the method when a file is removed
	 * @param file
	 */
	public void fileRemoved(File file);

}
