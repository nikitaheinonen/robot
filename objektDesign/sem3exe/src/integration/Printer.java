/**
 * 
 */
package integration;

import model.Receipt;

/**
 * @author Nikita
 *Prints receipt
 */
public class Printer {
	public Printer(){}
	/*
	 * Prints receipt
	 * @param recepit the recepit to be printed
	 */
	public void print(Receipt recepit){
		System.out.println(recepit.printReceipt());
	}
	
	
}
