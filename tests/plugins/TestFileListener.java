package plugins;

import java.io.File;

import org.junit.Test;


public interface TestFileListener {
	/**
	 * Handle the method when a file is added
	 * @param file
	 */
	@Test
	public void fileAddedTest(File file);
	/**
	 * Handle the method when a file is removed
	 * @param file
	 */
	@Test
	public void fileRemovedTest(File file);

}
