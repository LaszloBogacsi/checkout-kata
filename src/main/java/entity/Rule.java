package entity;

public class Rule {
    private final int ruleId;
    private final String type;
    private final int minQuantityToQualify;
    private final double newPrice;

    private Rule(int ruleId, String type, int minQuantityToQualify, double newPrice) {
        this.ruleId = ruleId;
        this.type = type;
        this.minQuantityToQualify = minQuantityToQualify;
        this.newPrice = newPrice;
    }

    public static Rule create(int ruleId, String type, int minQuantityToQualify, double newPrice) {
        return new Rule(ruleId, type, minQuantityToQualify, newPrice);
    }

    public int getRuleId() {
        return ruleId;
    }

    public String getType() {
        return type;
    }

    public int getMinQuantityToQualify() {
        return minQuantityToQualify;
    }

    public double getNewPrice() {
        return newPrice;
    }
}
