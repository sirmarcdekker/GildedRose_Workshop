package com.gildedrose;

class GildedRose {
    private static final String NAME_SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String NAME_AGED_BRIE = "Aged Brie";
    private static final String NAME_BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void dailyQualityUpdate() {
        for (Item item : items) {
            if (item.name.equals(NAME_SULFURAS)) {
                continue;
            }
            if (!item.name.equals(NAME_AGED_BRIE)
                    && !item.name.equals(NAME_BACKSTAGE_PASS)) {
                if (item.quality > MIN_QUALITY) {
                    item.quality = item.quality - 1;

                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(NAME_BACKSTAGE_PASS)) {
                        if (item.sellInDays < 11) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellInDays < 6) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            item.sellInDays = item.sellInDays - 1;

            if (item.sellInDays < 0) {
                if (!item.name.equals(NAME_AGED_BRIE)) {
                    if (!item.name.equals(NAME_BACKSTAGE_PASS)) {
                        if (item.quality > MIN_QUALITY) {
                            item.quality = item.quality - 1;

                        }
                    } else {
                        item.quality = MIN_QUALITY;
                    }
                } else {
                    if (item.quality < MAX_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}