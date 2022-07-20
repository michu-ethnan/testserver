Feature: Apply all sorts


  Scenario: Cena: od najwyższej, category page
    Given that Maja opens the first category page
    When she applies Cena:_od_najwyższej filter
    And she sees the first price
    And she sees the second price
    Then she should see that the sort is in descending order

  Scenario: Cena: od najniższej, category page
    Given that Maja opens the first category page
    When she applies Cena:_od_najniższej filter
    And she sees the first price
    And she sees the second price
    Then she should ensure that the sort is in ascending order

  Scenario: Wg nazwy Z-A, category page
    Given that Maja opens the first category page
    When she applies Wg_nazwy_Z-A filter
    And she sees the first product name


  Scenario: Wg nazwy A-Z, category page
    Given that Maja opens the first category page
    When she applies Wg_nazwy_A-Z filter
    And she sees the first product name


  Scenario: Cena katalogowa: od najwyższej, category page
    Given that Maja opens the first category page
    When she applies Cena_katalogowa:_od_najwyższej filter
    When she sees the first catalog price
    And she sees the second catalog price
    Then she should see that the sort is in descending order

  Scenario: Cena katalogowa: od najniższej, category page
    Given that Maja opens the first category page
    When she applies Cena_katalogowa:_od_najniższej filter
    When she sees the first catalog price
    And she sees the second catalog price
    Then she should ensure that the sort is in ascending order


  Scenario: Wg nazwy Z-A, search page
    Given that Maja attempts to search for a "mug"
    When she applies Wg_nazwy_Z-A filter on search page
    And she sees the first product name


  Scenario: Wg nazwy A-Z, search page
    Given that Maja attempts to search for a "mug"
    When she applies Wg_nazwy_A-Z filter on search page
    And she sees the first product name


  Scenario: Cena: od najwyższej, search page
    Given that Maja attempts to search for a "mug"
    When she applies Cena:_od_najwyższej filter on search page
    And she sees the first price
    And she sees the second price
    Then she should see that the sort is in descending order search page

  Scenario: Cena: od najniższej, search page
    Given that Maja attempts to search for a "mug"
    When she applies Cena:_od_najniższej filter on search page
    And she sees the first price
    And she sees the second price
    Then she should ensure that the sort is in ascending order search page

  Scenario: Cena katalogowa: od najwyższej, search page
    Given that Maja attempts to search for a "mug"
    When she applies Cena_katalogowa:_od_najwyższej filter on search page
    When she sees the first catalog price
    And she sees the second catalog price
    Then she should see that the sort is in descending order search page

  Scenario:Cena katalogowa: od najniższej, search page
    Given that Maja attempts to search for a "mug"
    When she applies Cena_katalogowa:_od_najniższej filter on search page
    When she sees the first catalog price
    And she sees the second catalog price
    Then she should ensure that the sort is in ascending order search page






