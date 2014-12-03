package plugins;

import java.io.File;

public class Main {


	
	public static void main(String[] args) { 
		PluginFilter pointClass = new PluginFilter();
		FileDetector mrString = new FileDetector();
		PluginFinder checkStuff = new PluginFinder(new File("/home/l3/debue/workspace/Editor/bin/plugins"),pointClass);
		
		checkStuff.addFileListener(mrString);

		while(true);
	}

}
