Feature: Change the number of products in minicart SK

  Customer should be able to change the number of products in minicart.

  Scenario: Should change the number of products in minicart

    Given that Laura has a hrnček in the cart on SK
    When she tries to increase the number of products
    Then she should see that the number is greater_SK

    Scenario: Should change the number of products in minicart

      Given that Laura has a hrnček in the cart on SK
      When she tries to increase the number of products
      And then she tries to decrease the number of products
      Then she should see that the number is smaller_SK