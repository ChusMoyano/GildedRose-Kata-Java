package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void fooTest() {
        Item[] items = new Item[] { new Item("MacbookPro", 20, 50) };
        GildedRose app = new GildedRose(items);
        for (int i=0; i<10; i++) {
            //After passing 10 days
            app.updateQuality();
        }
        assertEquals("MacbookPro", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(40, app.items[0].quality);
    }

}
