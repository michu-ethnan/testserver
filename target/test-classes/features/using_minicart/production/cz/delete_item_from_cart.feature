Feature: Delete from cart CZ

  A customer should be able to delete a product from cart.

  Scenario: Should be able to
    Given that Jane has a Zahrada in minicart on CZ
    When she deletes it
    Then she should see "the cart is empty message_CZ"