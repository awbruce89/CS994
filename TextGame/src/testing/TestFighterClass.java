/**
 * 
 */
package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Fighter;

/**
 * @author Alasdair
 *
 */
public class TestFighterClass {

	private Fighter fighter;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fighter = new Fighter("", "", 0, 0);
	}
	

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		fighter = null;
	}
	
	/**
	 * Test getting and setting fighter health
	 */
	@Test
	public void testGetSetHealth() {
		fighter.setHealth(10);
		assertEquals(10, fighter.getHealth());
	}
	
	/**
	 * Test getting and setting fighter strength
	 */
	@Test
	public void testGetSetStrength() {
		fighter.setStrength(10);
		assertEquals(10, fighter.getStrength());
	}
	
	/**
	 * Test getting and setting fighter defending status
	 */
	@Test
	public void testGetSetDefending() {
		fighter.setDefending(true);
		assertTrue(fighter.getDefending());
	}


}
