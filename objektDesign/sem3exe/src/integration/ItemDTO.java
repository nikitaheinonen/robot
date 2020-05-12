/**
 * 
 */
package integration;

import model.Amount;

/**
 * @author Nikita
 *Represents an item with its information
 */
public class ItemDTO {
	private String name;
	private String identifier;
	private int quantity;
	private final Amount price;
	private final Amount vat;
	
	/*
	 * Creates an itemDTO
	 * @param name Name of the item
	 * @param identifier Identifiernumber of the item
	 * @param quantity How many items
	 * @param price The price of the item
	 * @param vat the taxvalue
	 */
	public ItemDTO(String name, String identifier, int quantity, Amount price, Amount vat){
		this.name = name;
		this.identifier = identifier;
		this.quantity = quantity;
		this.price = price;
		this.vat = vat;
	}
	/*
	 * @return the name 
	 */
	public String getName(){
		return name;
	}
	/*
	 * @param q set quantity to q
	 */
	public void setQuantity(int q){
		this.quantity = q;
	}
	/*
	 * @return the identifier
	 */
	public String getIdentifier(){
		return identifier;
	}
	/*
	 * @return quantity
	 */
	public int getQuantity(){
		return quantity;
	}
	/*
	 * @return price
	 */
	public Amount getPrice(){
		return price;
	}
	/*
	 * @return vat
	 */
	public Amount getVat(){
		return vat;
	}

}
