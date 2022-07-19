Feature: Sort, refresh, select page, open pdp and return on category page

  Customer should be able to apply sort on category page, refresh, go to another page,
  open pdp, return and see that the sort is applied.

  Scenario: Apply Cena: od najwyższej sort  and refresh, select page and open pdp, category page
    Given that Maja opens the first category page
    When she applies Cena:_od_najwyższej filter
    And she reloads the page and ensures that Cena:_od_najwyższej is still applied
    When she inserts a page number from top
    Then she should be on the inserted page number
    And she refreshes the page and ensures that Cena:_od_najwyższej is still applied
    When she sees the first price
    And she sees the second price
    Then she should see that the sort is in descending order
    Then she returns to previous page and ensures the page number and Cena:_od_najwyższej sort
    Then she should be on the inserted page number

  Scenario: Apply Cena: od najniższej sort and refresh, select page and open pdp, category page
    Given that Maja opens the first category page
    When she applies Cena:_od_najniższej filter
    And she reloads the page and ensures that Cena:_od_najniższej is still applied
    When she inserts a page number from top
    Then she should be on the inserted page number
    And she refreshes the page and ensures that Cena:_od_najniższej is still applied
    When she sees the first price
    And she sees the second price
    Then she should ensure that the sort is in ascending order
    Then she returns to previous page and ensures the page number and Cena:_od_najniższej sort
    Then she should be on the inserted page number

  Scenario: Apply Wg nazwy Z-A sort and refresh, select page and open pdp, category page
    Given that Maja opens the first category page
    When she applies Wg_nazwy_Z-A filter
    And she reloads the page and ensures that Wg_nazwy_Z-A is still applied
    When she inserts a page number from top
    Then she should be on the inserted page number
    And she refreshes the page and ensures that Wg_nazwy_Z-A is still applied
    And she sees the first product name
    Then she returns to previous page and ensures the page number and Wg_nazwy_Z-A sort
    Then she should be on the inserted page number

  Scenario: Apply Wg nazwy A-Z sort and refresh, select page and open pdp, category page
    Given that Maja opens the first category page
    When she applies Wg_nazwy_A-Z filter
    And she reloads the page and ensures that Wg_nazwy_A-Z is still applied
    When she inserts a page number from top
    Then she should be on the inserted page number
    And she refreshes the page and ensures that Wg_nazwy_A-Z is still applied
    And she sees the first product name
    Then she returns to previous page and ensures the page number and Wg_nazwy_A-Z sort
    Then she should be on the inserted page number

  Scenario: Apply Cena katalogowa: od najwyższej sort, refresh, select page and open pdp, category page
    Given that Maja opens the first category page
    When she applies Cena_katalogowa:_od_najwyższej filter
    And she reloads the page and ensures that Cena_katalogowa:_od_najwyższej is still applied
    When she inserts a page number from top
    Then she should be on the inserted page number
    And she refreshes the page and ensures that Cena_katalogowa:_od_najwyższej is still applied
    When she sees the first catalog price
    And she sees the second catalog price
    Then she should see that the sort is in descending order
    Then she returns to previous page and ensures the page number and Cena_katalogowa:_od_najwyższej sort
    Then she should be on the inserted page number

  Scenario: Apply Cena katalogowa: od najniższej sort, refresh, select page and open pdp, category page
    Given that Maja opens the first category page
    When she applies Cena_katalogowa:_od_najniższej filter
    And she reloads the page and ensures that Cena_katalogowa:_od_najniższej is still applied
    When she inserts a page number from top
    Then she should be on the inserted page number
    And she refreshes the page and ensures that Cena_katalogowa:_od_najniższej is still applied
    When she sees the first catalog price
    And she sees the second catalog price
    Then she should ensure that the sort is in ascending order
    Then she returns to previous page and ensures the page number and Cena_katalogowa:_od_najniższej sort
    Then she should be on the inserted page number