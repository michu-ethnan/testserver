Feature: Delete from cart ES

  A customer should be able to delete a product from cart.

  Scenario: Should be able to
    Given that Jane has a Jardín in minicart on ES
    When she deletes it
    Then she should see "the cart is empty message_ES"