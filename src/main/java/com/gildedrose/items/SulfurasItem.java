package com.gildedrose.items;

public class SulfurasItem extends Item {
    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    public SulfurasItem(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }


    @Override
    public void dailyUpdate() {
    }

    @Override
    protected void updateQualityOnSellInBelowZero() {
    }

    @Override
    protected void standardDailyQualityUpdate() {
    }
}
