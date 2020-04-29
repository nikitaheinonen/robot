package integration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemCatalogTest {
	ItemCatalog itemCatalog;

	@Before
	public void setUp() throws Exception {
		itemCatalog = new ItemCatalog();
	}

	@After
	public void tearDown() throws Exception {
		itemCatalog = null;
	}

	@Test
	public void testItemExists() {
		String testString = "Bulle";
		boolean expected = true;
		boolean actual = itemCatalog.itemExists(testString);
		assertEquals("Expected item did not exist in itemCatalog", expected, actual);
		
	}

	@Test
	public void testItemExists2() {
		String testString = "Mango";
		boolean expected = false;
		boolean actual = itemCatalog.itemExists(testString);
		assertEquals("Item that does not exist, exists in itemCatalog", expected, actual);
	}

}
