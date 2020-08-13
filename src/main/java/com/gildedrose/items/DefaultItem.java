package com.gildedrose.items;

public class DefaultItem extends Item {
    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void standardDailyQualityUpdate() {
        decreaseQuality();
    }

    @Override
    protected void updateQualityOnSellInBelowZero() {
        decreaseQuality();
    }

}
