package plugins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestUpperCase {
	private ToUpperCase uppercase;
	private String s;
	@Before
	public void initChaine() {
		uppercase = new ToUpperCase();
		s = new String("TOTO");
	}
	

	@Test
	public void testTransform() {
		String string = "toto";
		assertFalse(string.equals(s));
		assertEquals(s,uppercase.transform(string));
	}

	@Test
	public void testGetLabel() {
		assertEquals(uppercase.getLabel(),"to upper case");
	}

	@Test
	public void testHelpMessage() {
		assertEquals(uppercase.helpMessage(),"Transform all the letters to upper case");
	}

}
