import entity.Item;
import entity.Rule;

import java.util.ArrayList;
import java.util.Collections;
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
        applyMultibuyRule(this.basket);
        updateTotal(this.basket);
    }

    private void updateTotal(List<Item> basket) {
        this.total = basket.stream()
                .mapToDouble(Item::getUnitPrice)
                .sum();
    }

    private void applyMultibuyRule(List<Item> basket) {
        Item lastItem = basket.get(basket.size()-1);
        int lastItemCount = Collections.frequency(basket, lastItem);
        if (lastItemCount > 1) {
            Rule rule = getRuleById(lastItem.getRuleId());
            if (lastItemCount % rule.getMinQuantityToQualify() == 0) {
                double discount = rule.getNewPrice() - lastItem.getUnitPrice() * rule.getMinQuantityToQualify();
                this.basket.add(Item.create(rule.getType(), discount));
            }
        }
    }

    private Rule getRuleById(int id) {
       return this.rules.stream().filter(rule -> rule.getRuleId() == id).findFirst().get();
    }

}
