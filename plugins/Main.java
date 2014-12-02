package plugins;

import java.io.File;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		PluginFilter pointClass = new PluginFilter();
		FileDetector mrString = new FileDetector();
		PluginFinder checkStuff = new PluginFinder(new File(""),pointClass);
		
		File lol = new File("Mais oui c'est clair");
		File xd = new File("Zug Zug");
		
		checkStuff.addFileListener(mrString);
		checkStuff.fileAdded(lol);
		

	}

}
