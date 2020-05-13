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
public class DisconnectedFromDataBaseExceptionTest {
	InventorySystem invSys;
	ItemDTO serverFail = new ItemDTO("ServerFail", "999", 1 , new Amount(0), new Amount(0));
	private String dbFail = "999";

	

	@Test
	public void testCorrectDisconnect() {
		invSys = new InventorySystem();
		invSys.
	}

}
