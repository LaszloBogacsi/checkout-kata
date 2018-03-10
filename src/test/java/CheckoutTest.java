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

    @BeforeEach
    void setUp() {
        List<Rule> rules = new ArrayList<>();
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
        Item item = Item.create("A", 1.0);
        checkout.scan(item);
        assertEquals(checkout.getBasket().size(), 1);
    }

    @Test
    void can_calculate_total() {
        checkout = new Checkout(rules);
        Item item = Item.create("A", 1.0);
        checkout.scan(item);
        checkout.scan(item);
        assertEquals(checkout.getTotal(), 2.0);
    }


}