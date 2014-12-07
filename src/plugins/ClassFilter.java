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
		nameFile = file.split("\\.", file.length());
		name = nameFile[0];
		try {
			/* on recupere la class depuis le nameFile (le nom sans le .class) */
			constructor = Class.forName("plugins." + name).getConstructor();
			/* si le constructeur ne prend pas de parametre */
			return constructor.getParameterTypes().length == 0;
		} catch (ClassNotFoundException e) {
			return false;
		} catch (SecurityException e) {
			return false;
		} catch (NoSuchMethodException e) {
			return false;
		}
	}

	/*public boolean accept(File name) {
		return name.getName().endsWith(this.extension);
	}*/

}
