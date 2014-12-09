package plugins;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TestPluginFinder {
	PluginFinder pf;
	PluginFilter pfilter;
	MockPluginFinder mpf;

	@Before
	public void init() {
		pfilter = new PluginFilter();
		pf = new PluginFinder(new File(""), pfilter);
		mpf = new MockPluginFinder();
	}

	@Test
	public void testFilter() {
		assertTrue(pf.pluginList.isEmpty());
	}

	@Test
	public void testUpdated() {
		assertTrue(mpf.nbTimesFilesUpdated == 0);
	}

	@Test
	public void testmoreUpdated() throws ClassNotFoundException, IOException {
		mpf.updateFiles();
		assertTrue(mpf.nbTimesFilesUpdated == 1);
	}
	@Test
	public void testlessUpdated() {
		mpf.removedFiles();
		assertTrue(mpf.nbTimesFilesUpdated == -1);
	}

}
