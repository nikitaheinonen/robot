package integration;

/**
 * Represents a creator that consists of different catalogs.
 */
public class CatalogCreator {
    private ItemCatalog itemCatalog;

    /**
     * Creates a new instance
     */
    public CatalogCreator(){
        itemCatalog = new ItemCatalog();
    }

   

    /**
     * Gets the value of itemCatalog.
     * @return  The value of itemCatalog.
     */
    public ItemCatalog getItemCatalog() {
        return itemCatalog;
    }
}
