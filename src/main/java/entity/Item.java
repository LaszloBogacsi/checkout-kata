package entity;

public class Item {
    private String sku;
    private double unitPrice;

    public Item(String sku, double unitPrice) {
        this.sku = sku;
        this.unitPrice = unitPrice;
    }

    public String getSku() {
        return sku;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

}
