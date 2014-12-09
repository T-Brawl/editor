package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import plugins.ToUpperCase;

public class TestUpperCase {
	private MockChaine mockChaine;
	@Before
	public void initChaine() {
		mockChaine = new MockChaine("toto",new ToUpperCase());
	}
	

	@Test
	public void testTransform() {
		String s = new String("TOTO");
		assertFalse(mockChaine.getChaine().equals(s));
		assertEquals(mockChaine.transform(mockChaine.getChaine()),s);
	}

	@Test
	public void testGetLabel() {
		assertTrue(mockChaine.getLabel().equals("to upper case"));
	}

	@Test
	public void testHelpMessage() {
		assertTrue(mockChaine.helpMessage().equals("Transform all the letters to upper case"));
	}

}
