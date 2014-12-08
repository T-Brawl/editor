package plugins;

import java.io.File;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException {
		PluginFilter pointClass = new PluginFilter();
		FileDetector mrString = new FileDetector();
		/* /home/l3/debue/workspace/Editor/bin/plugins */
<<<<<<< HEAD
		/* C:\\Users\\Alexandre\\COO\\editor\\bin\\plugins */
		PluginFinder plgFinder = new PluginFinder(
				"C:\\Users\\Alexandre\\COO\\editor\\bin\\plugins", pointClass);
=======
		PluginFinder plgFinder = new PluginFinder(new File(
				"C:\\Users\\Alexandre\\COO\\editor\\bin\\plugins"), pointClass);
>>>>>>> origin/master
		plgFinder.addFileListener(mrString);

		while (true);
	}

}
