package com.gildedrose;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GildedRoseSteps {
    private GildedRose app;

    @Given("^\"([^\"]*)\" has a quality of (-?\\d+) and a sell in of (-?\\d+)$")
    public void hasAQualityOfAndASellInOf(String name, Integer quality, Integer sellIn) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        app = new GildedRose(items);
    }

    @When("^Quality is updated (\\d+) times$")
    public void qualityIsUpdatedTimeS(Integer times) {
        for (int i = 0; i < times; i++) {
            app.dailyQualityUpdate();
        }
    }

    @Then("^\"([^\"]*)\" should have quality of (-?\\d+) and sell in of (-?\\d+)$")
    public void shouldHaveQualityOfAndSellInOf(String name, Integer quality, Integer sellIn) {
        Optional<Item> item = Arrays.stream(app.items).filter(i -> i.name.equals(name)).findFirst();
        Assert.assertTrue(item.isPresent());
        Item actualItem = item.get();
        assertThat(actualItem.getQuality(), equalTo(quality));
        assertThat(actualItem.sellInDays, equalTo(sellIn));
    }
}
