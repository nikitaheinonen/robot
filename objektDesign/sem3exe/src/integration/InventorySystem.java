/**
 * 
 */
package integration;

import java.util.*;
import model.Amount;
import model.Sale;
/**
 * @author Nikita
 *Represents theinventory
 */
public class InventorySystem {
	private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
	ItemDTO cola = new ItemDTO("Cola", "1", 100, new Amount(20), new Amount(5));
	ItemDTO gröt = new ItemDTO("Gröt", "22", 100, new Amount(10), new Amount(2));
	ItemDTO ost = new ItemDTO("Ost", "43", 100, new Amount(100), new Amount(10));
	/*
	 * adds the items to the list
	 */
	public InventorySystem(){
		addItems();
	}
	/*
	 * Checks if the item "scanned" exists in inventory
	 * @param itemIdentifier the identifier number for an item
	 * @return i the item found or null if not found
	 */
	public ItemDTO findItem(String itemIdentifier){
		for(ItemDTO i : itemList){
			if(i.getIdentifier() == itemIdentifier){
				return i;
			}
		}
		return null;
	}
	
	private void addItems(){
		itemList.add(cola);
		itemList.add(gröt);
		itemList.add(ost);
	}
	/*
	 * "updates" the external inventory with the sold items
	 * @param log the completed sale
	 */
	public void updateExternalInventory(Sale log){
		update(log.getSoldItems());
	}
	
	private void update(ArrayList<ItemDTO> sale){
	}
	
	
	
	
	
	
}
