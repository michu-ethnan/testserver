Feature: Calculate total sum in minicart ES

  The total sum in minicart should equal a number of products multiplied by their price. A customer should be able to
  see that the price is calculated correctly.

  Scenario: Should be able to

    Given that Cassie is on the product page on ES
    And she sees a product price
    When the total sum in minicart is calculated
    Then she should see that it is correct