package plugins;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Timer;

public class Main {


	
	public static void main(String[] args) { 
		PluginFilter pointClass = new PluginFilter();
		FileDetector mrString = new FileDetector();
		PluginFinder checkStuff = new PluginFinder(new File(""),pointClass);
		
		File lol = new File("Mais oui c'est clair");
		File xd = new File("Zug Zug");
		
		checkStuff.addFileListener(mrString);

		while(true);
	}

}
