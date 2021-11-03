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


   @Test
   void agedBrieTest() {
       Item[] items = new Item[] { new Item("Aged Brie", 5, 0) };
       GildedRose gildedRose = new GildedRose(items);
       gildedRose.updateQuality();

       assertEquals("Aged Brie", gildedRose.items[0].name);
       assertEquals(4, gildedRose.items[0].sellIn);
       assertEquals(1, gildedRose.items[0].quality);
   }

    @Test
    void negativeQuality() {
       Item[] items = new Item[] { new Item("Macbook", 10, 2) };
       GildedRose gildedRose = new GildedRose(items);

       //After 5 days
       for(int i = 0; i < 5; i++) {
           gildedRose.updateQuality();
       }

       assertEquals("Macbook", gildedRose.items[0].name);
       assertEquals(5, gildedRose.items[0].sellIn);
       assertEquals(0, gildedRose.items[0].quality);
   }

}
