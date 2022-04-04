Feature: Change the number of products in minicart FR

  Customer should be able to change the number of products in minicart.

  Scenario: Should change the number of products in minicart

    Given that Laura has a Jardin in the cart on FR
    When she tries to increase the number of products
    Then she should see that the number is greater_FR

    Scenario: Should change the number of products in minicart

      Given that Laura has a Jardin in the cart on FR
      When she tries to increase the number of products
      And then she tries to decrease the number of products
      Then she should see that the number is smaller_FR