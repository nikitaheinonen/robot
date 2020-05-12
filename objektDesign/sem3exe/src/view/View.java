/**
 * 
 */
package view;

import controller.Controller;

/**
 * @author Nikita
 *Mockup view with hardcoded purchases
 */
public class View {
	private Controller controller;
	
	public View(Controller controller){
		this.controller = controller;
	}
	
	public void execution(){
		System.out.println("Starting new sale!");
		controller.startSale();
		System.out.println("Cashier enters some items with the itemIdentifier code");
		System.out.println("-----------------------------");
		controller.scanItem("22");
		System.out.println("-----------------------------");
		controller.scanItem("1");
		System.out.println("-----------------------------");
		controller.scanItem("43");
		System.out.println("-----------------------------");
		controller.scanItem("1");
		System.out.println("-----------------------------");
		System.out.println("All items entered.");
		controller.endSale();
		System.out.println("Cashier enters amount paid: 300.");
		controller.payment(300);
		
	}

}
