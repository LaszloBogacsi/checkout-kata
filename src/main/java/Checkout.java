import entity.Item;
import entity.Rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Checkout to calculate total price for a number of items
 */
public class Checkout {
    private List<Item> basket = new ArrayList<>(); // basket is a list of items added to the checkout
    private double total = 0.0; // the total price of the basket
    private final List<Rule> rules; // list of pricing rules

    /**
     * Cnstructor to instantiate the checkout with a set of rules
     * @param rules are a list of multibuy pricing rules list can be empty or null
     */
    private Checkout(List<Rule> rules) {
        this.rules = rules;
    }

    /**
     * Factory method to create a checkout object
     * @param rules a list of multibuy rules can be empty
     * @return a checkout object with rules
     */
    public static Checkout create(List<Rule> rules) {
        return new Checkout(rules);
    }

    /**
     * Factory method to create a checkout object without rules
     * @return a checkout object with null rules
     */
    public static Checkout create() {
        return new Checkout(null);
    }

    /**
     * To get total price of a basket
     * @return double total price of the basket
     */
    public double getTotal() {
        return total;
    }

    /**
     * The basket contains the scanned items.
     * @return a list of items
     */
    public List<Item> getBasket() {
        return basket;
    }

    /**
     * Adds an item to a basket
     * Applies the pricing rule
     * Updates the total price
     * @param item to add to the basket
     */
    public void scan(Item item) {
        basket.add(item);
        log("INFO", "item added: " + item);
        applyMultibuyRule(this.basket);
        updateTotal(this.basket);
        log("INFO", "total price: " + this.total);
    }

    /**
     * Sums the prices of the passed in basket and updates the total with tbe new value.
     * @param basket a list of items already scanned
     */
    private void updateTotal(List<Item> basket) {
        this.total = basket.stream()
                .mapToDouble(Item::getUnitPrice)
                .sum();
    }

    /**
     * Applies the list of rules to the items in the basket by grabbing the rule for the last item added to the basket,
     * if any, and based on counting the matching items in the basket can determine if the rule should be applied.
     * If should be applied than creates a new Item with the rule type as sku and the discount (price difference) as a
     * negative double price and adds this discount item to the basket.
     * @param basket list of items
     */
    private void applyMultibuyRule(List<Item> basket) {
        Item lastItem = basket.get(basket.size()-1);
        int lastItemCount = Collections.frequency(basket, lastItem);
        if (lastItemCount > 1 && this.rules != null && this.rules.size() > 0) {
            getRuleById(lastItem.getRuleId()).ifPresent(rule -> {
                if (lastItemCount % rule.getMinQuantityToQualify() == 0) {
                    double discount = rule.getNewPrice() - lastItem.getUnitPrice() * rule.getMinQuantityToQualify();
                    this.basket.add(Item.create(rule.getType(), discount));
                    log("INFO", "discount applied:  " + discount);

                }
            });
        }
    }

    /**
     * Helper method to grab a rule from the rules list by it's id
     * @param id int rule id
     * @return an optional rule when the rule exists in the rules list, optional empty otherwise.
     */
    private Optional<Rule> getRuleById(int id) {
       return this.rules.stream()
               .filter(rule -> rule.getRuleId() == id)
               .findFirst();
    }

    /**
     * Helper method to log events to the standard output
     * @param level string level of a log message
     * @param message string body of a log message
     */
    private void log(String level, String message) {
        System.out.println("[" + level + "] " + message);
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "number of items in the basket=" + basket.size() +
                ", current total=" + total +
                '}';
    }
}
