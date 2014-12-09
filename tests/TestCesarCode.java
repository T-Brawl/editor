package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import plugins.CesarCode;

public class TestCesarCode {
	
	private MockChaine mockChaine;
	
	@Before
	public void initChaine() {
		mockChaine = new MockChaine("Roos",new CesarCode());
	}
	
	
	public void testTransform() {
		String s = new String("Sppt");
		assertFalse(mockChaine.getChaine().equals(s));
		assertEquals(mockChaine.transform(mockChaine.getChaine()),s);
	}
	
	@Test
	public void testGetLabel() {
		assertTrue(mockChaine.getLabel().equals("Cesar Code 1"));
	}

	@Test
	public void testHelpMessage() {
		assertTrue(mockChaine.helpMessage().equals("Apply a Cesar code to the text (ie. a shift by 1 character)"));
	}

}
