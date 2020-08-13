package com.gildedrose;

class GildedRose {
    private static final String NAME_SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String NAME_AGED_BRIE = "Aged Brie";
    private static final String NAME_BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void dailyQualityUpdate() {
        for (Item item : items) {
            if (item.name.equals(NAME_SULFURAS)) {
                continue;
            }
            standardDailyQualityUpdate(item);

            item.sellInDays = item.sellInDays - 1;

            if (item.sellInDays < 0) {
                updateQualitySellInBelowZero(item);
            }
        }
    }

    private void standardDailyQualityUpdate(Item item) {
        if (!item.name.equals(NAME_AGED_BRIE) && !item.name.equals(NAME_BACKSTAGE_PASS)) {
            item.decreaseQuality();
            return;
        }

        item.increaseQuality();

        if (item.name.equals(NAME_BACKSTAGE_PASS)) {
            if (item.sellInDays < 11) {
                item.increaseQuality();
                if (item.sellInDays < 6) {
                    item.increaseQuality();
                }
            }
        }
    }

    private void updateQualitySellInBelowZero(Item item) {
        if (item.name.equals(NAME_AGED_BRIE)) {
            item.increaseQuality();
            return;
        }
        if (item.name.equals(NAME_BACKSTAGE_PASS)) {
            item.setQualityToZero();
            return;
        }
        item.setQualityToZero();
    }
}