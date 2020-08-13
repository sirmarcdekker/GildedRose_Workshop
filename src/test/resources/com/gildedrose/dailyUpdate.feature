Feature: Daily Update

  Scenario Outline: Update an item
    Given <name> has a quality of <qualityIn> and a sell in of <dateIn>
    When Quality is updated <daysPassing> times
    Then <name> should have quality of <qualityOut> and sell in of <dateOut>

    Examples:
      | name                                        | qualityIn | dateIn | daysPassing | qualityOut | dateOut |
      | "Pizza"                                     | 20        | 30     | 1           | 19         | 29      |
      | "Raviloli"                                  | 20        | 30     | 2           | 18         | 28      |
      | "Hotdog"                                    | 20        | 0      | 1           | 18         | -1      |
      | "Coffee"                                    | 0         | 0      | 1           | 0          | -1      |
      | "Aged Brie"                                 | 10        | 10     | 1           | 11         | 9       |
      | "Sulfuras, Hand of Ragnaros"                | 30        | 30     | 10          | 30         | 30      |
      | "Backstage passes to a TAFKAL80ETC concert" | 30        | 20     | 1           | 31         | 19      |
      | "Backstage passes to a TAFKAL80ETC concert" | 30        | 11     | 1           | 31         | 10      |
      | "Backstage passes to a TAFKAL80ETC concert" | 30        | 10     | 1           | 32         | 9       |
      | "Backstage passes to a TAFKAL80ETC concert" | 30        | 6      | 1           | 32         | 5       |
      | "Backstage passes to a TAFKAL80ETC concert" | 30        | 5      | 1           | 33         | 4       |
      | "Backstage passes to a TAFKAL80ETC concert" | 30        | 1      | 1           | 33         | 0       |
      | "Backstage passes to a TAFKAL80ETC concert" | 30        | 0      | 1           | 0          | -1      |