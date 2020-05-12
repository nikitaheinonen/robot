/**
 * 
 */
package controller;

import integration.*;
import model.Sale;
import model.CashRegister;
import model.Amount;

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
	
	/*
	 * Create controller
	 * @param sysCre the systemController that creates external systems
	 * @param print the printer that prints out receipt
	 */
	public Controller(SystemCreator sysCre, Printer print){
		this.systemCreator = sysCre;
		this.printer = print;
		this.eas = this.systemCreator.getEAS();
		this.inventorySystem = this.systemCreator.iS();
		cashRegister = new CashRegister();
		
	}
	/*
	 * Starts a new sale
	 */
	public void startSale(){
		this.sale = new Sale();
	}
	/*
	 * Scans an item
	 * @param itemIdentifier of the item scanned
	 */
	public void scanItem(String itemIdentifier){
		ItemDTO item = inventorySystem.findItem(itemIdentifier);
		this.sale.updateSale(item);
		System.out.println("Item scanned: " + item.getName() + " | price: " + item.getPrice() + " kr.");
		System.out.println("running total with Vat: " + this.sale.getRunningTotal().add(this.sale.getTotalVat()));
		
		
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
