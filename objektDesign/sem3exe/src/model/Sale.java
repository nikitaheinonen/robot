/**
 * 
 */
package model;

import java.util.*;
import java.time.LocalTime;

import integration.ItemDTO;
import integration.Printer;


/**
 * @author Nikita
 *Represents a sale for a customer
 */
public class Sale {
	private ArrayList<ItemDTO> soldItems;
	private LocalTime time;
	private Amount total;
	private Amount vat;
	private Amount runningTotalWithVat;
	private boolean flag = true;
	private RevenueObserver observer;
	
	
	/*
	 * Creates a new instance of sale with a list and current time
	 */
	public Sale(){
		soldItems = new ArrayList<ItemDTO>();
		time = setTime();
		total = new Amount(0);
		runningTotalWithVat = new Amount(0);
		vat = new Amount(0);
	}
	/*
	 * Adds item to Sale
	 * @param itemSold item to be added/sold
	 * @return this current sale
	 */
	public Sale updateSale(ItemDTO itemSold){
		ItemDTO updatedQ = setQuantityInSale(itemSold);
		if(flag){
			soldItems.add(updatedQ);
		}
		this.total = total.add(updatedQ.getPrice());
		this.vat = vat.add(updatedQ.getVat());
		return this;
	}
	/*
	 * @param obs adds an observer
	 */
	public void addObserver(RevenueObserver obs){
		this.observer = obs;
	}
	
	private ItemDTO setQuantityInSale(ItemDTO item){
		if(checkListForItem(item)){
			item.setQuantity(1);
			flag = true;
		} else{
			item.setQuantity(item.getQuantity() + 1);
			flag = false;
		}
		return item;
	}
	
	private boolean checkListForItem(ItemDTO item){
		for(ItemDTO i : soldItems){
			if(i.getName() == item.getName()){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Creates receipt and prints it
	 * 
	 * @param printer. Printer that prints receipt.
	 * @return String the receipt 
	 */
	public String printReceipt(Printer printer) {
		String s;
		Receipt receipt = new Receipt(this); 
		s = printer.print(receipt);
		observer.updateRevenue(receipt.getObsRev());
		return s;
	}
	
	private LocalTime setTime(){
		return LocalTime.now();
	}
	/*
	 * @return time of sale
	 */
	public LocalTime getTime(){
		return time;
	}
	/*
	 * @return the current total
	 */
	public Amount getRunningTotal(){
		return this.total;
	}
	/*
	 * @return Vat+price
	 */
	public Amount getTotalWithVat(){
		return this.runningTotalWithVat;
	}
	
	
	/*
	 * @return total vat
	 */
	public Amount getTotalVat(){
		return this.vat;
	}
	/*
	 * @return list of sold items
	 */
	public ArrayList<ItemDTO> getSoldItems(){
		return this.soldItems;
	}
	
}
