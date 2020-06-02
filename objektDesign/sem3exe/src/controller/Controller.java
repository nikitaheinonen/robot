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
	 */
	public void scanItem(String itemIdentifier) throws FailedToFindItemIdException{
		try{
			ItemDTO item = inventorySystem.findItem(itemIdentifier);
			this.sale.updateSale(item);
			System.out.println("Item scanned: " + item.getName() + " | price: " + item.getPrice() + " kr.");
			System.out.println("running total with Vat: " + this.sale.getRunningTotal().add(this.sale.getTotalVat()));
		}catch(DisconnectedFromDataBaseException d){
			System.out.println("**Public** Unable to fetch this item from database, try again later!");
		}
	}
	/*
	 * End the sale, update systems and print price
	 */
	public void endSale(){
		System.out.println("Total price with VAT: " + this.sale.getRunningTotal().add(this.sale.getTotalVat()));
	}
	/*
	 * Makes a payment
	 * @param amount the amount paid
	 */
	public void payment(int amount){
		Amount finalPayment = new Amount(amount);
		Amount change = finalPayment.sub(this.sale.getRunningTotal().add(this.sale.getTotalVat()));
		cashRegister.addPayment(change);
		System.out.println("CHANGE: " + change.getAmount() + "kr.");
		this.sale.printReceipt(printer);
		System.out.println("CHANGE: " + change.getAmount() + "kr.");
		
	}
	
	

}
