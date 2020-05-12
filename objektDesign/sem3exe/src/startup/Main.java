/**
 * 
 */
package startup;

import controller.Controller;
import view.View;
import integration.Printer;
import integration.SystemCreator;

/**
 * @author Nikita
 *
 */
public class Main {

	/**Main method
	 * @param args
	 */
	public static void main(String[] args) {
		SystemCreator systemCreator = new SystemCreator();
		Printer printer = new Printer();
		Controller controller = new Controller(systemCreator, printer);
		View view = new View(controller);
		view.execution();

	}

}
