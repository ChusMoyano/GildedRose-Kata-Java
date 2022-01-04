package com.gildedrose.itemsCategories;

import com.gildedrose.Item;

public class BackstagePassesItem extends Item {

    public BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void modifyQuality() {
        decreaseSellInDate();
        if (sellIn < 0) {
            quality = 0;
        } else {
            if (sellIn > 10) {
                quality = quality + 1;
            } else if (sellIn > 5) {
                quality = quality + 2;
            } else {
                quality = quality + 3;
            }

        }
    }
}
