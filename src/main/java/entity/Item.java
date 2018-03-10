package entity;

public class Item {
    private final String sku;
    private final double unitPrice;
    private final Integer ruleId;


    private Item(String sku, double unitPrice, Integer ruleId) {
        this.sku = sku;
        this.unitPrice = unitPrice;
        this.ruleId = ruleId ;
    }

    public static Item create(String sku, double price) {
        return new Item(sku, price, null);
    }
    public static Item create(String sku, double price, int ruleId) {
        return new Item(sku, price, ruleId);
    }

    public String getSku() {
        return sku;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getRuleId() {
        return ruleId;
    }
}
