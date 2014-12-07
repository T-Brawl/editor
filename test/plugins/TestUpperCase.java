package plugins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestUpperCase {
	private MockChaine mockChaine;
	@Before
	public void initChaine() {
		mockChaine = new MockChaine("toto");
	}
	

	@Test
	public void testTransform() {
		String s = new String("TOTO");
		assertFalse(mockChaine.getChaine().equals(s));
		assertEquals(mockChaine.transform(mockChaine.getChaine()),s);
	}

	@Test
	public void testGetLabel() {
	}

	@Test
	public void testHelpMessage() {
	}

}
