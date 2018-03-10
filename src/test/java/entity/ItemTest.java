package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    void create_an_item_without_ruleId() {
        Item item = Item.create("A", 50.0);
        assertEquals(item.getSku(), "A");
        assertEquals(item.getUnitPrice(), 50.0);
    }

    @Test
    void create_an_item_with_ruleId() {
        Item item = Item.create("A", 50.0, 1);
        assertEquals(item.getSku(), "A");
        assertEquals(item.getUnitPrice(), 50.0);
        assertEquals(item.getRuleId(), 1);
    }

}