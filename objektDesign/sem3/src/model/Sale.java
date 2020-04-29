package model;

import integration.Item;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * Represents a sale.
 */
public class Sale {
    private Total total;
    private HashMap<String, Item> items = new HashMap<>();

    /**
     * Creates a new instance of Sale.
     */
    public Sale(){
        this.total = new Total();
    }

    /**
     * Get total
     *
     * @return total.
     */
    public Total getTotal() {
        return total;
    }

    /**
     * Gets the HashMap items.
     *
     * @return The HashMap items.
     */
    public HashMap<String, Item> getItems(){
        return items;
    }

    /**
     * Updates the current sale. Updates how many items and the running total.
     *
     * @param item the item that will be added to the sale.
     * @return  the itemDescription as a string.
     */
    public String updateSale(Item item){
        if (itemListContains(item)) {
            updateItemQuantityAndTotal(item);
        } else {
            addItemAndUpdateTotal(item);
        }
        return item.getItemDescription().toString();
    }

    private boolean itemListContains(Item item){
        return items.containsKey(item.getItemIdentifier());
    }

    private void updateItemQuantityAndTotal(Item item){
        Item oldItem = items.get(item.getItemIdentifier());
        oldItem.increaseQuantity(item.getQuantity());
        items.put(oldItem.getItemIdentifier(), oldItem);
        total.updateTotal(item);
    }

    private void addItemAndUpdateTotal(Item item){
        items.put(item.getItemIdentifier(), item);
        total.updateTotal(item);
    }

    /**
     * Makes the instance into to a String
     *
     * @return The instance as a String.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator entriesIterator = getEntries();

        while(entriesIterator.hasNext()) {
            Item item = getCurrentItem(entriesIterator);
            builder.append(item.getItemDescription().toString());
            addNewLine(builder, " quantity: " + item.getQuantity().toString());
        }

        addNewLine(builder, "Total: " + total.getTotal().toString());
        addNewLine(builder, "Tax: " + total.getTotalTax());
        return builder.toString();
    }

    private Iterator getEntries(){
        Set entries = items.entrySet();
        return entries.iterator();
    }

    private Item getCurrentItem(Iterator entriesIterator){
        Map.Entry mapping = (Map.Entry) entriesIterator.next();
        return (Item) mapping.getValue();
    }

    private void addNewLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }
}
