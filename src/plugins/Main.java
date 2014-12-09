package plugins;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException {
		PluginFilter pointClass = new PluginFilter();
		FileDetector mrString = new FileDetector();
		/* /home/l3/debue/workspace/Editor/bin/plugins */
		/* C:\\Users\\Alexandre\\COO\\editor\\bin\\plugins */
		PluginFinder plgFinder = new PluginFinder("/home/l3/moevi/COO/editor/bin/plugins", pointClass);
		plgFinder.addFileListener(mrString);

		while (true);
	}

}
