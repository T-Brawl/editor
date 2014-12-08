package plugins;

import java.io.File;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException { 
		PluginFilter pointClass = new PluginFilter();
		FileDetector mrString = new FileDetector();
		/*/home/l3/debue/workspace/Editor/bin/plugins*/

		PluginFinder plgFinder = new PluginFinder(new File("/home/l3/debue/workspace/Editor/bin/plugins"),pointClass);
		
		plgFinder.addFileListener(mrString);

		while(true);
	}

}
