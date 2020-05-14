/**
 * 
 */
package integration;

import static org.junit.Assert.*;
import model.Amount;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Nikita
 *
 */
public class WrongItemIdTest {

	/**
	 *
	 */
	@Before
	public void setUp(){
	}

	/**
	 *
	 */
	@After
	public void tearDown(){
	}

	@Test
	public void testNonExistingItem() {
		InventorySystem invSys = new InventorySystem();
		String nonExistingItemId = "2";
		try{
			invSys.findItem(nonExistingItemId);
			fail("Found non-existing item!");	
		}catch(FailedToFindItemIdException e){
			assertTrue("Non-existing item was not found" + e.getFailId(), e.getFailId().equals(nonExistingItemId));
		}
	}
	
	@Test
	public void testExistingItem(){
		InventorySystem invSys = new InventorySystem();
		String existingItemId = "43";
		try{
			invSys.findItem(existingItemId);
			assertTrue("Existing item was not found", invSys.ost.getIdentifier().equals("43"));
		}catch(FailedToFindItemIdException e){
			fail("Did not find existing item");
		}
	}
	
	@Test
	public void testDatabaseFail(){
		InventorySystem invSys = new InventorySystem();
		String databaseFail = "999";
		try{
			invSys.findItem(databaseFail);
			fail("Did not crash database");
		}catch(DisconnectedFromDataBaseException e){
			assertTrue("Did not disconnect properly", e.getMessage().contains("***"));
		}catch(FailedToFindItemIdException f){
			assertEquals("Did not disconnect properly", databaseFail, "999");
		}
	}

}
