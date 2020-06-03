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
public class ItemDTOTest {

	
	ItemDTO testItem = new ItemDTO("Bulle", "1234", 20, new Amount(20), new Amount(2));
	String itemId = "1234";
	String name = "Bulle";
	int quant = 20;
	int price = 20;
	int vat = 2;
	
	@Test
	public void testGetName() {
		assertEquals("Names dont match", testItem.getName(), name);
	}
	
	@Test
	public void testGetId(){
		assertEquals("Id string doesnt match", testItem.getIdentifier(), itemId);
	}
	
	@Test
	public void testGetQuant(){
		assertEquals("Quantity doesnt match", testItem.getQuantity(), quant);
	}
	
	@Test
	public void testGetPrice(){
		assertEquals("Price doesnt match", testItem.getPrice().getAmount(), price);
	}
	
	@Test
	public void testGetVat(){
		assertEquals("Vat doesnt match", testItem.getVat().getAmount(), vat);
	}

}
