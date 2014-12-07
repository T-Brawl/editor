package plugins;

import java.io.File;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException { 
		ClassFilter pointClass = new ClassFilter();
		FileDetector mrString = new FileDetector();
		PluginFinder checkStuff = new PluginFinder(new File("C:\\Users\\Alexandre\\COO\\editor\\bin\\plugins"),pointClass);
		
		checkStuff.addFileListener(mrString);
		String s = "ToUpperCase.class";
		/*String[] newClass = new String[2];
		newClass = s.split(".");
		Class<?> plugins = Class.forName("plugins.ToUpperCase");*/
		/*try {
			plugins.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		/*System.out.println(plugins.getInterfaces()[0].getClass());*/
		while(true);
	}

}
