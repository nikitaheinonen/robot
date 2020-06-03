/**
 * 
 */
package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Nikita
 *
 */
public class CashRegisterTest {

	
	CashRegister cashReg = new CashRegister();
	
	@Test
	public void testGetB() {
		cashReg.addPayment(new Amount(10));
		assertEquals("get method doesnt work, amounts differ", cashReg.getBalance().getAmount(), 10);
		
	}
	
	@Test
	public void testAddPayment(){
		cashReg.addPayment(new Amount(20));
		assertEquals("addPayment doesnt work, amounts differ", cashReg.getBalance().getAmount(), 20);
	}

}
