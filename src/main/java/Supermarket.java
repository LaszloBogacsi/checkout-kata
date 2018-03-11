import entity.Item;
import entity.Rule;

import java.util.Arrays;
import java.util.List;

/**
 * Supermarket object representing a supermarket with checkouts and items and pricing rules
 */
public class Supermarket {
    /**
     * Main method to try the checkout system
     * Below find a set of rules and items from the kata description
     * @param args not used
     */
    public static void main(String[] args) {
        // a list of rules that can apply to items
        List<Rule> rules = Arrays.asList(
                Rule.create(1, "multiBuy", 2, 45.0),
                Rule.create(2,"multiBuy", 3, 130.0));

        // Inventory of items some with defined associated rules
        Item itemA = Item.create("A", 50.0, 2);
        Item itemB = Item.create("B", 30.0, 1);
        Item itemC = Item.create("C", 20.0);
        Item itemD = Item.create("D", 15.0);

        Checkout checkout = Checkout.create(rules);

        checkout.scan(itemB);
        checkout.scan(itemA);
        checkout.scan(itemA);
        checkout.scan(itemB);
        checkout.scan(itemA);
        checkout.scan(itemC);
        checkout.scan(itemD);


        System.out.println("Checkout: " + checkout);
        System.out.println("Total price: " + checkout.getTotal());
    }
}
