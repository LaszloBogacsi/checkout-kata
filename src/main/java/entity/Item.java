package entity;

/**
 * Item entity to describe an item in the supermarket
 */
public class Item {
    private final String sku; // stock keeping unit
    private final double unitPrice; // price of one item
    private final Integer ruleId; // "foreign key" for an associated rule that applies to this item


    /**
     * private constructor to set the properties of an item
     * @param sku string stock keeping unit
     * @param unitPrice double price of one item
     * @param ruleId Integer associated rule id
     */
    private Item(String sku, double unitPrice, Integer ruleId) {
        this.sku = sku;
        this.unitPrice = unitPrice;
        this.ruleId = ruleId ;
    }

    /**
     * Factory method to create an item with 2 params
     * @param sku string stock keeping unit identifier
     * @param price double price of an item
     * @return a new Item with the properies as above
     */
    public static Item create(String sku, double price) {
        return new Item(sku, price, null);
    }

    /**
     * Factory method to create an item with 3 params
     * @param sku string stock keeping unit identifier
     * @param price double price of an item
     * @param ruleId Integer associated rule id that applies to this item
     * @return a new Item with the properties as above
     */
    public static Item create(String sku, double price, int ruleId) {
        return new Item(sku, price, ruleId);
    }

    /**
     * Getter for sku
     * @return a string sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * Getter for unit price
     * @return a double price
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Getter for rule id
     * @return int rule id
     */
    public int getRuleId() {
        return ruleId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "sku='" + sku + '\'' +
                ", unitPrice=" + unitPrice +
                ", ruleId=" + ruleId +
                '}';
    }
}
