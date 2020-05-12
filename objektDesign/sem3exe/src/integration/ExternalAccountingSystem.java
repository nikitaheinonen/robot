/**
 * 
 */
package integration;

import model.Sale;
import java.util.*;
/**
 * @author Nikita
 *Logs accounting
 */
public class ExternalAccountingSystem {
	private ArrayList<Integer> log = new ArrayList<Integer>();
	/*
	 * Logs the total amount sold for to accounting
	 * @param sale the completed sale
	 *
	 */
	public void updateAccounting(Sale sale){
		log.add(sale.getRunningTotal().getAmount());
	}
}
