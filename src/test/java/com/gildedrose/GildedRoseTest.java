package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    @Test
    @DisplayName("Aged brie increase quality everyday")
    void agedBrieIncreaseQualityTest() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals("Aged Brie", gildedRose.items[0].name);
        assertEquals(1, gildedRose.items[0].quality);
    }


    @Test
    @DisplayName("Quality cannot be negative")
    void nonNegativeQuality() {
        Item[] items = new Item[]{new Item("Macbook", 10, 0)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals("Macbook", gildedRose.items[0].name);
        assertEquals(0, gildedRose.items[0].quality);
    }


    @Test
    @DisplayName("Item Quality decrease x2 when sellIn time expires")
    void itemQualityDoubleDecreaseAfterSellInExpires() {
        Item[] items = new Item[]{new Item("Thori'dal The Stars Fury", 0, 50)};
        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateQuality();

        assertEquals("Thori'dal The Stars Fury", gildedRose.items[0].name);
        assertEquals(48, gildedRose.items[0].quality);
    }

}
