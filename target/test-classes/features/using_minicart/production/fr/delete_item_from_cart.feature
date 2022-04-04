Feature: Delete from cart FR

  A customer should be able to delete a product from cart.

  Scenario: Should be able to
    Given that Jane has a Jardin in minicart on FR
    When she deletes it
    Then she should see "the cart is empty message_FR"