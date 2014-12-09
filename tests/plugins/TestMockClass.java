package plugins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMockClass {
	MockClass mc;
	@Before
	public void init() {
		mc = new MockClass();
	}
	@Test
	public void testTransform() {
		String s = "string";
		assertEquals(s,mc.transform(s));
	}
	@Test
	public void testGetLabel() {
		String s = "label";
		assertEquals(s,mc.getLabel());
	}
	@Test
	public void testGetHelp() {
		String s = "help! i need somebody, help!";
		assertEquals(s,mc.helpMessage());
		
	}

}
