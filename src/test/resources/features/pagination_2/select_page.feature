Feature: Select page

  Customer should be able to select a given page by page number.

  Scenario: Select page from category page, top
    Given that Patty is on a category page
    When she selects a page from top
    Then she should be on that page

  Scenario: Select page from category page, bottom
    Given that Patty is on a category page
    When she selects a page from bottom
    Then she should be on that page

  Scenario: Select page from collection page
    Given that Patty visits collection page
    When she selects a page from collection page
    Then she should be on the selected page number

  Scenario: Select page from search page, top
    Given that Patty looks for a armchair
    And she is on the search results page
    When she selects a page from top
    Then she should be on that page

  Scenario: Select page from search page, bottom
    Given that Patty looks for a armchair
    And she is on the search results page
    When she selects a page from bottom
    Then she should be on that page

  Scenario: Insert page number on search page, top
    Given that Patty looks for a armchair
    And she is on the search results page
    When she inserts a page number from top
    Then she should be on the inserted page number

  Scenario: Insert page number on search page, bottom
    Given that Patty looks for a armchair
    And she is on the search results page
    When she inserts a page number from bottom
    Then she should be on the inserted page number

  Scenario: Insert page number on category page, top
    Given that Patty is on a category page
    When she inserts a page number from top
    Then she should be on the inserted page number

  Scenario: Insert page number on category page, bottom
    Given that Patty is on a category page
    When she inserts a page number from bottom
    Then she should be on the inserted page number

  Scenario: Open pdp and return on category page
    Given that Patty is on a category page
    When she inserts a page number from top
    Then she should be on the inserted page number
    When she opens pdp and returns to previous page
    Then she should be on the inserted page number

  Scenario: Open pdp and return on search page
    Given that Patty looks for a armchair
    And she is on the search results page
    When she inserts a page number from top
    Then she should be on the inserted page number
    When she opens pdp and returns to previous page
    Then she should be on the inserted page number
