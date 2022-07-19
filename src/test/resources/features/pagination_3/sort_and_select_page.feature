Feature: Sort and select page

A customer should be able to sort and select pages

  Scenario: Sort products with price by descending order and select page from top, category page
    Given that Maja opens the first category page
    When she applies Cena:_od_najwyższej filter
    When she inserts a page number from top
    Then she should be on the inserted page number
    And she sees the first price
    And she sees the second price
    Then she should see that the sort is in descending order

  Scenario: Sort products with price by descending order and select page from top, search page
    Given that Maja attempts to search for a "mug"
    When she applies Cena:_od_najwyższej filter on search page
    When she inserts a page number from top
    Then she should be on the inserted page number
    And she sees the first price
    And she sees the second price
    Then she should see that the sort is in descending order

  Scenario: Sort products with price by ascending order and select page from top, category page
    Given that Maja opens the first category page
    When she applies Cena:_od_najniższej filter
    When she inserts a page number from top
    Then she should be on the inserted page number
    And she sees the first price
    And she sees the second price
    Then she should ensure that the sort is in ascending order

  Scenario: Sort products with price by ascending order select page from top, search page
    Given that Maja attempts to search for a "mug"
    When she applies Cena:_od_najniższej filter on search page
    When she inserts a page number from top
    Then she should be on the inserted page number
    And she sees the first price
    And she sees the second price
    Then she should ensure that the sort is in ascending order


  Scenario: Sort products with price by descending order and select page from bottom, category page
    Given that Maja opens the first category page
    When she applies Cena:_od_najwyższej filter
    When she inserts a page number from bottom
    Then she should be on the inserted page number
    And she sees the first price
    And she sees the second price
    Then she should see that the sort is in descending order

  Scenario: Sort products with price by descending order and select page from bottom, search page
    Given that Maja attempts to search for a "mug"
    When she applies Cena:_od_najwyższej filter on search page
    When she inserts a page number from bottom
    Then she should be on the inserted page number
    And she sees the first price
    And she sees the second price
    Then she should see that the sort is in descending order

  Scenario: Sort products with price by ascending order and select page from bottom, category page
    Given that Maja opens the first category page
    When she applies Cena:_od_najniższej filter
    When she inserts a page number from bottom
    Then she should be on the inserted page number
    And she sees the first price
    And she sees the second price
    Then she should ensure that the sort is in ascending order

  Scenario: Sort products with price by ascending order and select page from bottom, search page
    Given that Maja attempts to search for a "mug"
    When she applies Cena:_od_najniższej filter on search page
    When she inserts a page number from bottom
    Then she should be on the inserted page number
    And she sees the first price
    And she sees the second price
    Then she should ensure that the sort is in ascending order