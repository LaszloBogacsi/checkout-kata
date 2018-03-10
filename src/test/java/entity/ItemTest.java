package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    void create_an_item_with_valid_properties() {
        Item item = Item.create("A", 50.0);
        assertEquals(item.getSku(), "A");
        assertEquals(item.getUnitPrice(), 50.0);
    }

}