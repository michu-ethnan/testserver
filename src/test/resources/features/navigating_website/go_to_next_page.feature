Feature: Go to next page

  Customer should be able to go to a next page category page.

  Scenario: From category page

    Given that Gordon opens a category page
    When he clicks a pagination arrow
    Then he should go to that page

  Scenario: From collection page

    Given that Gordon is on a collection page
    When he clicks a pagination arrow
    Then he should go to that page

  Scenario: From search results page

    Given that Gordon searches for a mug
    And he sees the search results page
    When he clicks a pagination arrow
    Then he should go to that page


