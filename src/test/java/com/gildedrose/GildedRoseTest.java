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
    @DisplayName("Aged brie increase double quality after sellIn day")
    void agedBrieDoubleIncreaseQualityTest() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals("Aged Brie", gildedRose.items[0].name);
        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    @DisplayName("Quality cannot exceed maximum")
    void qualityDoNotExceedMax() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 50)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals("Aged Brie", gildedRose.items[0].name);
        assertEquals(50, gildedRose.items[0].quality);
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


    @Test
    @DisplayName("Sulfuras does not modify sellIn date")
    void sulfurasDoesNotModifySellInDate(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", gildedRose.items[0].name);
        assertEquals(5, gildedRose.items[0].sellIn);
    }

    @Test
    @DisplayName("Sulfuras does not decrease quality")
    void sulfurasDoesNotDecreaseQuality(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals("Sulfuras, Hand of Ragnaros", gildedRose.items[0].name);
        assertEquals(80, gildedRose.items[0].quality);
    }

    @Test
    @DisplayName("backstagePasses decrease quality 10 days")
    void backstagePassesQualityDecreaseTenDays(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.items[0].name);
        assertEquals(22, gildedRose.items[0].quality);
    }

    @Test
    @DisplayName("Entrada al Backstage decrease quality 5 days")
    void backstagePassesQualityDecreaseFiveDays(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.items[0].name);
        assertEquals(23, gildedRose.items[0].quality);
    }

    @Test
    @DisplayName("backstagePasses decrease quality 0 days")
    void backstagePassesQualityDecreaseZeroDays(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertEquals("Backstage passes to a TAFKAL80ETC concert", gildedRose.items[0].name);
        assertEquals(0, gildedRose.items[0].quality);
    }
}
