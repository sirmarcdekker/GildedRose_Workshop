package com.gildedrose;

public class Item {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public String name;

    public int sellInDays;

    private int quality;

    public Item(String name, int sellInDays, int quality) {
        this.name = name;
        this.sellInDays = sellInDays;
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public void setQualityToZero() {
        this.quality = MIN_QUALITY;
    }

    public void increaseQuality() {
        this.quality = Math.min(MAX_QUALITY, this.quality + 1);
    }

    public void decreaseQuality() {
        this.quality = Math.max(MIN_QUALITY, this.quality - 1);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellInDays + ", " + this.quality;
    }
}
