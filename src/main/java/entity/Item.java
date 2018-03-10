package entity;

public class Item {
    private String sku;
    private double unitPrice;

    private Item(String sku, double unitPrice) {
        this.sku = sku;
        this.unitPrice = unitPrice;
    }

    public static Item create(String sku, double price) {
        return new Item(sku, price);
    }

    public String getSku() {
        return sku;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

}
