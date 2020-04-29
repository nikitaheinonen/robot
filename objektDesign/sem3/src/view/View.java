package view;

import controller.Controller;
import util.Amount;

/**
 * Plcaholder view class
 */
public class View {
    private Controller controller;

    /**
     *  Creates a new instance, represented as a view.
     * @param controller class where all calls are being made.
     */
    public View(Controller controller){
        this.controller = controller;
    }

    /**
     *  Create sample execution, simulating a sale.
     *  
     */
    public void sampleExecution(){
        System.out.println("START NEW SALE.\n");
        controller.startNewSale();
        System.out.println("*ENTERING ITEMS* \n");
        String out = controller.registerItem("Tomat", new Amount(1));
        System.out.println(out);
        out = controller.registerItem("Gurka", new Amount(2));
        System.out.println(out);
        out = controller.registerItem("ColaZ", new Amount(10));
        System.out.println(out);
        out = controller.registerItem("Gurka", new Amount(20));
        System.out.println(out);
        out = controller.registerItem("Bulle", new Amount(5));
        System.out.println(out);
        System.out.println("Cashier displays the total with taxes. \n");
        out = controller.displayTotalWithTax();
        System.out.println(out);
        System.out.println("Cashier enters the paid amount. \n");
        out = controller.pay(new Amount(5000));
        System.out.println(out);
    }
}
