Feature: See more pics on PDP

  A customer should be able to see more pictures on the PDP if there are more than 10.

  Scenario: Should be able to

    Given that Priscilla sees that there are more than 10 pictures on the PDP
    When she clicks the right arrow
    Then she should notice that the right arrow disappears if there are no more pictures

  Scenario: Should be able to

    Given that Priscilla sees that there are more than 10 pictures on the PDP
    When she clicks the right arrow
    And she clicks the left arrow
    Then she should see that the left arrow disappears after returning to the first page