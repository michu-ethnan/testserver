Feature: Delete from cart SE

  A customer should be able to delete a product from cart.

  Scenario: Should be able to
    Given that Jane has a mugg in minicart on SE
    When she deletes it
    Then she should see "the cart is empty message_SE"