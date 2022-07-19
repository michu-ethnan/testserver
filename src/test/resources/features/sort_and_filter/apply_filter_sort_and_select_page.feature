Feature: Apply filter, sort products and select page

  Scenario: apply two filters, sort, select page, open pdp and return - category page
    Given that Laura is on a certain category page
    When she applies a certain filter and checks number of products
    And she applies the second filter
    And she applies Cena:_od_najwyższej filter
    And she reloads the page and ensures that Cena:_od_najwyższej is still applied
    When she inserts a page number from top
    Then she should be on the inserted page number
    And she refreshes the page and ensures that Cena:_od_najwyższej is still applied
    When she sees the first price
    And she sees the second price
    Then she should see that the sort is in descending order search page
    Then she returns to previous page and ensures the page number and Cena:_od_najwyższej sort
    Then she should be on the inserted page number
    Then she should ensure that Cena:_od_najwyższej and filter are still applied

  Scenario: apply two filters, sort, select page, open pdp and return - search-page
    Given that Maja attempts to search for a "armchair"
    When she applies a certain filter and checks number of products on search page
    And she applies the second filter on search page
    And she applies Cena:_od_najwyższej filter on search page
    And she reloads the page and ensures that Cena:_od_najwyższej is still applied
    When she sees the first price
    And she sees the second price
    Then she should see that the sort is in descending order search page
    Then she returns to previous page and ensures the page number and Cena:_od_najwyższej sort
    Then she should ensure that Cena:_od_najwyższej and filter are still applied on search page

