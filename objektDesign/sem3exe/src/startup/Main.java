/**
 * 
 */
package startup;

import controller.Controller;
import view.TotalRevenueView;
import view.View;
import integration.FailedToFindItemIdException;
import integration.Printer;
import integration.SystemCreator;

/**
 * @author Nikita
 *
 */
public class Main {

	/**Main method
	 * @param args
	 * 
	 */
	public static void main(String[] args){
		SystemCreator systemCreator = new SystemCreator();
		Printer printer = new Printer();
		TotalRevenueView observer = new TotalRevenueView();
		Controller controller = new Controller(systemCreator, printer, observer);
		View view = new View(controller);
		view.execution();

	}

}
