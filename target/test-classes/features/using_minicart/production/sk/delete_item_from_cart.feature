Feature: Delete from cart SK

  A customer should be able to delete a product from cart.

  Scenario: Should be able to
    Given that Jane has a hrnček in minicart on SK
    When she deletes it
    Then she should see "the cart is empty message_SK"