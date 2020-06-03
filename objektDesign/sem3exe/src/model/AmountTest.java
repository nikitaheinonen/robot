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
public class AmountTest {

	

	@Test
	public void testAdd() {
		Amount am1 = new Amount(5);
		Amount am2 = new Amount(1);
		Amount result;
		result = am1.add(am2);
		assertEquals("add doesnt work, amounts differ", result.getAmount(), 6);
	}
	
	@Test
	public void testGet(){
		Amount am1 = new Amount(5);
		assertEquals("get doesnt work, amounts differ", am1.getAmount(), 5);
	}
	
	@Test
	public void testSub(){
		Amount am1 = new Amount(5);
		Amount am2 = new Amount(1);
		Amount result;
		result = am1.sub(am2);
		assertEquals("sub doesnt work, amounts differ", result.getAmount(), 4);
	}
	
	@Test
	public void testMult(){
		Amount am1 = new Amount(5);
		Amount am2 = new Amount(2);
		Amount result;
		result = am1.multiply(am2);
		assertEquals("multiply doesnt work, amounts differ", result.getAmount(), 10);
	}

}
