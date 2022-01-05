package com.gildedrose.itemsCategories;

import com.gildedrose.Item;

public class UnclassifiedItem extends Item {

    public UnclassifiedItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void modifyQuality() {
        if (sellIn < 0) {
            quality = quality - 2;
        } else {
            quality = quality - 1;
        }

        if (quality < 0) {
            quality = 0;
        }

    }
}
