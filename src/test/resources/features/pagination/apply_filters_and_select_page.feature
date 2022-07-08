Feature: Apply filters and select page

  Customer should be able select a page after applying filters.

  Scenario: On category page
    Given that Philip arrives to a category page
    When he applies some filter
    When she inserts a page number from top
    Then she should be on the inserted page number
    Then she should see that she's on the next page and the filter is still applied

  Scenario: On search page
    Given that Philip attempts to find a armchair
    And he arrives to the search results page
    When he applies some filter
    When she inserts a page number from top
    Then she should be on the inserted page number
    Then she should see that she's on the next page and the filter is still applied


  Scenario: Apply two filters manually and select page on category page
    Given that Philip arrives to a category page
    When he applies two filters
    And she ensures that pagination button is present
    And she selects a page number
    Then she should be on the selected page number and the filter is still applied
    When she returns to previous page
    Then she ensures that pagination button is present


  Scenario: Apply two filters manually and select page on search page
    Given that Maja looks for a armchair
    When he applies two filters
    And she ensures that pagination button is present
    And she selects a page number
    Then she should be on the selected page number and the filter is still applied
    When she returns to previous page
    Then she ensures that pagination button is present


