package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Area;
import game.Item;

/**
 * @author Alasdair
 *
 */
public class TestAreaClass {

	private Area area;
	private Item item;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		area = new Area("", null);
		item = new Item("", "");		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		area = null;
		item = null;
	}

	/**
	 * Test getting and setting Area description
	 */
	@Test
	public void testGetSetDescription() {
		area.setDescription("Room Desc");
		assertEquals("Room Desc", area.getDescription());
	}
	
	/**
	 * Test getting and setting Area Item
	 */
	@Test
	public void testGetSetItem() {
		area.setItem(item);
		assertEquals(item, area.getItem());
	}
	
	/**
	 * Test getting and setting Area challenge complete status
	 */
	@Test
	public void testGetSetChallengeComplete() {
		area.setChallengeComplete(true);
		assertTrue(area.getChallengeComplete());
	}

}
