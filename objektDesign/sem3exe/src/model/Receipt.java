/**
 * 
 */
package model;

import integration.ItemDTO;
import java.util.*;
/**
 * @author Nikita
 *The proof of sale
 */
public class Receipt {
	private String receipt;
	private Sale sale;
	
	public Receipt(Sale sale){
		this.sale = sale;
	}
	
	private void printItems(){
		for(ItemDTO i : sale.getSoldItems()){
			this.receipt += (i.getName() + " ** " + i.getQuantity() + "st " + i.getPrice() + "kr/st.\n");
		}
	}
	/*
	 * Prints out all info form sale
	 * @return receipt as a string.
	 */
	public String printReceipt(){
		receipt = "\n";
		receipt += "----------RECEIPT---------\n";
		receipt += "POS IN STOCKHOLM\nTIME OF SALE:" + sale.getTime();
		receipt += "\n";
		printItems();
		receipt += "\n" + "TOTAL WITH VAT:" + sale.getRunningTotal().add(sale.getTotalVat()) + "kr.\n";
		return receipt;
	}
	
}
