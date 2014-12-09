package plugins;

import java.io.File;
import java.io.IOException;

public class MockPluginFinder extends PluginFinder {
	public int nbTimesFilesUpdated;

	public MockPluginFinder() {
		super();
		this.nbTimesFilesUpdated = 0;
	}

	public void updateFiles() throws ClassNotFoundException, IOException {
		super.fileAdded(new File(""));
		nbTimesFilesUpdated++;
	}
	
	public void removedFiles() {
		super.fileRemoved(new File(""));
		nbTimesFilesUpdated--;
	}

}