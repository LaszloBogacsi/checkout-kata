import entity.Item;
import entity.Rule;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    private List<Item> basket = new ArrayList<>();
    private double total = 0.0;
    private final List<Rule> rules;

    public Checkout(List<Rule> rules) {
        this.rules = rules;
    }

    public double getTotal() {
        return total;
    }

    public List<Item> getBasket() {
        return basket;
    }

    public void scan(Item item) {
        basket.add(item);
        updateTotal(this.basket);
    }

    private void updateTotal(List<Item> basket) {
        int basketTotal = 0;
        this.total = basket.stream()
                .mapToDouble(Item::getUnitPrice)
                .sum();
    }

}
