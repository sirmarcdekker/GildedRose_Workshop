package com.gildedrose.items;

public class BackstagePassItem extends Item {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePassItem(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    protected void updateQualityOnSellInBelowZero() {
        setQualityToZero();
    }

    @Override
    protected void standardDailyQualityUpdate() {
        increaseQuality();
        if (this.sellInDays < 11) {
            increaseQuality();
            if (this.sellInDays < 6) {
                increaseQuality();
            }
        }
    }
}
