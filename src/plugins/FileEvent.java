package plugins;

import java.io.File;
import java.util.EventObject;

public class FileEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected File file;

	public FileEvent(File source) {
		super(source);
		this.file = source;
	}

}
