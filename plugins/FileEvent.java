package plugins;

import java.io.File;
import java.util.EventObject;

public class FileEvent extends EventObject {

	protected File file;

	public FileEvent(File source) {
		super(source);
		this.file = source;
	}

}
