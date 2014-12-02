package plugins;

import java.io.File;

public interface FileListener {
	
	public void fileAdded(File file);
	
	public void fileRemoved(File file);

}
