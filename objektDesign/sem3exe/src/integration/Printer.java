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
	 * @return String the receipt
	 */
	public String print(Receipt recepit){
		String s;
		s = recepit.printReceipt();
		return s;
	}
	
	
}
