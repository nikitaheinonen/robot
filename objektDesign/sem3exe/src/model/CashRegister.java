/**
 * 
 */
package model;

import model.Amount;
/**
 * @author Nikita
 *Represents a register with cash in it
 */
public class CashRegister {
	private Amount balance;
	
	public CashRegister(){
		this.balance = new Amount(0);
	}
	
	public Amount getBalance(){
		return balance;
	}
	
	public void addPayment(Amount payment){
		balance = balance.add(payment);
	}
}

