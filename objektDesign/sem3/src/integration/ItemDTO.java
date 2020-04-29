package integration;

import util.Amount;

import java.util.Objects;

/**
 * Represents the data of an item.
 */
public class ItemDTO {
    private final Amount price;
    private final String itemName;
    private final Amount taxAmount;

    /**
     * Creates a new instance representing an item.
     *
     * @param price the price of the item.
     * @param itemName the name of the item.
     * @param taxAmount the tax amount of the item.
     */
    public ItemDTO(Amount price, String itemName, Amount taxAmount){
        this.price = price;
        this.itemName = itemName;
        this.taxAmount = taxAmount;
    }

    /**
     * Get price
     *
     * @return price
     */
    public Amount getPrice() {
        return price;
    }

    /**
     * Get itemName
     *
     * @return itemNAme
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Get taxAmount
     *
     * @return taxAmount.
     */
    public Amount getTaxAmount() {
        return taxAmount;
    }

    /**
     * Turns the instance into a String
     *
     * @return The instance as a String.
     */
    @Override
    public String toString() {
        String builder = "item name: " + itemName + "\t" +
                "price: " + price + "\t" +
                "tax amount: " + taxAmount + "\t";
        return builder;
    }

    /**
     * Two ItemDTO instances are equal if all fields are equal.
     *
     * @param obj The ItemDT to compare with this ItemDTO.
     * @return true if all fields in the specified ItemDTO are equal to
     *         corresponding fields in this ItemDTO, false if they are not.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        final ItemDTO other = (ItemDTO) obj;
        if (!Objects.equals(this.price, other.price)){
            return false;
        }
        if (!this.itemName.equals(other.itemName)){
            return false;
        }
        if (!Objects.equals(this.taxAmount, other.taxAmount)){
            return false;
        }
        return true;
    }
}
