Feature: Add two different products and calculate the total sum in minicart IT

  After adding two different products, the customer should see that the total sum in minicart is correct.

  Scenario: Should be able to

    Given that Adeline has two products in cart on IT
    When she checks their price
    Then she should see that the total sum is correct