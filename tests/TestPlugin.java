package tests;

import org.junit.Test;

/**
 * represents a plugin that can be dynamically added to the extendable editor.
 * A plugin can perform a transformation on a String.
 * A menu item corresponds to a a plugin in the editor. The label of this item is given by the <code>getLabel</code> method.
 * @author JC
 */
public interface TestPlugin {
	/** the package name of plugins */
	public static final Object PACKAGE_NAME = "plugins";
	
	/** performs a transformation on a string 
	 * @param s the string to be transformed
	 * @return the transformed string
	 */
	@Test
	public String testTransform() ;

	/** returns a label associated to this plugin.
	 * @return a label associated to this plugin.
	 */
	@Test
	public String testGetLabel() ;
	
	/** a help message describing the plugin tranformation operation
	 * @return a help message describing the plugin tranformation operation
	 */
	@Test
	public String testHelpMessage();

}
