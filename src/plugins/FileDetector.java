package plugins;

import java.io.File;

public class FileDetector implements FileListener {

	@Override
	public void fileAdded(File file) {
		System.out.println("new File added! "+file.toString());
		
	}

	@Override
	public void fileRemoved(File file) {
		System.out.println("RIP in pepperonis, mate");
	}

}
