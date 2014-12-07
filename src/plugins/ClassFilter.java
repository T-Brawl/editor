package plugins;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

public class ClassFilter implements FilenameFilter {

	private String extension;

	public ClassFilter() {
		super();
		this.extension = ".class";
	}

	@Override
	public boolean accept(File directory, String file) {
		String[] nameFile = new String[file.length()];
		String name;
		Constructor constructor;
<<<<<<< HEAD
		String interfaces;
		nameFile = file.split("\\.", file.length());
		name = nameFile[0];
		try {
			constructor = Class.forName("plugins." + name).getConstructor();
			interfaces = Class.forName("plugins." + name).getInterfaces()[0].getName();
			return constructor.getParameterTypes().length == 0 && interfaces.equals("plugin.Plugin");
=======
		nameFile = file.split("\\.", file.length());
		name = nameFile[0];
		try {
			/* on recupere la class depuis le nameFile (le nom sans le .class) */
			constructor = Class.forName("plugins." + name).getConstructor();
			/* si le constructeur ne prend pas de parametre */
			return constructor.getParameterTypes().length == 0;
>>>>>>> origin/master
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SecurityException e) {
			return false;
		} catch (NoSuchMethodException e) {
			return false;
<<<<<<< HEAD
		} catch (ArrayIndexOutOfBoundsException e) {
		return false;
=======
>>>>>>> origin/master
		}
	}

	/*public boolean accept(File name) {
		return name.getName().endsWith(this.extension);
	}*/

}
