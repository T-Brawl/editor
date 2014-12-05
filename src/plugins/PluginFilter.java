package plugins;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

public class PluginFilter implements FilenameFilter {

	private String extension;
	private ClassLoader generatedClass;

	public PluginFilter() {
		super();
		this.extension = ".class";
	}

	@Override
	public boolean accept(File directory, String file) {
		String[] nameFile = new String[file.length()];
		String name;
		Constructor constructor;
		System.out.println(file);
		nameFile = file.split("\\.", file.length());
		name = nameFile[0];
		System.out.println(nameFile[0]);
		try {
			/* on recupere la class depuis le nameFile (le nom sans le .class) */
			generatedClass = Class.forName("plugins." + name).getClassLoader();
			System.out.println(generatedClass.getClass().getName());
			/* on recupere le constructeur */
			constructor = generatedClass.getClass().getConstructor();
			/* si le constructeur ne prend pas de parametre */
			if (constructor.getParameterTypes().length == 0) {
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return file.endsWith(this.extension);

	}

	public boolean accept(File name) {
		return name.getName().endsWith(this.extension);
	}

}
