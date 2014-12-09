package plugins;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class TestFilteDetector {
	FileDetector fileDetector;
	@Before
	public void init() {
		fileDetector = new FileDetector();
	}
	@Test
	public void testAdded() {
		fileDetector.fileAdded(new File("Toto"));
	}
	@Test
	public void testRemoved() {
		fileDetector.fileRemoved(new File("Toto"));
	}

}
