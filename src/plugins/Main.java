package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Timer;

public class Main {


	
	public static void main(String[] args) { 
		PluginFilter pointClass = new PluginFilter();
		FileDetector mrString = new FileDetector();
		PluginFinder checkStuff = new PluginFinder(new File("/home/l3/moevi/COO/editor/bin/plugins"),pointClass);
		
		checkStuff.addFileListener(mrString);

		while(true);
	}

}
