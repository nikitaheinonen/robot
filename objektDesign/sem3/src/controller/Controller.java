package controller;

import integration.*;
import model.CashRegister;
import model.Payment;
import model.Receipt;
import model.Sale;
import util.Amount;

/**
 *  Controller for POS. All calls go through the controller to the other packages.
 *  Some fields are not used for this seminar, but could be used in the future 
 *  to extend this program.
 */
public class Controller {
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private ItemCatalog itemCatalog;
    private Printer printer;
    private CashRegister cashRegister;
    private Sale sale;

    /**
     * Creates a new instance, represented as a controller.
     *
     * @param systemCreator     Used to get all classes that handles external system calls.
     * @param catalogCreator    Used to get all classes that handles database calls.
     * @param printer           Interface to printer.
     */
    public Controller(SystemCreator systemCreator, CatalogCreator catalogCreator, Printer printer){
        this.accountingSystem = systemCreator.getAccountingSystem();
        this.inventorySystem = systemCreator.getInventorySystem();
        this.itemCatalog = catalogCreator.getItemCatalog();
        this.printer = printer;
        this.cashRegister = new CashRegister();
    }

    /**
     *  Initiates a new sale.
     */
    public void startNewSale(){
        this.sale = new Sale();
    }

    /**
     *  If the item identifier exists we will add it to the sale and
     *  return information about the item and show the running total.
     *  Otherwise just shows running total.
     *
     * @param itemIdentifier item to add to sale.
     * @param quantity - amount of that item.
     * @return If {@link Item} exists we return a string with
     * information about the item and the running total,
     * else we return a string with the running total.
     */
    public String registerItem(String itemIdentifier, Amount quantity){
        if (itemCatalog.itemExists(itemIdentifier)){
            Item item = itemCatalog.getItem(itemIdentifier, quantity);
            return sale.updateSale(item) + ", quantity: " + quantity.toString() +
                    ", running total: " + displayTotal();
        }
        return "running total: " + displayTotal();
    }

    /**
     *  Displays the total with VAT calculated into it.
     *
     * @return The total with taxes as a String.
     */
    public String displayTotalWithTax(){
        return "total with taxes: " + sale.getTotal().getTotalWithTax().toString();
    }

    private String displayTotal(){
        return sale.getTotal().getTotal().toString();
    }

    /**
     * Makes a payment with the given Amount. Will be added to the balance of the cashRegister.
     * The external system will be updated, and a receipt will be created and printed by the printer.
     *
     * @param paidAmount The amount of money given by the customer.
     * @return The total change that will be given to the customer.
     */
    public String pay(Amount paidAmount){
        Payment payment = new Payment(paidAmount, sale.getTotal());
        cashRegister.addPayment(payment);
        accountingSystem.bookKeep(sale);
        inventorySystem.updateInventory(sale);
        Receipt receipt = new Receipt(sale);
        printer.printReceipt(receipt);
        sale = null;
        return "Change: " + payment.getChange().toString();
    }

}
