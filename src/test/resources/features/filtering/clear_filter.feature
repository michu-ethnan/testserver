Feature: Clear filter

  A customer should be able to clear filters after applying them.

  Scenario: Clear filter

    Given that Clay happens to be on a category page
    When he applies a filter
    And then he clears filters
    Then he should see that the filter is not applied