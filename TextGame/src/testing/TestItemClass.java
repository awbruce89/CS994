package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Item;

public class TestItemClass {

	private Item item;
	
	@Before
	public void setUp() throws Exception {
		item = new Item("", "");
	}

	@After
	public void tearDown() throws Exception {
		item = null;
	}

	
	/**
	 * Test getting and setting Item name
	 */
	@Test
	public void testGetSetName() {
		item.setName("Item Name");
		assertEquals("Item Name", item.getName());
	}

	/**
	 * Test getting and setting Item description
	 */
	@Test
	public void testGetSetDescription() {
		item.setDescription("Item Desc");
		assertEquals("Item Desc", item.getDescription());
	}
}
