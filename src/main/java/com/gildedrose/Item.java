package com.gildedrose;

public class Item {

    public String name;

    public int sellInDays;

    public int quality;

    public Item(String name, int sellInDays, int quality) {
        this.name = name;
        this.sellInDays = sellInDays;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellInDays + ", " + this.quality;
    }
}
