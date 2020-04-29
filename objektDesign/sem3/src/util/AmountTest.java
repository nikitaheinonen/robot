/**
 * 
 */
package util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Nikita
 *
 */
public class AmountTest {
	private Amount amountIsFive;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		amountIsFive = new Amount(5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		amountIsFive = null;
	}

	@Test
	public void testEqual() {
		int testFive = 5;
		Amount amountTestFive = new Amount(testFive);
		boolean expected = true;
		boolean result = amountIsFive.equals(amountTestFive);
		assertEquals("Amount with same value are not equal", expected, result);
	}
	
	@Test
	public void testNotEqual(){
		int testFour = 4;
		Amount amountTestFour = new Amount(testFour);
		boolean expected = false;
		boolean result = amountIsFive.equals(amountTestFour);
		assertEquals("Amount with different values are equal", expected, result);
	}
	
	@Test
	public void testAdd(){
		int add1 = 5;
		int add2 = 2;
		Amount amountAdd1 = new Amount(add1);
		Amount amountAdd2 = new Amount(add2);
		Amount expectedAmount = new Amount(add1 + add2);
		Amount resultAmount = amountAdd1.plus(amountAdd2);
		assertEquals("The plus method is not working", expectedAmount, resultAmount);
	}
	
	@Test
	public void testMultiply(){
		int mult1 = 3;
		int mult2 = 6;
		Amount amountMult1 = new Amount(mult1);
		Amount amountMult2 = new Amount(mult2);
		Amount expectedAmount = new Amount(3 * 6);
		Amount resultAmount = amountMult1.multiply(amountMult2);
		assertEquals("The multiply is not working", expectedAmount, resultAmount);
		
	}

}
