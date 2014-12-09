package plugins;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class TestPluginFilter {
	PluginFilter pf;

	@Before
	public void init() {
		pf = new PluginFilter();
	}
	@Test
	public void testAccept() {
		assertFalse(pf.accept(new File(""), "toto.class"));
		assertFalse(pf.accept(new File("Toto.class"), "toto.class"));
	}

}
