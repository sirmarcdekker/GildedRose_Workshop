package com.gildedrose;

import com.gildedrose.items.Item;

import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void dailyQualityUpdate() {
        Arrays.stream(items).forEach(Item::dailyUpdate);
    }
}