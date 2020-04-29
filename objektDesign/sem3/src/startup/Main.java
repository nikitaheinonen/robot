package startup;

import controller.Controller;
import integration.CatalogCreator;
import integration.Printer;
import integration.SystemCreator;
import view.View;

/**
 * Contains the main method.
 * Performs startup of the application.
 */
public class Main {

    /**
     * Starts the application.
     *
     * @param args takes no arguments
     */
    public static void main(String[] args) {
        SystemCreator systemCreator = new SystemCreator();
        CatalogCreator catalogCreator = new CatalogCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(systemCreator, catalogCreator, printer);
        View view = new View(controller);
        view.sampleExecution();
    }
}
