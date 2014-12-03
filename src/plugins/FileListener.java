package plugins;

import java.awt.event.ActionListener;
import java.io.File;

public interface FileListener {
	
	public void fileAdded(File file);
	
	public void fileRemoved(File file);

}
