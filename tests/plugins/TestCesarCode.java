package plugins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCesarCode {
	
	private String string;
	private CesarCode aveCesar;
	@Before
	public void initChaine() {
		string = new String("Roos");
		aveCesar = new CesarCode(1);
	}
	
	@Test
	public void testTransform() {
		String s = new String("Sppt");
		assertFalse(string.equals(s));
		assertEquals(s,aveCesar.transform(string));
	}
	
	@Test
	public void testGetLabel() {
		assertEquals(aveCesar.getLabel(),"Cesar Code 1");
	}

	@Test
	public void testHelpMessage() {
		assertEquals(aveCesar.helpMessage(),"Apply a Cesar code to the text (ie. a shift by 1 character)");
	}

}
