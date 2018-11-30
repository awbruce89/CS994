package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.Arena;
import game.Enemy;
import game.Item;

/**
 * @author Alasdair
 *
 */
public class TestArenaClass {
	
	private Arena arena;
	private Item item;
	private Enemy enemy;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		item = new Item("", "");
		arena = new Arena(item);
		enemy = new Enemy();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		item = null;
		arena = null;
		enemy = null;
	}

	/**
	 * Test getting and setting Arena Enemy
	 */
	@Test
	public void testGetSetEnemy() {
		arena.setEnemy(enemy);
		assertEquals(enemy, arena.getEnemy());
	}
}
