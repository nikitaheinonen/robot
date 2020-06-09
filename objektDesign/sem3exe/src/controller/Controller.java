/**
 * 
 */
package controller;

import integration.*;
import model.*;

/**
 * @author Nikita
 *The controller handles calls to integration and model
 */
public class Controller {
	private SystemCreator systemCreator;
	private Printer printer;
	private Sale sale;
	private ExternalAccountingSystem eas;
	private CashRegister cashRegister;
	private InventorySystem inventorySystem;
	private RevenueObserver obs;
	
	/*
	 * Create controller
	 * @param sysCre the systemController that creates external systems
	 * @param print the printer that prints out receipt
	 */
	public Controller(SystemCreator sysCre, Printer print, RevenueObserver obs){
		this.systemCreator = sysCre;
		this.printer = print;
		this.eas = this.systemCreator.getEAS();
		this.inventorySystem = this.systemCreator.iS();
		cashRegister = new CashRegister();
		this.obs = obs;
		
	}
	/*
	 * Starts a new sale
	 */
	public void startSale(){
		this.sale = new Sale();
		sale.addObserver(obs);
		
	}
	/*
	 * Scans an item
	 * @param itemIdentifier of the item scanned
	 * @return a String containing info about current item to be displayed
	 */
	public String scanItem(String itemIdentifier) throws FailedToFindItemIdException{
		try{
			String out;
			ItemDTO item = inventorySystem.findItem(itemIdentifier);
			this.sale.updateSale(item);
			out = "Item scanned: " + item.getName() + " | price: " + item.getPrice() + " kr.";
			out += "\nRunning total with Vat: " + this.sale.getRunningTotal().add(this.sale.getTotalVat());
			return out;
			
		}catch(DisconnectedFromDataBaseException d){
			String fail;
			fail = "**Public** Unable to fetch this item from database, try again later!";
			return fail;
		}
	}
	/*
	 * End the sale, update systems and print price
	 * @return integer with value of running total
	 */
	public int endSale(){
		int runningTot;
		runningTot = this.sale.getRunningTotal().add(this.sale.getTotalVat()).getAmount();
		return runningTot;
		
	}
	/*
	 * Makes a payment
	 * @param amount the amount paid
	 * @return integer pay with the amount of change the customer should receive
	 */
	public int payment(int amount){
		int pay;
		Amount finalPayment = new Amount(amount);
		Amount change = finalPayment.sub(this.sale.getRunningTotal().add(this.sale.getTotalVat()));
		cashRegister.addPayment(change);
		pay = change.getAmount();
		//this.sale.printReceipt(printer);
		return pay;
		
	}
	/*
	 * Gets the receipt information
	 * @return String the receipt in string format.
	 */
	public String printRec(){
		String rec;
		rec = this.sale.printReceipt(printer);
		return rec;
	}
	
	
	
	

}
