Feature: Delete from cart

  A customer should be able to delete a product from cart.

  Scenario: Should be able to
    Given that Jane has a mug in minicart on testServerWeber
    When she deletes it
    Then she should see "the cart is empty message"