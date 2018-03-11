package entity;

/**
 * Rule entity to describe a pricing rule
 */
public class Rule {
    private final int ruleId; // unique identifier of a rule
    private final String type; // rule type (multibuy... etc)
    private final int minQuantityToQualify; // int number of minimum items to qualify to the rule
    private final double newPrice; // new offer price of the items

    /**
     * Constructor to set the properties of a rule
     * @param ruleId int unique identifier
     * @param type string rule type
     * @param minQuantityToQualify int number of items to qualify to the rule
     * @param newPrice double new offer price
     */
    private Rule(int ruleId, String type, int minQuantityToQualify, double newPrice) {
        this.ruleId = ruleId;
        this.type = type;
        this.minQuantityToQualify = minQuantityToQualify;
        this.newPrice = newPrice;
    }

    /**
     * Static api method to create a new rule with all parameters
     * @param ruleId int unique identifier
     * @param type string rule type
     * @param minQuantityToQualify int number of items to qualify to the rule
     * @param newPrice double new offer price
     * @return a new Rule object
     */
    public static Rule create(int ruleId, String type, int minQuantityToQualify, double newPrice) {
        return new Rule(ruleId, type, minQuantityToQualify, newPrice);
    }

    /**
     * Getter for rule Id
     * @return int rule id
     */
    public int getRuleId() {
        return ruleId;
    }

    /**
     * Getter for the rule type
     * @return strung type
     */
    public String getType() {
        return type;
    }

    /**
     * Getter
     * @return int minimum number number of items to qualify
     */
    public int getMinQuantityToQualify() {
        return minQuantityToQualify;
    }

    /**
     * Getter for the new special price
     * @return double special price
     */
    public double getNewPrice() {
        return newPrice;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "ruleId=" + ruleId +
                ", type='" + type + '\'' +
                ", minQuantityToQualify=" + minQuantityToQualify +
                ", newPrice=" + newPrice +
                '}';
    }
}
