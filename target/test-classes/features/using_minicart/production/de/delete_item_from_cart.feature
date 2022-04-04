Feature: Delete from cart DE

  A customer should be able to delete a product from cart.

  Scenario: Should be able to
    Given that Jane has a becher in minicart on DE
    When she deletes it
    Then she should see "the cart is empty message_DE"