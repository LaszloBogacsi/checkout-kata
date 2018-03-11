import entity.Item;
import entity.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckoutTest {
    private Checkout checkout;
    private List<Rule> rules;
    private Item itemA = Item.create("A", 1.0);
    private Item itemB = Item.create("B", 2.0, 1);
    private Item itemC = Item.create("C", 3.0, 2);

    @BeforeEach
    void setUp() {
        rules = new ArrayList<>();
    }

    @Test
    void total_is_0_on_init() {
     checkout = new Checkout(rules);
     assertEquals(checkout.getTotal(), 0);
    }

    @Test
    void basket_is_empty_on_init() {
        checkout = new Checkout(rules);
        assertTrue(checkout.getBasket().isEmpty());
    }

    @Test
    void can_add_one_item_to_the_basket() {
        checkout = new Checkout(rules);
        checkout.scan(itemA);
        assertEquals(checkout.getBasket().size(), 1);
    }

    @Test
    void can_calculate_total() {
        checkout = new Checkout(rules);
        checkout.scan(itemA);
        checkout.scan(itemA);
        assertEquals(checkout.getTotal(), 2.0);
    }

    @Test
    void can_apply_one_rule() {
        rules.add(Rule.create(1, "testType", 2, 3.0));
        checkout = new Checkout(rules);
        checkout.scan(itemB);
        checkout.scan(itemB);
        assertEquals(checkout.getTotal(), 3.0);
    }

    @Test
    void can_apply_one_rule_twice() {
        rules.add(Rule.create(1, "testType", 2, 3.0));
        checkout = new Checkout(rules);
        checkout.scan(itemB);
        checkout.scan(itemB);
        checkout.scan(itemB);
        checkout.scan(itemB);
        assertEquals(checkout.getTotal(), 6.0);
    }

    @Test
    void can_apply_one_rule_when_items_not_in_order() {
        rules.add(Rule.create(1, "testType", 2, 3.0));
        checkout = new Checkout(rules);
        checkout.scan(itemB);
        checkout.scan(itemA);
        checkout.scan(itemB);
        assertEquals(checkout.getTotal(), 4.0);
    }

    @Test
    void can_apply_multiple_rules() {
        rules.add(Rule.create(1, "testType", 2, 3.0));
        rules.add(Rule.create(2, "testType", 2, 4.0));
        checkout = new Checkout(rules);
        checkout.scan(itemB);
        checkout.scan(itemB);
        checkout.scan(itemC);
        checkout.scan(itemC);
        assertEquals(checkout.getTotal(), 7.0);
    }

    @Test
    void can_apply_multiple_rules_when_items_not_in_order() {
        rules.add(Rule.create(1, "testType", 2, 3.0));
        rules.add(Rule.create(2, "testType", 2, 4.0));
        checkout = new Checkout(rules);
        checkout.scan(itemB);
        checkout.scan(itemC);
        checkout.scan(itemB);
        checkout.scan(itemC);
        checkout.scan(itemB);
        assertEquals(checkout.getTotal(), 9.0);
    }

    @Test
    void can_apply_multiple_rules_when_items_not_in_order_and_some_has_no_rule() {
        rules.add(Rule.create(1, "testType", 2, 3.0));
        rules.add(Rule.create(2, "testType", 2, 4.0));
        checkout = new Checkout(rules);
        checkout.scan(itemB);
        checkout.scan(itemC);
        checkout.scan(itemA);
        checkout.scan(itemB);
        checkout.scan(itemC);
        assertEquals(checkout.getTotal(), 8.0);
    }

    @Test
    void can_operate_when_there_is_no_matching_rule_present() {
        rules.add(Rule.create(1, "testType", 2, 3.0));
        checkout = new Checkout(rules);
        checkout.scan(itemC); // no matching rule for itemC
        checkout.scan(itemC);
        assertEquals(checkout.getTotal(), 6.0);
    }
}