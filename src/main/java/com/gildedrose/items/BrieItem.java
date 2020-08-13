package com.gildedrose.items;

public class BrieItem extends Item {
    public static final String NAME = "Aged Brie";

    public BrieItem(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    protected void updateQualityOnSellInBelowZero() {
        increaseQuality();
    }

    @Override
    protected void standardDailyQualityUpdate() {
        increaseQuality();
    }
}
