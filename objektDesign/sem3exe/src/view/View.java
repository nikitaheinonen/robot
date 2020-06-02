/**
 * 
 */
package view;

import integration.FailedToFindItemIdException;
import controller.Controller;

/**
 * @author Nikita
 *Mockup view with hardcoded purchases
 */
public class View {
	private Controller controller;
	/*
	 * Creates a new view
	 * @param controller the controller that is responsible for the calls
	 */
	public View(Controller controller){
		this.controller = controller;
	}
	
	/*
	 * Runs a hardcoded sample of POS
	 */
	public void execution(){
		System.out.println("Starting new sale!");
		controller.startSale();
		System.out.println("Cashier enters some items with the itemIdentifier code");
		System.out.println("-----------------------------");
		try{
			controller.scanItem("999");
			System.out.println("-----------------------------");
		}catch(FailedToFindItemIdException e){
			System.out.println("This itemId: " + e.getFailId() + " - does not exist in this store! "
					+ "Check your itemID again!");
		}
		try{
			controller.scanItem("1");
			System.out.println("-----------------------------");
		}catch(FailedToFindItemIdException e){
			System.out.println("This itemId: " + e.getFailId() + " - does not exist in this store! "
					+ "Check your itemID again!");
		}
		try{
			controller.scanItem("43");
			System.out.println("-----------------------------");
		}catch(FailedToFindItemIdException e){
			System.out.println("This itemId: " + e.getFailId() + " - does not exist in this store! "
					+ "Check your itemID again!");
		}
		try{
			controller.scanItem("1");
			System.out.println("-----------------------------");
		}catch(FailedToFindItemIdException e){
			System.out.println("This itemId: " + e.getFailId() + " - does not exist in this store! "
					+ "Check your itemID again!");
		}
		System.out.println("All items entered.");
		controller.endSale();
		System.out.println("Cashier enters amount paid: 300.");
		controller.payment(300);
		
	}

}
