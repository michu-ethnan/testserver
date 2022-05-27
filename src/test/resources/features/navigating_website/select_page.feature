Feature: Change page

  Customer should be able to select a given page.

  Scenario: From category page

    Given that Patty is on a category page
    When she selects a page
    Then she should be on that page

  Scenario:  From collection page

    Given that Patty visits collection page
    When she selects a page
    Then she should be on that page

  Scenario: From search results page

    Given that Patty looks for a mug
    And she is on the search results page
    When she selects a page
    Then she should be on that page
